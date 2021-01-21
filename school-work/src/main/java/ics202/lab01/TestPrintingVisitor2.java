package ics202.lab01;

import ics202.*;

public class TestPrintingVisitor2 {
    public static void main(String[] args) {
       final MyContainer c = new MyContainer();
        for (int i=0; i<10; i++) 
            c.insert(new Int(i));
            
        c.accept(new AbstractVisitor()
        {
            public void visit(Object o)
            {
                //MyContainer cc = (MyContainer)o;
                System.out.println(o);
            }
        });
     }
}       