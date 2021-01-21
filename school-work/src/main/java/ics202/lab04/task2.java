import ics202.*;
import java.io.*;

public class task2
{	
	public static void main(String[] arg)throws IOException
	{
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter an expression : ");
		String post = buff.readLine();
		
		StackAsLinkedList s = new StackAsLinkedList();
		
		String R1 = null, L1 = null;
		String L = "(";
		String R = ")";
        char ch;
        String tmp;
		
		int i;
		for(i=0; i<post.length(); i++)
		{
			ch = post.charAt(i);
			tmp = ch + "";
			
			if(tmp.equals(R))
			{
				R1 = R;
				s.push(R1);
			}
			else if(tmp.equals(L))
			{
				L1 = L;
				s.push(L1);
			}
			
			if( R1==R && L1==L )
			{
				s.pop();
				s.pop();
				
				R1 = null;
				L1 = null;
			}
		}
		
		if(s.isEmpty())
			{
				System.out.println("valid");
			}
			
			else
			System.out.println("invalid");
	}
}