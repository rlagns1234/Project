//#include <ESP8266WiFi.h> 
#include <time.h> 
 
const char* ssid = "SK_WiFiGIGAF950"; 
const char* password = "1905023577"; 
 
int timezone = 3; 
int dst = 0; 
 
unsigned long previousMillis = 0;
const long interval = 1000; 
 
void setup() { 
   Serial.begin(115200); 
   Serial.setDebugOutput(true); 
 
   WiFi.mode(WIFI_STA); 
   WiFi.begin(ssid, password); 
   Serial.println("\nConnecting to WiFi"); 
   while (WiFi.status() != WL_CONNECTED) { 
     Serial.print("."); 
     delay(1000); 
   }
 
   configTime(3 * 3600, 0, "pool.ntp.org", "time.nist.gov"); 
   Serial.println("\nWaiting for time"); 
   while (!time(nullptr)) { 
     Serial.print("."); 
     delay(1000); 
   }
   Serial.println(""); 
   Serial.println(WiFi.localIP());
 }
  
 void loop() {
  unsigned long currentMillis = millis();
  
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;
    
    time_t now = time(nullptr); 
    Serial.println(ctime(&now)); 
 
  }
 } 
