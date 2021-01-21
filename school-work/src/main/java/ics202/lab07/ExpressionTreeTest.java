package ics202.lab07;

import java.io.*;
import ics202.*;


public class ExpressionTreeTest
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		ExpressionTree expressionTree = new ExpressionTree();
		int option;
		
		do 
		{
			option = menu(stdin);
			switch(option)
			{
				case 1: expressionTree = createExpressionTree(stdin);
						System.out.println();
						break;
				case 2: if(expressionTree.isEmpty())
							System.out.println("The tree is empty");
						else
							displayTraversals(expressionTree);
						System.out.println();
						break;
				case 3: if(expressionTree.isEmpty())
						  System.out.println("The tree is empty");
						else
						  System.out.println("\nThe value of the expression is: " + evaluate(expressionTree));
						System.out.println();
						break;
			}
	   } while (option != 4);
    }
		
	public static ExpressionTree createExpressionTree(BufferedReader stdin) throws IOException
	{
		StackAsLinkedList stack = new StackAsLinkedList();
		System.out.println("Operands allowed in our postfix expression are single digits");
		System.out.println("Operators allowed are the binary operators: *, / , %, +, -");
		
		System.out.print("Enter a valid postfix expression: " );
		
		String postfixExpression = stdin.readLine().trim();
		int stringLength = postfixExpression.length();
		
		for(int i = 0; i < stringLength; i++)
		{
			//Create the expression tree
				
		
		
		
			
		}
		
		
		// return the expression tree ;
	}

	public static void displayTraversals(ExpressionTree tree)
	{	
		Visitor v = new PrintingVisitor();
		
		System.out.print("\nPreorder traversal:      ");
		// Perform a preorder traversal
		
		System.out.print("\nInorder traversal:       ");
		// Perform an inorder traversal
		
		System.out.print("\nPostorder traversal:     ");
		// Perform a postorder traversal
		
		System.out.print("\nBreadth first traversal: ");
		// Perform a breadthFirst traversal
		
		
		System.out.println();
	}
			
		
  
  public static boolean isOperator(char character)
  {
  	/* Returns true if character is one of the operators: +, -, *, /, or %
  	   otherwise returns false  */
  		
  	// To be completed by students
  	
  	
  }
  
  public static int evaluate(ExpressionTree tree)
  {
  	// Evaluates tree recursively
  	// To be completed by students
  }
  
  public static int applyOperator(int operand1, char operator, int operand2)
  {
  	// ruturns the value of:  operand1 operator operand2
  	// To be completed by students
  	
  }
  
  public static int menu(BufferedReader stdin) throws IOException
	{
		int choice;
		boolean done = false;
		
		System.out.print("1. Create an expression tree." +
							"\n2. Display expression tree traversals." +
							"\n3. Evaluate expression tree." +
							"\n4. Quit\n\n");
							
		do
		{
			System.out.print("Please enter your choice: ");
			choice = Integer.parseInt(stdin.readLine().trim());	
			done = true;
			if(choice < 1 || choice > 4)
			{
		  		System.out.println("Error-  Choice must be 1,2,3 or 4");
		  		done = false;
		  	}
	    }while(! done); 
	    
	    return choice;
	}
}