package edu.uga.cs1302.test; //Needs to be in this location
import edu.uga.cs1302.txtbuff.*; //Gets all the files in this directory
import java.util.Scanner;
//IMPORT JUnits HERE TO TEST VARIOUS THINGS SUCH AS ASSERTIONS

public class EditableTextLineTester 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		EditableTextLine line = new EditableTextLine( "ABCDEFGHIJK" );
		System.out.println(line.length()); //Should be 11
		System.out.println(line.capacity()); //Should be 80
		
		line.append("12"); //Should be ABCDEFGHIJK12
		System.out.println(line);
		line.insert(2,  "678");// Should be AB678CDEFGHIJK12
		System.out.println(line);
		line.insert(16,  "345"); //Should be AB678CDEFGHIJK12345
		System.out.println(line);
		line.replace(2, 5, "XY"); //Should be ABXYCDEFGHIJK12345
		System.out.println(line);
		line.replace(13, 18, "LMNOPQRST"); // Should be ABXYCDEFGHIJKLMNOPQRST
		System.out.println(line);
		line.replace(2, 4, ""); // Should be ABCDEFGHIJKLMNOPQRST
		System.out.println(line);
		line.replace(11, 20, ""); // Should be ABCDEFGHIJK
		System.out.println(line);
		
		line = new EditableTextLine("A fairly long line of text, which should require allocation of longerinternal array that the DEFSULT_SIZE." );
		System.out.println(line.length()); //Should be 106
		System.out.println(line.capacity()); //Should be 160
		line.append( "A fairly long line of text, which should require allocation of longerinternal arrray than the DEFSULT_SIZE." );
		System.out.println(line.length()); //Should be 212
		System.out.println(line.capacity()); //Should be 240
		
		EditableTextLine line1 = new EditableTextLine( "ABC" );
		System.out.println(line1.length()); //Should be 3
		System.out.println(line1.capacity()); //Should be 80
		line1.insert(0, "12" );
		System.out.println(line1); //Should be 12ABC
		line1.insert(5, "78" );
		System.out.println(line1); //Should be 12ABC78
		line1.replace( 0, 7, "XYZ" );
		System.out.println(line1); //Should be XYZ
		line1.replace(0, 0, "A" );
		System.out.println(line1); //Should be AXYZ
		line1.replace(4, 4, "B" );
		System.out.println(line1); //Should be AXYZB
		
		
		
		EditableTextLine line3 = new EditableTextLine( "ABC" );
		line3.indexOf("A", -1 ); 
		line3.indexOf("A", 12);
		line3.insert(-3, "X");
		line3.insert( 5,  "X" );
		line3.replace(-3, -5, "XYZ");
		line3.replace( 5, 7, "XYZ" );
	}

}
