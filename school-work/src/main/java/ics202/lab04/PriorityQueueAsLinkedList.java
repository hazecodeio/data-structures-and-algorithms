package ics202.lab04;

import ics202.*; 
	
public class PriorityQueueAsLinkedList extends QueueAsLinkedList
{
  
    public void enqueue(Object obj, int priority)
    {
		//to be implemented by students
		Association a = new Association(new Int(priority), obj);
		Enumeration e = getEnumeration();
		
		//Object element = getHead();
		
		while(e.hasMoreElements())
		{
			Object o = e.nextElement();
			Association a2 = (Association)o;
			if(a.getKey().isGE(a2.getKey()))
			
			
		}
		//list.isertAfter(obj);
        count++;
    }
}