package ics202.lab01;

import ics202.*;

public class TestAdditionEnumeration {
	public static void main(String[] args) {
		MyContainer c = new MyContainer();
		for (int i=0; i<10; i++) 
			c.insert(new Int(i));
			
	    Enumeration e = c.getEnumeration();
	    
	    int sum = 0;
	    while (e.hasMoreElements()) {
	       Int element = (Int) e.nextElement();
	       sum += element.intValue();
	    }
	    System.out.println("Sum of the elements is : "+sum);
	 }
}
				