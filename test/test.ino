a#include <SoftwareSerial.h>
#define LED 13

SoftwareSerial btSerial(A0, A1); //RX, TX

char ca;
int a = 0;

void setup() {
  pinMode(LED, OUTPUT);
  btSerial.begin(9600);
  Serial.begin(9600);
}

void loop() {
  int sensorval = analogRead(A0);
  int brightness = map(sensorval, 0 , 1023, 0, 255);
  if (btSerial.available()) {
    char c = btSerial.read();
    ca = c;
    switch (c) {
      case 'S':
        Serial.println(ca);
        a = 1;
        break;
      case 'P':
        Serial.println(ca);
        a = 0;
        break;
    }
  }

  if(a == 1){
      btSerial.write("O");
      analogWrite(LED, 255);
      delay(1000);
    }
}
