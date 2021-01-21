package ics202.lab03;

import ics202.*;
import java.io.*;

public class TestMyLinkedList {
	static	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main (String[] args) throws IOException {
		MyLinkedList list = new MyLinkedList();
		int choice;
		Int datum;
		
		do {
			showMenu();
			choice = getChoice();
			
			switch (choice) {
				case 1 : // prepend
						System.out.print("Enter the element to prepend: ");
						list.prepend(stdin.readLine());
						System.out.println("\n"+list);
						break;
						
				case 2 :// append 
						System.out.print("Enter the element to append: ");
						list.append(stdin.readLine());
						System.out.println("\n"+list);
						break;
						
				case 3 :// insert before
						System.out.print("Enter the element to insert befor: ");
						MyLinkedList.Element e1 = list.getHead();
						e1.insertBefore(stdin.readLine());
						System.out.println("\n"+list);
						break;
						
				case 4 :// insert after
						System.out.print("Enter the element to insert after: ");
						MyLinkedList.Element e2 = list.getTail();
						e2.insertAfter(stdin.readLine());
						System.out.println("\n"+list);
						break;
						
				case 5 :// get first  
						System.out.print("The first: ");
						System.out.println(list.getFirst());
						break;
						
				case 6 :// get last
						System.out.print("The last: ");
						System.out.println(list.getLast());
						break;
				case 7 :// remove first
						list.extractFirst();
						break;
						
				case 8 :// remove last
						list.extractLast();
						break;
						
				case 9 :// remove element
						System.out.print("Enter element to remove: ");
						list.extract(stdin.readLine());
						
			}
			
		} while (choice != 10);
	}
    
	static int getChoice() throws IOException{
      int choice; 
      do {
         System.out.print("\nYour choice? : ");
         choice = Integer.parseInt(stdin.readLine());
		} while (choice < 1 || choice > 10);    
      return choice;
	}
	
	static void showMenu() {
 		System.out.println("\n***************************");
 		System.out.println("*   Testing Linked List  *");
 		System.out.println("***************************\n");
 		System.out.println("1.  Prepend an element");
 		System.out.println("2.  Append an element");
 		System.out.println("3.  Insert before an element");
 		System.out.println("4.  Insert after an element");
 		System.out.println("5.  Get first element");
 		System.out.println("6.  Get last element");
		System.out.println("7.  Remove first element");
		System.out.println("8.  Remove last element");
		System.out.println("9.  Remove an element");
 		System.out.println("10. Quit");
 	}
}
