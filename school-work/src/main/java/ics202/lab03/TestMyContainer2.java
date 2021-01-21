package ics202.lab03;

import ics202.*;

public class TestMyContainer2
{
	
	public static void main(String[] args)
	{

	   MyContainer2 c = new MyContainer2();
	   for (int i=0; i<10; i++) 
		c.insert(new Int(i));
			
	    System.out.println(c);   
	 }
}
				