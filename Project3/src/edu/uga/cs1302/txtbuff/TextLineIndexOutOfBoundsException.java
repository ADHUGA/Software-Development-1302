package edu.uga.cs1302.txtbuff;

public class TextLineIndexOutOfBoundsException extends IndexOutOfBoundsException
{
	public TextLineIndexOutOfBoundsException() //You wanted this to simply call the default constructor with no message
	{
		super();
	}
	
	public TextLineIndexOutOfBoundsException(String errMsg)
	{
		super(errMsg); //Passes errMsg as the argument. Thrown and dealt
	}
	
	public TextLineIndexOutOfBoundsException(int index)
	{	//Type cast it to String because I was getting error when trying to throw?
		this( (String) "TextLine index out of range: " + index); //We need to call the one at the top of this class
	}
}
