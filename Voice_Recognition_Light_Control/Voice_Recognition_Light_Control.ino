/*
    This sketch demonstrates how to set up a simple HTTP-like server.
    The server will set a GPIO pin depending on the request
      http://server_ip/gpio/0 will set the GPIO2 low,
      http://server_ip/gpio/1 will set the GPIO2 high
    server_ip is the IP address of the ESP8266 module, will be
    printed to Serial when the module is connected.
*/

#include <ESP8266WiFi.h>
#include <Servo.h>

#ifndef STASSID
#define STASSID "SK_WiFiGIGAF950"
#define STAPSK  "1905023577"
#endif

// 서보모터 디지털 핀 번호
#define SERVO_PIN  D2  

// Servo 객체 생성
Servo        servo;       

const char* ssid = STASSID;
const char* password = STAPSK;

// 서보모터 포지션(각도) 값
int DEFAULT_POS    = 75;
int TURN_ON_POS    = 120;
int TURN_OFF_POS   = 20;

// 서버 인스턴스 만들기
// 수신 할 포트를 인수로 지정
WiFiServer server(80);

void setup() {
  Serial.begin(115200);

  // 서보모터 초기 설정
//  pinMode(SERVO_PIN, OUTPUT);
  servo.attach(2);
  servo.write(DEFAULT_POS);

  // WiFi 네트워크에 연결
  Serial.println();
  Serial.println();
  Serial.print(F("Connecting to "));
  Serial.println(ssid);

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(F("."));
  }
  Serial.println();
  Serial.println(F("WiFi connected"));

  // 서버 시작
  server.begin();
  Serial.println(F("Server started"));

  // IP 주소 인쇄
  Serial.println(WiFi.localIP());
}

void loop() {
  // 클라이언트가 연결되었는지 확인
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
  Serial.println(F("new client"));

  client.setTimeout(5000); // 기본값 1000

  // 요청 첫 번째 줄 읽기
  String req = client.readStringUntil('\r');
  Serial.println(F("request: "));
  Serial.println(req);

  // 요청과 일치시
  int val;
  if (req.indexOf(F("/gpio/0")) != -1) {
    turnOn();
    val = 0;
  } else if (req.indexOf(F("/gpio/1")) != -1) {
    turnOff();
    val = 1;
  }

  // 나머지 요청 읽기 / 무시
  // client.flush ()하지 마십시오 : 출력 전용입니다. 아래를 참조하십시오.
  while (client.available()) {
    // 바이트 단위는 그다지 효율적이지 않습니다.
    client.read();
  }

  // 클라이언트에 응답 보내기
  // 여러 개의 작은 client.print / write에 대해 괜찮습니다.
  // nagle 알고리즘이 하나의 패킷으로 그룹화하기 때문에
  client.print(F("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<!DOCTYPE HTML>\r\n<html>\r\nLIGHT is now "));
  client.print((val) ? F("high") : F("low"));
  client.print(F("<br><br>Click <a href='http://"));
  client.print(WiFi.localIP());
  client.print(F("/gpio/1'>here</a> to switch LIGHT on, or <a href='http://"));
  client.print(WiFi.localIP());
  client.print(F("/gpio/0'>here</a> to switch LIGHT off.</html>"));

  // 클라이언트는 실제로 * 플러시 * 된 다음 연결이 끊어집니다.
  // 함수가 반환되고 '클라이언트'개체가 소멸 될 때 (범위 외)
  // 플러시 = 기록 된 데이터가 다른 쪽에서 수신되는지 확인
  Serial.println(F("Disconnecting from client"));
}

/*
  # 서보모터 이동
  지동 포지션으로 이동하고 1초 후 기존 포지션으로 복귀
*/
void turnOn() {
  servo.write(TURN_ON_POS);
  delay(700);
  servo.write(DEFAULT_POS);
  delay(10);
}

void turnOff() {
  servo.write(TURN_OFF_POS);
  delay(700);
  servo.write(DEFAULT_POS);
  delay(10);
}
