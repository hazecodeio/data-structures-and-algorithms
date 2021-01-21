package ics202.lab01;

import ics202.*;
import java.io.*;

public class TestMyFloat2  {
    
    public static void main(String[] args)throws IOException {

    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    String data = buff.readLine();
    float f = Float.parseFloat(data);

       MyContainer c = new MyContainer();
        c.insert(new Flt(f));
       for (int i=0; i<9; i++) 
        {
            data = buff.readLine();
            f = Float.parseFloat(data);
            c.insert(new Flt(f));
        }
            
      Enumeration e = c.getEnumeration();
        
        while (e.hasMoreElements())
           System.out.println(e.nextElement());
        
     }
}       