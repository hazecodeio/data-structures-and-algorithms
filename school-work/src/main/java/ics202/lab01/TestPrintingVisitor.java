package ics202.lab01;

import ics202.*;

public class TestPrintingVisitor {
	public static void main(String[] args) {
		MyContainer c = new MyContainer();
		for (int i=0; i<10; i++) 
			c.insert(new Int(i));
			
	    c.accept(new PrintingVisitor());
	 }
}
				