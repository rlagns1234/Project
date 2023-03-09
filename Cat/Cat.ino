
//라이브러리 추가
#include "DM_G_I2C.h" 
#include <SPI.h> 
#include <Wire.h> 
#include <Adafruit_GFX.h> 
#include <Adafruit_SSD1306.h>

//센서, 모듈 변수
int g = 2;  //진동모듈
int p = 3;  //피에조부저
int b = 8;  //버튼
int l = 5;  //레이저
int m = 6;  //인체감지센서

int Lr = 13; //LED red
int Lg = 12; //LED green
int Lb = 11;  //LED blue
int t = 10; //Trig
int e = 9;  //Echo

//기타 변수
int on; //버튼 on off
int mm; //인체감지 참, 거짓
float distance;  //초음파센서 거리
float d_save;  //초음파센서 확정값
float d_result;  //초음파센서 가변값
int f;  //난수 변수
String face[] = {"'_'","`_`","^_^",">o<","#_#","$_$","=_=","`~`","*#*","@O@","-3-"};

void setup() {
  Serial.begin(9600); //시리얼 모니터 통신속도 9600
  pinMode(g, OUTPUT); //진동모듈 아웃풋 설정
  pinMode(p, OUTPUT); //피에조부저 아웃풋 설정
  pinMode(b, INPUT); //버튼 인풋 설정
  pinMode(Lr, OUTPUT);  //LED red 아웃풋 설정
  pinMode(Lg, OUTPUT);  //LED green 아웃풋 설정
  pinMode(Lb, OUTPUT);   //LED blue 아웃풋 설정
  pinMode(l, OUTPUT);   //레이저 아웃풋 설정
  pinMode(t, OUTPUT);   //Trig 아웃풋 설정
  pinMode(e, INPUT);   //Echo 인풋 설정
  pinMode(m, INPUT);  //인체감지센서 인풋 설정      
 //I2C스캐널를 통해 현재 회로가 연결 됬는지 확인
  G_I2C_Scanner(); delay(1000); 
 //OLED 초기설정 
  OLED_SETUP();
  on = 0; //시스템 초기 설정 off
  mm = 0; //움직임 초기 설정 false
}

void loop() {    
  //버튼이 눌렸는지 확인
  if(digitalRead(b) == HIGH){
    if(on == 0){ //on
      on = 1;
      dOn();//"ON" LCD에 띄우기
      f = random(12);  //f를 0이상 11이하의 난수로 지정
    }else if(on == 1){  //off
      on = 0;
      dOff();//"OFF" LCD에 띄우기
    }
  }

  if(on == 1){  //시스템 활성화                               
    setColor(0,0,255);  //초록불
    digitalWrite(l, LOW); //레이저 끄기
    ultrasonicWave(); //초음파 발사
    d_result = distance;  //가변값 저장
    moveSensor(); //움직임 감지
//    delay(100);
  } else if(on == 0){ //시스템 비활성화
    setColor(255,0,0);  //빨간불
    digitalWrite(l, HIGH);  //레이저 켜기
    ultrasonicWave(); //초음파 발사
    d_save = distance;  //확정값 저장
    dU(); //초음파 센서 거리 띄우기
    deWarning();  //경고 off
//    Serial.println(d_save); 
//    delay(100);
  }

  if(on == 1 && mm == 1){ //시스템이 활성화되있고 움직임이 감지되었다면
    if(d_save - 10 > d_result || d_save + 10 < d_result){ //가변값이 확정값 범위 밖이라면
      onWarning();  //경고 on
      ultrasonicWave(); //초음파 발사
      d_save = distance;  //초음파 센서값 수정
      mm = 0;
  //      Serial.println(d_result);
    }                                                                                                                                                                                                          
  }else if(on == 1){ //시스템이 활성화되있고 움직임이 감지되지않았다면
    dPlay();  //얼굴 띄우기
    deWarning();  //경고 off
//    Serial.println(d_result);
//    delay(100);
  }
}

//LED 색상 변경 함수
void setColor(int red, int green, int blue){
  analogWrite(Lr, red);
  analogWrite(Lg, green);
  analogWrite(Lb, blue); 
}

//초음파 발사 & 거리 측정 함수
void ultrasonicWave(){
    // 초음파를 보낸다. 다 보내면 echo가 HIGH 상태로 대기하게 된다.
    digitalWrite(t, LOW);
    digitalWrite(e, LOW);
    delayMicroseconds(2);
    digitalWrite(t, HIGH);
    delayMicroseconds(10);
    digitalWrite(t, LOW);

    // echoPin 이 HIGH를 유지한 시간을 저장 한다.
    unsigned long duration = pulseIn(e, HIGH); 
    // HIGH 였을 때 시간(초음파가 보냈다가 다시 들어온 시간)을 가지고 거리를 계산 한다.
    distance = ((float)(340 * duration) / 10000) / 2; 
//    Serial.println(distance); 
//    delay(1000);
}

//피에조, 진동 on 함수
void onWarning(){
  analogWrite(g, 255);  //진동모듈 on
  tone(p, 523); //피에조 on
  f = random(12);  //f를 0이상 11이하의 난수로 지정
  dWarning(); //"Warning" LCD에 띄우기
}

//피에조, 진동 off 함수
void deWarning(){
  analogWrite(g, 0);  //진동모듈 off
  noTone(p); //피에조 off
}

//적외선 센서 감지 함수
void moveSensor(){
  // 적외선 인체감지 센서에서 값을 읽는다
  int sensor = digitalRead(m);

  // 센서값이 HIGH(1)일 경우 움직임 값 참으로 바꾸기
  if (sensor == HIGH) {
    mm = 1;
  }
//  Serial.println(mm); 
}

//감지 기능 가동 시 LCD에 ON 출력하는 함수
void dOn(){
  OLED_Display(4,40,3,"ON");//폰트 4, 가로 40, 세로 3 띄우기, 글자 "ON" 출력
  delay(1000);
}

//감지 기능 정지 시 LCD에 OFF 출력하는 함수
void dOff(){
  OLED_Display(4,30,3,"OFF");//폰트 4, 가로 30, 세로 3 띄우기, 글자 "OFF" 출력
  delay(1000);
}

//감지되었을때 LCD에 Warning 출력하는 함수
void dWarning(){
  for(int i = 0; i < 15; i++){
     OLED_Display(2,20,10,"Warning!");  //폰트 2, 가로 20, 세로 10 띄우기, 글자 "Warinig" 출력
     delay(100);
     OLED_Display(0,0,0,"");  //글자 지우기
     delay(100);
  }
}

//감지 기능 작동중일때 LCD에 표시되는 모양
void dPlay(){
  String dis = face[f];  //face 배열에서 랜던값 f값의 인덱스의 문자열을 가져오기
  OLED_Display(4,30,0,dis);  //얼굴 띄우기
}

//LCD에 초음파 센서 거리값 띄우는 함수
void dU(){
  int dis = (int)distance;  //int로 형변환
  if(dis < 10){  //숫자가 1의자리수라면
    OLED_Display(4,50,3,(String)dis);  //초음파센서 거리값 띄우기
  } else if(dis < 100){  //숫자가 10의자리수라면
    OLED_Display(4,40,3,(String)dis);//초음파센서 거리값 띄우기
  } else if(dis < 1000){  //숫자가 100의자리수라면
    OLED_Display(4,30,3,(String)dis);  //초음파센서 거리값 띄우기
  }
}
