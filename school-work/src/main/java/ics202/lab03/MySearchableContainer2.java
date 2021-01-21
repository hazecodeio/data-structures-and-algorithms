package ics202.lab03;

import ics202.*;

public class MySearchableContainer2 extends MyContainer2 implements SearchableContainer
{
	
	private int findIndex(MyComparable target) 
	{
		MyLinkedList.Element e = list.getHead();
		int pos = 0;
		while (e.getNext() != null && (e.getDatum()).equals(target)==false) 
		{
			e = e.getNext();
			pos++;
		}
			
		if(e.getDatum().equals (target))  //then target is found
			return pos;
		else
			return -1;
	}
	
	public void withdraw(MyComparable target) 
	{
		list.extract(target);
	}

	//returns the reference to the target if found, null otherwise 
	public MyComparable find(MyComparable target) 
	{
		MyLinkedList.Element el = list.find(target);
	    return (MyComparable)el.getDatum();
	}
	
    //returns true if target is in the container, false otherwise.	
	public boolean isMember(MyComparable target) 
	{			
		int index = findIndex(target);
		if (index != -1) 
		return true;
		else
		return false;
	}
	
}			