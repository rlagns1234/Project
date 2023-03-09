#include <ESP8266WiFi.h> 
#include <time.h> 
#include <WiFiClient.h>
#include <ESP8266WebServer.h>
#include <ESP8266mDNS.h>

#ifndef STASSID
#define STASSID "your-ssid"
#define STAPSK  "your-password"
#endif

const char* ssid = "SK_WiFiGIGAF950"; 
const char* password = "1905023577"; 

ESP8266WebServer server(80);

int timezone = 3; 
int dst = 0; 
 
unsigned long previousMillis = 0;
const long interval = 1000; 
 
void setup() { 
  Serial.begin(115200); 
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.println("");
  while (WiFi.status() != WL_CONNECTED) {
   delay(500);
   Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());

  if (MDNS.begin("esp8266")) {
    Serial.println("MDNS responder started");
  }

//  server.on("/", handleRoot);

  server.on("/inline", []() {
    server.send(200, "text/plain", "this works as well");
  });

  server.on("/gif", []() {
    static const uint8_t gif[] PROGMEM = {
      0x47, 0x49, 0x46, 0x38, 0x37, 0x61, 0x10, 0x00, 0x10, 0x00, 0x80, 0x01,
      0x00, 0x00, 0x00, 0x00, 0xff, 0xff, 0xff, 0x2c, 0x00, 0x00, 0x00, 0x00,
      0x10, 0x00, 0x10, 0x00, 0x00, 0x02, 0x19, 0x8c, 0x8f, 0xa9, 0xcb, 0x9d,
      0x00, 0x5f, 0x74, 0xb4, 0x56, 0xb0, 0xb0, 0xd2, 0xf2, 0x35, 0x1e, 0x4c,
      0x0c, 0x24, 0x5a, 0xe6, 0x89, 0xa6, 0x4d, 0x01, 0x00, 0x3b
    };
    char gif_colored[sizeof(gif)];
    memcpy_P(gif_colored, gif, sizeof(gif));
    // Set the background to a random set of colors
    gif_colored[16] = millis() % 256;
    gif_colored[17] = millis() % 256;
    gif_colored[18] = millis() % 256;
    server.send(200, "image/gif", gif_colored, sizeof(gif_colored));
  });

//  server.onNotFound(handleNotFound);

  server.begin();
  Serial.println("HTTP server started");
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
 }
  
 void loop() {
  server.handleClient();
  MDNS.update();
  unsigned long currentMillis = millis();
  
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;
    
    time_t now = time(nullptr); 
    server.send(200, "text/plain", ctime(&now));
//    Serial.println(ctime(&now)); 
 
  }
 } 
