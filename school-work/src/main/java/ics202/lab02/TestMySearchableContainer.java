package ics202.lab02;

import ics202.*;
import java.io.*;

public class TestMySearchableContainer{
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		MySearchableContainer c = new MySearchableContainer();
		
		int choice;
		while((choice =menu(stdin)) != 5)
		{
			switch(choice)
			{
			  case 1: insert(c, stdin); break;
			  case 2: delete(c, stdin); break;
			  case 3: search(c, stdin);break;
			  case 4: display(c);
			}
			
		} 
	}
	
	public static int menu(BufferedReader stdin)throws IOException{
	  int choice = 0;
	  do{
		System.out.println("1. Add element(s)");
		System.out.println("2. Delete an element");
		System.out.println("3. Search for an element");
		System.out.println("4. Display all elements");
		System.out.println("5. Exit");
		
		System.out.println("Please enter your choice");
		choice = Integer.parseInt(stdin.readLine().trim());
		
		if(choice < 1 || choice > 5)
		  System.out.println("Error - Wrong choice");
	  }while(choice < 1 || choice > 5);
	
	  return choice;
	}
	
	public static void insert(MySearchableContainer c, BufferedReader stdin)throws IOException
	{
		int capacity = c.getSize() - c.getCount();
		int number;
		do
		{
		  System.out.println("Enter number of elements to insert <=" + capacity);
		  number = Integer.parseInt(stdin.readLine().trim());
		  
		  if(number > capacity) 
		     System.out.println("Error - wrong input");
		}while(number > capacity);
		
		for(int i = 0; i<number; i++)
		{
			System.out.println("enter : ");
			String data = stdin.readLine();
			c.insert(new Str(data));
		}
	}

	
	
	public static void delete(MySearchableContainer c, BufferedReader stdin) throws IOException
	{
		System.out.print("Enter element to remove: ");
		stdin = new BufferedReader(new InputStreamReader(System.in));
		Str s = new Str(stdin.readLine());
		c.withdraw(s);
	}
	
	public static void search(MySearchableContainer c, BufferedReader stdin)throws IOException
	{
		System.out.print("Enter an element to search for: ");
		stdin = new BufferedReader(new InputStreamReader(System.in));
	    
	    Str s = new Str(stdin.readLine());
	    
	    System.out.println(c.isMember(s));
	}
	
	public static void display(MySearchableContainer c)
	{
		System.out.println(c);
	}
	
}
				