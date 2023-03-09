#include <SoftwareSerial.h>
#define LED 13

SoftwareSerial btSerial(8, 7); //RX, TX

int b = 2;

void setup() {
  pinMode(LED, OUTPUT);
  pinMode(b, INPUT_PULLUP);
  btSerial.begin(9600);
  Serial.begin(9600);
}

void loop() {
  if (btSerial.available()) {
    char c = btSerial.read();
    switch (c) {
      case 'S':
        digitalWrite(LED, HIGH);
        Serial.println("S");
        break;
      case 'P':
        digitalWrite(LED, LOW);
        Serial.println("P");
        break;
    }
  }

  if(digitalRead(b) == LOW){
    btSerial.write("O");
    Serial.println("ON");
    delay(1000);
  } else if(digitalRead(b) == HIGH){
    btSerial.write("F");
    delay(1000);
  }
}
