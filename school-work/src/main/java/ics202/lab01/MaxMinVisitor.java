package ics202.lab01;

import ics202.*;

public class MaxMinVisitor extends AbstractVisitor
{
	MyComparable max, min;
    MyComparable getMax()
    {
        return max;
    }
    
    MyComparable getMin() 
    {
        return min;
    }
    
    public void visit(Object o)
    {
        MyComparable mc = (MyComparable)o;
        
        MyContainer c = (MyContainer)o;
        
        Enumeration e = c.getEnumeration();
        
        min = null; max = null;
        while(e.hasMoreElements())
        {
        	if (mc.isLT((Int)(e.nextElement())))
	        {
	        	min = mc;
	        }
        }
        
        
        if (mc.isGT(mc))
        {
        	max = mc;
        }
    }
}