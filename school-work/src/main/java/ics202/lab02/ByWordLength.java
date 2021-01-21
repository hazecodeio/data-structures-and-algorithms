package ics202.lab02;

import ics202.*;

import java.util.*;
import java.io.*;

public class ByWordLength 
{
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter input file name: ");
		String fname = stdin.readLine();
		
		BufferedReader in = new BufferedReader(new FileReader(fname));
		
		String line, token;
		StringTokenizer tokenizer;
		
		MySearchableContainer c = new MySearchableContainer();
		//line = in.readLine();
		int maxLength = 0;
		while ((line = in.readLine()) != null) 
		{
			tokenizer = new StringTokenizer(line, " \t\r\n.,?!:");
			while (tokenizer.hasMoreTokens()) 
			{
				token = tokenizer.nextToken();
				c.insert(new Association(new Int(token.length()), token));
				if (token.length() > maxLength)
					maxLength = token.length();
			}//line = in.readLine();
		}
		
		for (int i=0; i<maxLength; i++) 
		{
			ics202.Enumeration e = c.getEnumeration();
		    while (e.hasMoreElements()) 
		    {
				MyComparable assoc = (MyComparable) e.nextElement();
				if (assoc.equals(new Association(new Int(i))))
					System.out.println(((Association) assoc).getValue());
			}
			System.out.println();
		}
	}
}
