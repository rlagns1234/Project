#include "Keyboard.h"
#include "Mouse.h"
int l = A5;
int r = A4;

int left;
int right;

int c = 1000;
int lp = c;
int rp = c;

void setup() {
  pinMode(l, INPUT);
  pinMode(r, INPUT);
  Mouse.begin();
  Keyboard.begin();
  Serial.begin(9600);
}

void loop() {
  left += analogRead(l);
  right += analogRead(r);
  p();
  if(left > lp){
//    Keyboard.write(KEY_LEFT_ARROW);
    Keyboard.press(KEY_LEFT_ARROW);
    Keyboard.release(KEY_LEFT_ARROW);
    left = 0;
  }
  
  if(right > rp){
//    Keyboard.write(KEY_RIGHT_ARROW);
    Keyboard.press(KEY_RIGHT_ARROW);
    Keyboard.release(KEY_RIGHT_ARROW);
//    Serial.println(right);
    right = 0;
  }
  delay(10);
}

void p(){
  if(left > 1500){
    lp = 1500;
  } else if(left > 1400){
    lp = 1400;
  } else if(left > 1300){
    lp = 1300;
  } else if(left > 1200){
    lp = 1200;
  } else if(left > 1100){
    lp = 1100;
  } else {
    lp = 1000;
  }
  
  if(right > 1500){
    rp = 1500;
  } else if(right > 1400){
    rp = 1400;
  } else if(right > 1300){
    rp = 1300;
  } else if(right > 1200){
    rp = 1200;
  } else if(right > 1100){
    rp = 1100;
  } else {
    rp = 1000;
  }
}
