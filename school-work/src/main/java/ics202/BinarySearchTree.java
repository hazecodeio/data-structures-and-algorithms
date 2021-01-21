package ics202;


public class BinarySearchTree extends BinaryTree implements SearchTree
{
    private BinarySearchTree getLeftBST()
    {
        return (BinarySearchTree)getLeft();
    }

    private BinarySearchTree getRightBST()
    {
        return (BinarySearchTree)getRight();
    }

    public boolean isMember(MyComparable comparable)
    {
        if(find(comparable) == null)
    	   return false ;
    	else
    	   return true;
    }

    public MyComparable find(MyComparable comparable)
    {
        if(isEmpty())
            return null;
        MyComparable key = (MyComparable) getKey();    
        if(comparable.isEQ(key))
            return key;
        else if (comparable.isLT(key))
            return getLeftBST().find(comparable);
        else    
            return getRightBST().find(comparable);
    }
    
    
    public MyComparable findMin()
    {
        if(isEmpty())
            return null;
        if(getLeftBST().isEmpty())
            return (MyComparable)getKey();
        else
            return getLeftBST().findMin();
    }
    
    
    public MyComparable findMax()
    {
        if(isEmpty())
            return null;
        if(getRightBST().isEmpty())
            return (MyComparable)getKey();
        else
            return getRightBST().findMax();
    }

    public void attachKey(Object obj)
    {
        if(!isEmpty())
            throw new InvalidOperationException();
        else
        {
            key = obj;
            left = new BinarySearchTree();
            right = new BinarySearchTree();
        }
    }

    public void insert(MyComparable comparable)
    {
        if(isEmpty())
            attachKey(comparable);
        else
        {
         	MyComparable key = (MyComparable) getKey();    
        	if(comparable.isEQ(key))
                throw new IllegalArgumentException("duplicate key");
        	else if (comparable.isLT(key))
                getLeftBST().insert(comparable);
        	else    
                getRightBST().insert(comparable);

        }
    }
    
    
    public void withdraw(MyComparable comparable)
    {
       if(isEmpty( ))
            throw new IllegalArgumentException("object notfound") ;
            
	   MyComparable key = (MyComparable) getKey( ) ;    
       if(comparable.isLT(key))
            getLeftBST( ).withdraw(comparable) ;
        else if(comparable.isGT(key))
            getRightBST( ).withdraw(comparable) ;
       else
       { // the key is found
          if(isLeaf())   
             detachKey( ) ;
          else if( ! getLeftBST().isEmpty())
          {
              MyComparable max = getLeftBST().findMax() ;
              super.key = max ;    
              getLeftBST( ).withdraw(max) ; 
          }
          else 
          { // the right subtree is not empty
              MyComparable min = getRightBST().findMin() ;
              super.key = min ;    
              getRightBST().withdraw(min) ; 
          }
      }
   } 
}