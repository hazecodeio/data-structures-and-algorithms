package ics202.lab01;

import ics202.*;

public class MyContainer extends AbstractContainer {
	private final int SIZE = 100; 
	protected MyComparable[] array = new MyComparable[SIZE];
	
	public boolean isFull() {
		return count == SIZE;
	}
	
	public void purge() {
		for (int i=0; i<count; i++)
			array[i] = null;
		count = 0;
	}
	
	public int getSize(){
		return SIZE;
	}
	
	public Enumeration getEnumeration() {
		
		return new Enumeration () {
			
			private int pos = 0;
			
			public boolean hasMoreElements() {
				return pos < count;
			}
			
			public Object nextElement() {
				MyComparable element = array[pos];
				pos++;
				return element;
			}
		};
	}
	
	public int compareTo(MyComparable object) {
		throw new MethodNotImplemented();
	}
	
	public void insert(MyComparable object) {
		if(isFull())
		  throw new ContainerFullException();
		else{
		  array[count] = object;
		  count++;
		  }
	}
}			