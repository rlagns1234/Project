#include "DM_G_I2C.h" 
#include <SPI.h> 
#include <Wire.h> 
#include <Adafruit_GFX.h> 
#include <Adafruit_SSD1306.h>

void setup() {
 // 1) 시리얼 통신 설정 - 컴퓨터를 통해 진행 상태 확이 할 수 있음 : 시리얼 모니터 하기 위한 설정
  Serial.begin(9600);         
 // 2) I2C스캐널를 통해 현재 회로가 잘 연결 됬는지 확인 할 수 있음
  G_I2C_Scanner(); delay(1000); 
 // 3) OLED 초기설정 하기  
  OLED_SETUP();
}

void loop(){
   dPlay();
}

void dOn(){
  OLED_Display(4,40,3,"ON");
  delay(1000);
}

void dOff(){
  OLED_Display(4,30,3,"OFF");
  delay(1000);
}

void dWarning(){
   OLED_Display(2,20,10,"Warning!");
   delay(100);
   OLED_Display(0,0,0,"");
   delay(100);
}

void dPlay(){
  OLED_Display(4,30,0,"o_o");
}
