int soil = A0; //토양습도센서
int Relaypin = 3; //릴레이 모듈(워터 펌프)
void setup() {
  Serial.begin(9600);
  pinMode(Relaypin, OUTPUT); //릴레이모듈 타입 아웃풋
}

void loop() {
  if(analogRead(soil) > 500) { // 습도센서 값이 500 이상이라면 (토양이 말라있다면)
      digitalWrite(Relaypin, HIGH);( //릴레이모듈(워터펌프) 켜기
      delay(20000);20초 동안 딜레이 (20초동안 물주기
      digitalWrite(Relaypin, LOW); //릴레이모듈(워터펌프) 끄기
    }
  Serial.println(analogRead(soil)); //토양센서값 시리얼 모니터에 표시
}
