package ics202.lab06;

import ics202.*;

public class TreePrinter extends AbstractPrePostVisitor
{
	/*to print in the form { LT  key RT }
	 *we will use the InOrder Traversal class*/
	 
	 public void inVisit(Object obj)
    {
    	BinaryTree t = (BinaryTree)obj;
    	System.out.print("{" + t.getLeft() +" "+ t.getKey()  +" "+ t.getRight() + "}");
    }
}