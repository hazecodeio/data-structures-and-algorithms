package ics202.lab01;

import ics202.*;

public class TestEnumeration {
	public static void main(String[] args) {
		MyContainer c = new MyContainer();
		for (int i=0; i<10; i++) 
			c.insert(new Int(i));
			
	    Enumeration e = c.getEnumeration();
	    
	    while (e.hasMoreElements())
	       System.out.println(e.nextElement());
	 }
}
				