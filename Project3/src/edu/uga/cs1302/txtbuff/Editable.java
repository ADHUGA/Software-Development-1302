package edu.uga.cs1302.txtbuff;

public interface Editable 
{
	public void append(String fragment); //Method for adding text to the end of the class
	public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException; //Method for inserting characters from a certain index
	public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException; //Method for replacing characters at a location with different characters.
}
