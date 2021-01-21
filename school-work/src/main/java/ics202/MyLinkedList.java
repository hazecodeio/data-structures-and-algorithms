package ics202;

public class MyLinkedList
{

	protected Element head;
    protected Element tail;
	
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

    public void assign(MyLinkedList linkedlist)
    {
        if(linkedlist != this) {
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
		/*Element element = head;
        Element lastElement = null;
        
		if(tail == null)
            throw new IllegalArgumentException("item not found");
            
        while(element != null)
        {
            lastElement = element;
			element = element.next;
		}*/
		
		if( head == null )
        throw new IllegalArgumentException("item not found");
        
    	else
    	{
	        Element e = head ;
	        Element lastElement = null ;
	        
	        if(e.getNext() == null )
	        {
	            head = null ;
	            tail = null ;
        	}
	        else
	        {
	            while(e.getNext() != null )
	            {
	                lastElement = e ;
	                e = e.getNext() ;
	            }
	            tail = lastElement;
	            lastElement.next = null ;
	        }
    	}

	}
	
	public Element find(Object obj) 
	{
		/*Element e = head ;
		while(e.getNext() != null)		
		if( (e.getDatum()).equals(obj) )
		e = e.getNext();
		
		if( (e.getDatum()).equals(obj) )
		return e;
		
		else
		return null;*/
		
		if( head == null )
        throw new IllegalArgumentException("item not found");
	    else
	    {
	        Element e = head ;
	        while(e.getNext() != null && !e.getDatum().equals(obj))
	        e = e.getNext();
	        
	        if(e.getDatum().equals (obj))
	        return e;
	        
	        else 
	        return null;
	    }

	}
	
	public String toString()
	{
		if(head == null )
        return "No item to print" ;
        
	    else
	    {
            StringBuffer sb = new StringBuffer() ;
            Element e = head ;
            sb.append(e.getDatum()) ;
            
            while(e.getNext() != null )
            {
                e = e.getNext() ;
                sb.append(",");
                sb.append(e.getDatum());
        	}
            return "{"+sb+"}" ;
    	}

	}
	
	/*public void insertBeforeList(Object obj)
	{
		head.insertBefore(obj);
	}
	
	public void insertAfterList(Object obj)
	{
		tail.insertAfter(obj);
	}*/
	
//////////////////---------[[The class Element]]---------\\\\\\\\\\\\\\\\\
	
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
            if(this == head)
            {
                head = element;
                return;
            }
            Element lastElement = head;
            while (lastElement != null && lastElement.next != this)
            {
				lastElement = lastElement.next;
			}
            lastElement.next = element;
        }

        public void extract()
        {
			Element element = null;
			if(this == head)
                head = next;
            else {
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
