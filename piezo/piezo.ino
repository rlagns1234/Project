int piezo = 11;

void setup() {
  pinMode(piezo, OUTPUT);
}
 
void loop() {
  tone(piezo, 2000);
}
