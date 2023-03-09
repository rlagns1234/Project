#include "HUSKYLENS.h"
#include "SoftwareSerial.h"
#include <Servo.h>

HUSKYLENS huskylens;

int sp = 13;
int mo = 2;
int vb = 3;
int pi = 4;
int t = A0;
int e = A1;

Servo servo;

void printResult(HUSKYLENSResult result);
int a=0;

void setup() {
  servo.attach(sp);
  Serial.begin(9600);
  servo.write(75);
  Wire.begin();
  while(!huskylens.begin(Wire)){
    Serial.println(F("Begin failed!"));
    Serial.println(F("1.Please recheck the \"Protocol Type\" in HUSKYLENS (General Settings>>protocol Type>>IC2)"));
    Serial.println(F("2.Please recheck the connection."));
    delay(100);
  }
  pinMode(mo,INPUT);
  pinMode(vb,OUTPUT);
  pinMode(pi,OUTPUT);
  pinMode(t,OUTPUT);
  pinMode(e,INPUT);
}

void loop() {
  motion();
  
}

void motion(){
  if(digitalRead(mo) == HIGH){
    if(!huskylens.request()) Serial.println(F("Fail to request data from HUSKYLENS, recheck the connection!"));
    else if(!huskylens.isLearned()) Serial.println(F("Nothing learned, press learn button on HUSKYLENS to learn one!"));
//  else if(!huskylens.available()) Serial.println(F("No block or arrow appears on the screen!"));
    else{
//    Serial.println(F("###########"));
      while(huskylens.available()){
        HUSKYLENSResult result = huskylens.read();
        printResult(result);
      }
    }
  }
}

void printResult(HUSKYLENSResult result){
  if(result.command == COMMAND_RETURN_BLOCK){
//    Serial.println(String()+F("Block : xCenter=")+result.xCenter+F(", yCenter=")+result.yCenter+F(", width=")+result.width+F(", height=")+result.height+F(",ID=")+result.ID);
    switch(result.ID){
      case 1:
      case 2: 
      case 3: us(); break;
    }
  }
  else if(result.command == COMMAND_RETURN_ARROW){
    Serial.println(String()+F("Block : xOrigin=")+result.xOrigin+F(", yxOrigin=")+result.yOrigin+F(", xTarget=")+result.xTarget+F(", yTarget=")+result.yTarget+F(",ID=")+result.ID);
    delay(1000);
  }
  else{
    Serial.println("Object unknown!");
  }
}

void us(){
  long duration, distance;    // 거리 측정을 위한 변수 선언
  // 트리거 핀으로 10us 동안 펄스 출력
  digitalWrite(t, LOW);        // Trig 핀 Low
  delayMicroseconds(2);            // 2us 딜레이
  digitalWrite(t, HIGH);    // Trig 핀 High
  delayMicroseconds(10);            // 10us 딜레이
  digitalWrite(t, LOW);        // Trig 핀 Low
  duration = pulseIn(e, HIGH); 
  distance = duration * 170 / 1000;
  if(distance <= 500){
    warn();
  }
}

void warn(){
  Serial.println(1);
  digitalWrite(vb, HIGH);
  tone(pi, 1000);
  delay(2000);
  digitalWrite(vb, LOW);
  noTone(pi);
}

void moter(){
  servo.write(200); delay(500);
  servo.write(75); delay(500);
}
