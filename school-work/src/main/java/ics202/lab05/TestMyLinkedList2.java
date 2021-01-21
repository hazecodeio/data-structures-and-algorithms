package ics202.lab05;
import java.io.*;

import ics202.*;

public class TestMyLinkedList2 
{
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		MyLinkedList2 list = new MyLinkedList2();
		
		int i = 1;
		String inputLine;
		
		System.out.print("Enter datum value#"+ i+ " (or press q to quit): ");
		while(!(inputLine = stdin.readLine()).equals("q")){
		    list.append(new Int(Integer.parseInt(inputLine)));
		    System.out.print("Enter datum value#"+ ++i + " (or press q to quit): ");
		}
		
		System.out.println("The list is: " + list);
		System.out.println("The list's length is: " + list.length());
		
		if(! list.isEmpty()){

			System.out.print("Enter the datum value to be searched for: ");
			MyLinkedList2.Element element = list.find(new Int(Integer.parseInt(stdin.readLine().trim())));
		
			if(element == null)
		   		System.out.println("NOT FOUND");
			else{
		   		System.out.println("FOUND");
                System.out.print("Enter the datum value to be inserted after the found element: ");
                element.insertBefore(new Int(Integer.parseInt(stdin.readLine().trim())));
                System.out.println("The list is: " + list);
            }
	    }
	}
}