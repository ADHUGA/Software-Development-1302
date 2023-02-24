package edu.uga.cs1302.txtbuff;

public class TextLine 
{
	public final int DEFAULT_SIZE = 80; //A constant set to 80 as per the instructions
	
	char[] characterArray; //A character array used to represent TextLine
	
	public int capacity; //Int variable used to show how much the characterArray can hold
	
	protected int length; //Setting this as protected just for encapsulation and I can use it in EditableTextLine

	
	public TextLine() //This constructor makes an empty characterArray that holds 80 characters
	{
		length = 0;
		capacity = DEFAULT_SIZE;
		characterArray = new char[capacity];
	}
	
	public TextLine(String line)
	{
		length = line.length();
		capacity = DEFAULT_SIZE; //Makes sure the max size is reset
		if (line.length() > DEFAULT_SIZE) //Checks to see if the size is enough
		{
			//for(int counter = 0; capacity < line.length(); capacity = capacity + DEFAULT_SIZE) //Uses the smallest multiple by setting capacity to 80 then continuously adding 80 until this expression is not true
			//{
				//counter++; //In case I need to reference how many times I up'd the capacity
			//}
			while(capacity < line.length()) // A while loop is much better than the for loop above
			{
				capacity += DEFAULT_SIZE;
			}
		}
		
		characterArray = new char[capacity]; //Sets new array to max size of given line
		
		for(int index = 0; index < line.length(); index++)
		{
			characterArray[index] = line.charAt(index);
		}
	}
	
	public int length() //Returns the length. Since it is a character array we simply cannot use .length and must use a loop
	{
		int holder = 0; // Used to return length
		for(int i = 0; i < capacity; i++)
		{
			if (characterArray[i] != '\u0000' && characterArray[i + 1] == '\u0000' && characterArray[i + 2] == '\u0000') //Special character for nothing
			{
				holder = i;
			}
		}
		return holder + 1;
	}
	
	public int capacity() //Returns the current capacity
	{
		return capacity;
	}
	
	public int indexOf(String fragment)
	{
		for(int i = 0; i < this.length(); i++) //Goes through the entire array
		{
			int entireChecker = i;
			int specificChecker = 0;
			
			while(fragment.charAt(specificChecker) == characterArray[entireChecker])
			{
				if(specificChecker == fragment.length() - 1)
				{
					return entireChecker;
				}
				
				entireChecker++;
				specificChecker++;
			}
			
			specificChecker = 0;
			i = entireChecker;
			
		}
		
		return -1;
	}
	
	public int indexOf(String fragment, int fromIndex) throws TextLineIndexOutOfBoundsException
	{
		if (fromIndex < 0 || fromIndex > capacity)// Throws an exception if the boundaries are off
		{
			throw new TextLineIndexOutOfBoundsException("No negative numbers/Larger than capacity");
		}
		else
		{
			for(int i = fromIndex; i < this.length(); i++) //Otherwise iterates through array
			{
				int specificCounter = 0;
				int overallCounter = i;
				
				while(characterArray[overallCounter] == fragment.charAt(specificCounter)) //Finds specific value
				{
					if(specificCounter == fragment.length() - 1)
					{
						return overallCounter;
					}
					
					++specificCounter;
					++overallCounter;
				}
				
				specificCounter = 0;
				i = overallCounter;
			}
			
			return -1;
			
		}
	}
	
	public boolean equals(Object obj) //Override this equals method
	{
		if(obj instanceof TextLine)
		{
			for(int i = 0; i < characterArray.length; i++)
			{
				if(obj.toString().charAt(i) != characterArray[i]) //Only using the method for obj
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		String texter = ""; //Empty space and we can use this class here as per the instructions
		
		for(int i = 0; i < characterArray.length; i++) //Goes through the character array
		{
			texter += characterArray[i]; //Concats each element into a string
		}
		
		return texter; //Returns said string
	}
}
