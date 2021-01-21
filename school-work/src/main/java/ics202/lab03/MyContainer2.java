package ics202.lab03;

import ics202.*;

public class MyContainer2 extends AbstractContainer
{
    protected MyLinkedList list = new MyLinkedList();

    public void purge()
    {
        list.purge() ;
    }
    
    public Enumeration getEnumeration()
    {
        return new Enumeration ()
        {
        	private MyLinkedList.Element e = list.getHead();
	
    	    public boolean hasMoreElements()
    	    {
            	return e != null;
        	}

        	public Object nextElement()
        	{
            	MyLinkedList.Element element = e ;
            	e= e.getNext();
            	return element;
        	}
        };
    }
    
    public int compareTo(MyComparable object)
    {
        throw new MethodNotImplemented();
    }
    
    public void insert(MyComparable object)
    {
        list.append(object) ;
    }
    
    public String toString()
    {
        return list.toString() ;
    }
}