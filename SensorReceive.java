import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*;
import java.util.*;
import java.io.*;



public class SensorReceive{

public static void main(String[]args)throws Exception{
   System.out.println("En proceso...");
   NXTConnector b=new NXTConnector();
   
   
   int sns=0;
   byte[] input=new byte[4];
   if(!b.connectTo("s.middles",NXTComm.LCP)){
      System.err.println("Unnable to connect to device");
      System.exit(1);
   }
   else{
      System.out.println("The stream is now open");
   }
   
   InputStream dis=b.getInputStream();
   while(sns>-1){
      sns=dis.read(input,0,4);   
      System.out.println(input[0]+"  "+input[1]+"  "+input[2]+"  "+input[3]);
   }
   int n=0;
   b.close();
   }
   
}
