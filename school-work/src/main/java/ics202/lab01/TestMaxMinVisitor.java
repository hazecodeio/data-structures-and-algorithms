package ics202.lab01;

import ics202.*;

public class TestMaxMinVisitor {
	
	public static void main(String[] args) 
{
		MyContainer c = new MyContainer();
		for (int i=0; i<10; i++) 
			c.insert(new Int(i));
		
		MaxMinVisitor visitor = new MaxMinVisitor();
		c.accept(visitor);
	        System.out.println("MIN: "+visitor.getMin());
	        System.out.println("MAX: "+visitor.getMax());
	}
}
				