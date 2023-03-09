//int en = 11;  //디지털 11번핀 -> 속도 조절 핀으로 설정
int in = 5;   //디지털 4번핀 -> 정방향 회전 출력 핀으로 설정
int out = 6;  //디지털 5번핀 -> 역방향 회전 출력 핀으로 설정
int p_in = 2; //디지털 2번핀 -> 정방향 회전 입력 핀으로 설정
int p_out = 3;//디지털 3번핀 -> 역방향 회전 입력 핀으로 설정
int sp = 255;  //모터 회전속도 : 255
int r = 7;

void setup() {
  pinMode(in, OUTPUT);  //정방향 회전 출력 핀 -> 출력핀으로 설정
  pinMode(out, OUTPUT); //역방향 회전 출력 핀 -> 출력핀으로 설정
  pinMode(p_in, INPUT); //정방향 회전 입력 핀 -> 입력핀으로 설정
  pinMode(p_out, INPUT);//역방향 회전 입력 핀 -> 입력핀으로 설정
  pinMode(r, OUTPUT);
}

void loop() {
  if(digitalRead(p_in) == 0 && digitalRead(p_out) == 1){
    //정방향 회전 명령이 입력되고, 역방향 회전 명령이 입력되지 않음
    digitalWrite(r, LOW);
    analogWrite(in, sp); //정방향 회전 수행
  } else if(digitalRead(p_out) == 0 && digitalRead(p_in) == 1){
    //역방향 회전 명령이 입력되고, 정방향 회전 명령이 입력되지 않음
    digitalWrite(r, LOW);
    analogWrite(out, sp);//역방향 회전 수행
  } else {
    //그 외
    analogWrite(in, 0);  //정방향 회전 정지
    analogWrite(out, 0); //역방향 회전 정지
    digitalWrite(r, HIGH);
  }
}
