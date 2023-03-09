#include <SPI.h> 
#include <nRF24L01.h>
#include <RF24.h>

RF24 radio(7, 8); // SPI 버스에 nRF24L01 라디오를 설정하기 위해 CE, CSN 선언.
const byte address[6] = "00001"; //주소값을 5가지 문자열로 변경할 수 있으며, 송신기과 수신기가 동일한 주소로 해야됨.
int led = 3;

void setup() {
  Serial.begin(9600);
  radio.begin();
  radio.openReadingPipe(0, address);
  radio.setPALevel(RF24_PA_MAX); //전원공급에 관한 파워레벨을 설정합니다. 모듈 사이가 가까우면 최소로 설정합니다.
  radio.startListening(); //모듈을 수신기로 설정
  pinMode(led, OUTPUT);
}
void loop() {
  if (radio.available()) {
    char text[32] = "";
    radio.read(&text, sizeof(text));
    digitalWrite(led, HIGH);
    Serial.println(text);
    delay(5);
    digitalWrite(led, LOW);
  }
}
