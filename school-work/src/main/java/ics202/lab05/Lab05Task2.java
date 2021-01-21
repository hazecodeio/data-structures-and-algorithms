import java.io.*;

public class Lab05Task2
{
  public static void main(String args [])throws IOException
  {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    int choice = 0;
    
    do{
      System.out.println("Enter array size: ");
      int size = Integer.parseInt(stdin.readLine().trim());
      int[] array = new int[size];
      for(int k = 0; k < size; k++){
      	 System.out.print("Enter element#" + (k + 1) + ": ");
         array[k] = Integer.parseInt(stdin.readLine().trim());
      }
      
      System.out.print("The array is: ");
       for(int k = 0; k < 5; k++)
    	 System.out.print(array[k] + "   ");
    	 
      System.out.print("\nEnter the integer to test: ");
      int value = Integer.parseInt(stdin.readLine().trim());
    
       if(hasLessThan(array, value))
          System.out.println("THE ARRAY HAS AN ELEMENT LESS THAN " + value);
       else
          System.out.println("THE ARRAY HAS NO ELEMENT LESS THAN " + value);
    
       System.out.println("Enter 1 to continue, any other digit to exit");
       choice = Integer.parseInt(stdin.readLine());
     }while(choice == 1);
  }
  
  public static boolean hasLessThan(int[] x, int value)
  {
    // call to an auxillary method to be implemented by students
    return aux_HasLessThan(x, value,0);
  }
  
   // auxillary method to be implemented by students
   public static boolean aux_HasLessThan(int[] x, int value, int i)
   {
   		if(x[i] < value)
	  	{
	  		return true;
	  	}
	  	
	  	else if(x[i] > value && i!=x.length-1)
	  	{
	  		return aux_HasLessThan(x, value, ++i);
	  	}
	  	
	  	else
	  	return false;
   }
}
