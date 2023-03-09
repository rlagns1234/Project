#include <SoftwareSerial.h>
SoftwareSerial mySerial(10, 11); // RX, TX
 
void setup() {
  Serial.begin(115200);
  mySerial.begin(115200);
}
 
void loop() { // run over and over
  if (mySerial.available()) {
    char a =mySerial.read();
    Serial.write(a);
  }
}
