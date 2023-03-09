#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>

RF24 radio(7, 8); // SPI 버스에 nRF24L01 라디오를 설정하기 위해 CE, CSN를 선언.
const byte address[6] = "00001"; //주소값을 5가지 문자열로 변경할 수 있으며, 송신기와 수신기가 동일한 주소로 해야됨.

// 인체감지센서를 3번핀으로 설정합니다.
int motion = 3;

void setup() {
  radio.begin();
  radio.openWritingPipe(address); //이전에 설정한 5글자 문자열인 데이터를 보낼 수신의 주소를 설정
  radio.setPALevel(RF24_PA_MAX); //전원공급에 관한 파워레벨을 설정합니다. 모듈 사이가 가까우면 최소로 설정합니다.
  radio.stopListening();  //모듈을 송신기로 설정
  
  // 인체감지센서의 핀을 INPUT으로 설정합니다.
  pinMode(motion, INPUT);
  
  // 시리얼 통신 속도 설정
  Serial.begin(9600);
}

void loop() {
  // 적외선 인체감지 센서에서 값을 읽는다
  int sensor = digitalRead(motion);
  if(sensor == 1) {
    const char text[] = "1";
    radio.write(&text, sizeof(text)); //해당 메시지를 수신자에게 보냄
  }

//  // 센서값을 시리얼 모니터에 출력
//  Serial.println(sensor);
//  delay(500);
}
