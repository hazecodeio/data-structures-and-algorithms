package ics202.lab02;
import java.io.*;
import java.util.StringTokenizer;
import ics202.*;

public class TestAssociation
{
	public static void main(String[] args)throws IOException
	{
		MySearchableContainer container = new MySearchableContainer();
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		
		Association association;
		StringTokenizer tokenizer;
		StringTokenizer tokenizer2;
		String inputLine;
		String inputLine2;
		
		while( (inputLine = reader.readLine()) != null )
		{
			tokenizer = new StringTokenizer(inputLine, " \t\r\n.,?!:");
			
			while( tokenizer.hasMoreElements())
			{
				int count = 0;
				String token = tokenizer.nextToken();
				
				if( !container.isMember(new Association(new Str(token))) )
				{
					BufferedReader reader2 = new BufferedReader(new FileReader("input.txt"));
					
					while( (inputLine2 = reader2.readLine()) != null )
					{
						tokenizer2 = new StringTokenizer(inputLine2, " \t\r\n.,?!:");
						String token2;
						while(tokenizer2.hasMoreElements())
						{
							token2 = tokenizer2.nextToken();
							if(token.equals(token2))
							count++;
						}
					}
					container.insert(new Association(new Str(token), new Int(count)) );
				}
			}
		}
		//container.accept(new PrintingVisitor());
		System.out.println(container);
	}
}				