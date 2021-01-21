package ics202.lab02;

import ics202.*;
import ics202.lab01.*;

public class MySearchableContainer extends MyContainer implements SearchableContainer {
	
	private int findIndex(MyComparable target) 
	{
		int pos = 0;
		while (pos < count && array[pos].equals(target)==false) 
			pos++;
		if (pos < count)  //then target is found
			return pos;
		else
			return -1;
	}
	
	public void withdraw(MyComparable target) 
	{
		int index = findIndex(target);
		if (index != -1) {  //the target exists
			for (int i=index; i<count-1; i++)
				array[i] = array[i+1];
			count--;
		}
	}

	//returns the reference to the target if found, null otherwise 
	public MyComparable find(MyComparable target) 
	{
		int index = findIndex(target);
		if (index != -1) 
		return array[index];
		else
		return null;
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