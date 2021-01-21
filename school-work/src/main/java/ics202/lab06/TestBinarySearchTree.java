package ics202.lab06;

import ics202.*;

import java.io.*;

public class TestBinarySearchTree 
{
	static	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main (String[] args) throws IOException 
	{
		
		// Create an instance of BinarySearchTree called tree
	
		int choice;
		initializeTree(tree);
		printTree(tree);
		
		do {
			showMenu();
			choice = getChoice();
			
			switch (choice) 
			{
			case 1 :  addElement(tree, "Enter an element to add: ");
				printTree(tree);
				break;
			case 2 :  deleteElement(tree);
				printTree(tree);
				break;
			case 3 :  checkElement(tree);
				printTree(tree);
				break;
			case 4 :  printCounts(tree);
				printTree(tree);
				break;
			case 5 :  printSum(tree);
				printTree(tree);
				break;
			case 6 :  System.out.println();
				// Display tree in bracketed form using a depthFirst traversal and the TreePrinter 
				// prepost visitor class implemented in task 4.
				
				
				
				
				
				printTree(tree);
				break;
			}
			
		} while (choice != 7);
	}
	
	public static void addElement(BinarySearchTree tree, String prompt) throws IOException 
	{
		boolean inputDone = false;
		while (! inputDone) 
		{
			System.out.print(prompt);
			try 
			{
				int key = Integer.parseInt(stdin.readLine());
			
				// Insert the key in tree
				
				
				
				inputDone = true;
			}
			
			catch(IllegalArgumentException e)
			{
				System.out.println("Error - " +  e);
			}
		}
	}

	public static void initializeTree(BinarySearchTree tree) throws IOException 
	{
		System.out.print("Enter number of nodes: ");
		int	numberOfNodes = Integer.parseInt(stdin.readLine());
		for(int i = 1; i <= numberOfNodes; i++)
		   addElement(tree, "Enter the key#" + i+ ": ");
	}
		
	public static void printTree(BinarySearchTree tree) 
	{
		Visitor v = new PrintingVisitor();
		
		System.out.print("\nPreorder traversal:      ");
		// Perform a preorder traversal on tree using the depthFirstTraversal method
		
		
		System.out.print("\nInorder traversal:       ");
		// Perform an inorder traversal on tree using the depthFirstTraversal method
		
		
		System.out.print("\nPostorder traversal:     ");
		// Perform a postorder traversal on tree using the depthFirstTraversal method
		
	
		System.out.print("\nBreadth first traversal: ");
		// Perform a breadthFirst traversal on tree
		
		
		System.out.println();
	}
		
	public static void deleteElement(BinarySearchTree tree) throws IOException 
	{
		boolean inputDone = false;
		while (! inputDone) 
		{
			System.out.print("\nEnter the key to be deleted: ");
			try 
			{
				int key = Integer.parseInt(stdin.readLine());
				
				// Delete the entered key from mytree
				
				
				
				
				inputDone = true;
			}
			
			catch(IllegalArgumentException e)
			{
				System.out.println("Error - " +  e);
			}
		}
	}
	
	public static void checkElement(BinarySearchTree tree) throws IOException 
	{
		System.out.print("\nEnter the key to be searched for: ");
		int key = Integer.parseInt(stdin.readLine());
		// Search for key and display a message whether the key is found or not
		
		
		
		
		
	}
	
	public static void printCounts(BinarySearchTree tree) 
	{
		
		// Display the total number of nodes in tree
		
		// Display the number of internal nodes in tree
		
		// Display the number of leaf nodes in tree
		
	}
	
	public static void printSum(BinarySearchTree tree) 
	{
		// Display the sum of the keys of tree using the AdditionVisitor of lab01 and a depthFirstTraversal
		
		
		
		
		
	}
	
	static int getChoice() throws IOException
	{
      int choice; 
      do {
         System.out.print("\rYour choice? : ");
         choice = Integer.parseInt(stdin.readLine());
		} while (choice < 1 || choice > 7);    
      return choice;
	}
	
	static void showMenu() 
	{
 		System.out.println("\n********************************");
 		System.out.println("*   Testing Binary Search Tree  *");
 		System.out.println("********************************");
 		System.out.println("1.  Insert An Element");
 		System.out.println("2.  Delete An Element");
 		System.out.println("3.  Check for an Element");
 		System.out.println("4.  Print Counts");
		System.out.println("5.  Print Sum");
		System.out.println("6.  Print with Brackets");
		System.out.println("7.  Quit");
 	}
}
