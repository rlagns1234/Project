int m = 6;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(m, INPUT);  //인체감지센서 인풋 설정   
}

void loop() {
  // put your main code here, to run repeatedly:
  int sensor = digitalRead(m);
  Serial.println(sensor);
  delay(500);
}
