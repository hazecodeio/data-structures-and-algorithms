public class Lab05Task1
{
	public static void main(String args [])
	{
    	new Lab05Task1().welcomeShabaab(3);
  	}
	
	public void welcomeShabaab(int n)
	{
		//to be implemented as a recursive method by students
		if(n==0)
		{
			System.out.print("");
		}
		else
		{
			System.out.println("ICS Shabaab, welcome to Lab05.");
			welcomeShabaab(n-1);
			System.out.println("COE Shabaab, welcome to Lab05.");
		}
	}
}
