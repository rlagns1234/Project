int a = 1;
int b = 2;
void setup() {
  // put your setup code here, to run once:
  pinMode(a, OUTPUT);
  pinMode(b, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(a, HIGH);
//  delay(1000);
  digitalWrite(a, LOW);
//  delay(1000);
}
