package ics202.lab07;

import java.io.*;
import ics202.*;

public class BinaryHeapTest
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		BinaryHeap binaryheap;
		MyComparable[] array;
		int option; 
		
		do 
		{
			option = menu(stdin);
			switch(option)
			{
				case 1: binaryheap = createBinaryHeapTopDown(stdin);
						display(binaryheap);
						System.out.println();
						break;
				case 2: binaryheap = createBinaryHeapBottomUp(stdin);
						display(binaryheap);
						System.out.println();
						break;
				case 3: array = readArray(stdin);
						testArray(array);
						System.out.println(); 
						break;
				case 4: System.out.println("\n1. Sort in decreasing order\n2. Sort in increasing order");
						System.out.print("Enter your choice (1 or 2): ");
						int sortingOrder = Integer.parseInt(stdin.readLine().trim());
						array = readArray(stdin);	
						heapSort(array, sortingOrder);
						for(int i = 0; i < array.length; i++)
					  		System.out.print(array[i] + "  ");
						System.out.println("\n");
						break;
			}
		} while (option != 5);	
	}
	
	public static BinaryHeap createBinaryHeapBottomUp(BufferedReader stdin)throws IOException
	{
		MyComparable[] array = readArray(stdin);
		
		// Invokes an appropriate constructor of BinaryTree class to create a binary heap bottom-up
		// To be completed by students
	}
	
	public static BinaryHeap createBinaryHeapTopDown(BufferedReader stdin)throws IOException
	{
		int heapSize, numberOfElements, element;
		System.out.print("Enter the size of the BinaryHeap: ");
		heapSize = Integer.parseInt(stdin.readLine().trim());
		
		// Create a heap object called myBinaryHeap with size heapSize
		
		System.out.print("Enter the number of elements to insert in the BinaryHeap: ");
		numberOfElements = Integer.parseInt(stdin.readLine().trim());
		
		for(int i = 1; i <= numberOfElements; i++)
		{
			System.out.print("Enter element#" + i + ": ");
			element = Integer.parseInt(stdin.readLine().trim());
			try 
			{
				// Insert element in myBinaryHeap
			}
			catch(ContainerFullException exception)
			{
				System.out.println("Cannot insert more elements. The min heap is full");
				break;
			}
		}
		
		return myBinaryHeap;	 
	}
	
	public static boolean isMinHeap(MyComparable[] array)
	{
	  // Returns true if array is a minHeap otherwise returns false
	  // The index of the array starts at 1
	  // To be completed by students	
		
	}
	
	public static void testArray(MyComparable[] array)
	{
		MyComparable[] x = new MyComparable[array.length + 1];
		
		// Making the index start at 1
		for(int i = 0; i < array.length; i++)
		  x[i+1] = array[i];
		 
		 
		 // Tests the array x and display a message stating whether it is a min heap or not.
		 
		 // To be completed by students
	}
	
	public static void heapSort(MyComparable[] array, int sortingOrder)
	{
		/* heapSorts array in decreasing order if sortingOrder equals to 1;
		otherwise in increasing order */
		
		// To be completed by students
	} 
	
	
	public static void display(BinaryHeap myBinaryHeap)
	{
		PrintingVisitor visitor = new PrintingVisitor();
		System.out.print("\nThe BinaryHeap is: ");
		myBinaryHeap.accept(visitor);
		try
		{
			System.out.print("\nThe minimum element is: " + myBinaryHeap.findMin());
			myBinaryHeap.dequeueMin();
			System.out.print("\nAfter deleting the minimum element the BinaryHeap is: ");
			myBinaryHeap.accept(visitor);
			System.out.println();
		}
		catch(ContainerEmptyException exception)
		{
			System.out.println("Error - " + exception);
		}
	}
	
	public static MyComparable[] readArray(BufferedReader stdin) throws IOException
	{
		int numberOfElements = 1;
		
		System.out.print("Enter the number of elements in the array: ");
		numberOfElements = Integer.parseInt(stdin.readLine().trim());
		
		MyComparable[] array = new MyComparable[numberOfElements];
		
		for(int i = 0; i < numberOfElements; i++)
		{
			System.out.print("Enter element#" + (i + 1)  + ": ");
			array[i] = new Int(Integer.parseInt((stdin.readLine().trim())));
		}
		
		return array;
	}
	
	public static int menu(BufferedReader stdin) throws IOException
	{
		int choice = 1;
		boolean done = false;
		
		System.out.print("1. Create a Binary Heap (Top down)." +
							"\n2. Create a Binary Heap (Bottom up)." +
							"\n3. Test whether an array is a heap or not." +
							"\n4. Heap sort an array." +
							"\n5. Quit\n\n");
							
		do
		{
			System.out.print("Please enter your choice: ");
			choice = Integer.parseInt(stdin.readLine().trim());	
			done = true;
			if(choice < 1 || choice > 5)
			{
		  		System.out.println("Error-  Choice must be 1,2,3,4, or 5");
		  		done = false;
		  	}
	    }while(! done); 
	    
	    return choice;
	}
}