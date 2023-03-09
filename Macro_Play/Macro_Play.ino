#include <Mouse.h>
#include <Keyboard.h>
#include <HID.h>
 
char receive;
int num1,num2,xy;
void setup()
{
  Serial.begin(9600);
  Mouse.begin(); 
  Keyboard.begin();
}
 
void loop()
{
    if (Serial.available() > 4) {
        receive = Serial.read(); //0x1F  
         
        if(receive == 0x1F){
            receive = Serial.read();
             
            if(receive == 0x11){
                receive = Serial.read();
                if(receive == 0x12){
                    Mouse.move(2,0);
                }else if(receive == 0x13){
                    Mouse.move(5,0);
                }else if(receive == 0x14){
                    Mouse.move(10,0);
                }else if(receive == 0x15){
                    Mouse.move(20,0);
                }else if(receive == 0x16){
                    Mouse.move(50,0);
                }else if(receive == 0x17){
                    Mouse.move(100,0);
                }
            }else if(receive == 0x22){
                receive = Serial.read();
                if(receive == 0x12){
                    Mouse.move(-2,0);
                }else if(receive == 0x13){
                    Mouse.move(-6,0);
                }else if(receive == 0x14){
                    Mouse.move(-11,0);
                }else if(receive == 0x15){
                    Mouse.move(-21,0);
                }else if(receive == 0x16){
                    Mouse.move(-52,0);
                }else if(receive == 0x17){
                    Mouse.move(-102,0);
                }
            }else if(receive == 0x33){
                receive = Serial.read();
                if(receive == 0x12){
                    Mouse.move(0,2);
                }else if(receive == 0x13){
                    Mouse.move(0,5);
                }else if(receive == 0x14){
                    Mouse.move(0,10);
                }else if(receive == 0x15){
                    Mouse.move(0,20);
                }else if(receive == 0x16){
                    Mouse.move(0,50);
                }else if(receive == 0x17){
                    Mouse.move(0,100);
                }
            }else if(receive == 0x44){
                receive = Serial.read();
                if(receive == 0x12){
                    Mouse.move(0,-2);
                }else if(receive == 0x13){
                    Mouse.move(0,-6);
                }else if(receive == 0x14){
                    Mouse.move(0,-11);
                }else if(receive == 0x15){
                    Mouse.move(0,-21);
                }else if(receive == 0x16){
                    Mouse.move(0,-51);
                }else if(receive == 0x17){
                    Mouse.move(0,-101);
                }
            }else if(receive == 0x55){
                receive = Serial.read();
                if(receive == 0x01){
                    Mouse.click();
                }
                if(receive == 0x02){
                    Mouse.click();
                    Mouse.click();
                }
            }
            receive = Serial.read();
            receive = Serial.read();
        }
        else if(receive == 0x7A){
            receive = Serial.read();
            Keyboard.write(receive);
            receive = Serial.read();
            Keyboard.write(receive);
            receive = Serial.read();
            Keyboard.write(receive);
            receive = Serial.read();
            Keyboard.write(receive);
        }
    }
}
