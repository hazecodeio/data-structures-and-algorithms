package ics202.lab05;

import ics202.*;

public class MyLinkedList2
{

    protected Element head;
    protected Element tail;
	
    public int length()
    {
		return auxLength(head);
    }
	
	private int auxLength(Element element)
	{
	   if(element == null)
	     return 0;
	   else
	    return 1 + auxLength(element.next);
	}
	
    public void purge()
    {
      head = null;
      tail = null;
    }

    public Element getHead()
    {
        return head;
    }

    public Element getTail()
    {
        return tail;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public Object getFirst()
    {
        if(head == null)
            throw new ListEmptyException();
        else
            return head.datum;
    }

    public Object getLast()
    {
        if(tail == null)
            throw new ListEmptyException();
        else
            return tail.datum;
    }

    public void prepend(Object obj)
    {
        Element element = new Element(obj, head);
        if(head == null)
            tail = element;
        head = element;
    }

    public void append(Object obj)
    {
        Element element = new Element(obj, null);
        if(head == null)
            head = element;
        else
            tail.next = element;
        tail = element;
    }

    public void assign(MyLinkedList2 linkedlist)
    {
        if(linkedlist != this)
        {
            purge();
		    Element element = linkedlist.head;
            while (element != null)
            {
                append(element.datum);
				element = element.next;
	    	}
        }
    }

    public void extract(Object obj)
    {
        Element element = head;
        Element lastElement = null;
        while(element != null && ! element.datum.equals(obj))
        {
            lastElement = element;
	    	element = element.next;
		}

        if(element == null)
            throw new IllegalArgumentException("item not found");
        if(element == head)
            head = element.next;
        else
            lastElement.next = element.next;
        if(element == tail)
            tail = lastElement;
    }

    public void extractFirst()
    {
        if(head == null)
            throw new IllegalArgumentException("item not found");
            
        head = head.next;
        
        if(head == null)
            tail = null;
    }

     public void extractLast()
     {
		 if(tail == null)
		    throw new IllegalArgumentException("item not found");
		    
		extract(tail.getDatum());
     }
	
      public String toString()
      {
			String s = "{";
			boolean first = true;
			Element element = head;
			
			return aux_ToString(element, s, first);
      }
      private String aux_ToString(Element element, String s, boolean first)
      {
      	if(element == null)
      	{
      		s += "}";
      		return s;
      	}
      	
      	else
      	{
      		if (first == true)
      		{
      			first = false;
      			//return s += element.datum;
      			s += element.datum;
      		}
      		else
      		{
      			s += ", "+element.datum;
      			//return s;
      		}
	      	return aux_ToString(element.next, s, first);
      	}
      	
      	
      }
      
	public Element find(Object obj)
	{
	   Element element = head;
	   return aux_Find(obj, element);
	}
	
	private Element aux_Find(Object obj, Element element)
	{
		if(element == null)
		{
			return null;
		}
		if (element.datum.equals(obj))
		return element;
		
		else
		return aux_Find(obj, element.next);
	}

	public final class Element
	{

        Object datum;
        Element next;

        Element(Object obj, Element element)
        {
          datum = obj;
          next = element;
        }
       
		 public Object getDatum()
		 {
	 	    return datum;
	     }
	
	     public Element getNext()
	     {
	         return next;
	     }
	
	     public void insertAfter(Object obj)
	     {
	         next = new Element(obj, next);
	         if(this == tail)
	             tail = next;
	     }
	
	     public void insertBefore(Object obj)
	     {
	         Element element = new Element(obj, this);
	         Element previousElement = head;
	         
	         aux_InsertBefore(obj, previousElement, element);
	     }
	      
	     private void aux_InsertBefore(Object obj, Element previousElement, Element element)
	     {
	     	if(this == head)
            {
                head = element;
                return;
            }
	     	else if(previousElement != null && previousElement.next != this)
	     	{
	     		aux_InsertBefore(obj, previousElement.next, element);
	     		return;
	     	}
	     	previousElement.next = element;
     	 }
        
        public void extract()
        {
		  Element element = null;
		  if(this == head)
              head = next;
           else
           {
              element = head;
              while(element != null && element.next != this)
              {
			     element = element.next;
		      }
				
                  if(element == null)
                     throw new InvalidOperationException();
                  element.next = next;
           }
            if(this == tail)
               tail = element;
         }
      }
  }