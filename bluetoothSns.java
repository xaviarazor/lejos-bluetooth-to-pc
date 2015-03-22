import java.io.*;

import lejos.nxt.*;


import lejos.nxt.comm.*;


public class bluetoothSns{
public static void main(String[] args) throws IOException{
    
         int n;
         byte[]sensors = {0,0,0,0};
         boolean press=false;
         TouchSensor touch=new TouchSensor(SensorPort.S1);
         TouchSensor touch2=new TouchSensor(SensorPort.S2);
         
         LCD.drawString("checkingForConnections",0,0);

         BTConnection btc = Bluetooth.waitForConnection();

         LCD.clear();
         
         DataInputStream input = btc.openDataInputStream();
         DataOutputStream output = btc.openDataOutputStream();         
            while(!Button.ESCAPE.isDown()){
              sensors[0]=0;
              sensors[1]=0;
              sensors[2]=0;
              sensors[3]=0;
              if(touch.isPressed()){
               	sensors[0]=1;
           		}
           		else{
           			sensors[0]=0;
           		}
              if(touch2.isPressed()){
                sensors[1]=1;
              }
              else{
                sensors[1]=0;
              }
              sensors[2]=(byte)MotorPort.B.getTachoCount();
              sensors[3]=(byte)MotorPort.A.getTachoCount();
              output.write(sensors,0,4);
              LCD.drawInt(sensors[1],0,0);
              output.flush();      
            }
         
         input.close();
         output.close();
         btc.close();
       }
}