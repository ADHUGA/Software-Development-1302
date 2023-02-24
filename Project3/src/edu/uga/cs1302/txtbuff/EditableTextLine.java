package edu.uga.cs1302.txtbuff;


public class EditableTextLine extends TextLine implements Editable
{
	public EditableTextLine()
	{
		super(); //Relying on parent class constructor
	}
	
	public EditableTextLine(String line)
	{
		super(line); //relying on parent class constructor using same characters in the argument of this method
	}

	@Override
	public void append(String fragment)  //All overridden methods are public because doc says so
	{

		length += fragment.length();
		
		while (capacity < length) //80 incrementts this way
		{
			capacity += DEFAULT_SIZE;
		}
		
		char[] temp = new char[capacity];
		
		for (int i = 0; i < length - fragment.length(); i++)
		{
			temp[i] = characterArray[i];
		}
		
		for (int i = length - fragment.length(), j = 0; i < length; i++, j++)
		{
			temp[i] = fragment.charAt(j);
		}
		
		characterArray = temp;
	}
	

	@Override
	public void insert(int index, String fragment) throws TextLineIndexOutOfBoundsException 
	{
		int leftOff = 0;
		int fromThisPoint = index;
		int capacityIncreaser = fragment.length() + length();
		
		if(index > capacity || index < 0) //These are the boundaries for the argument
		{
			throw new TextLineIndexOutOfBoundsException(index);
		}
		
		
		
		for(int counter = 0; capacity < capacityIncreaser; capacity += DEFAULT_SIZE)
		{
			counter++;
		}
		
		char[] CharacterArray = new char[capacity]; //Create a new array
		
		for(int i = 0; i < index; i++) {
		    CharacterArray[i] = characterArray[i];
		}
		
		
		for(int i = index; i >= index && i < index + fragment.length(); i++ )
		{
			CharacterArray[i] = fragment.charAt(leftOff);
			leftOff++;
		}
		
		leftOff = 0; //Reset our leftOff variable
		
		for(int n = index + fragment.length(); fromThisPoint < this.length(); n++)
		{
			CharacterArray[n] = characterArray[fromThisPoint];
			fromThisPoint = fromThisPoint + 1;
		}
		
		characterArray = CharacterArray;
		
	}

	@Override
	public void replace(int start, int end, String fragment) throws TextLineIndexOutOfBoundsException 
	{
		if (start < 0 || start >= capacity || start > end) //Boundaries focused around initial values
		{
			throw new TextLineIndexOutOfBoundsException(start);
		}
		if (end < 0 || end > capacity) //Boundaries focused around end values
		{
			throw new TextLineIndexOutOfBoundsException(end);
		}
		
		int lee = fragment.length() + start + (capacity - end);
		while (capacity < lee)
		{
			capacity += DEFAULT_SIZE;
		}
		
		char[] temp = new char[capacity]; //A temporary char array so it can hold various fragments at differet starts and ends
		
		for (int i = 0; i < start; i++)
		{
			temp[i] = characterArray[i];
		}
		for (int i = start, j = 0; i < start + fragment.length(); i++, j++)
		{
			temp[i] = fragment.charAt(j);
		}
		for (int i = start + fragment.length(), j = end; i < lee; i++, j++)
		{
			temp[i] = characterArray[j];
		}
		
		characterArray = temp;
		
		for (int i = capacity - 1; i >= 0; i--) 
		{
			if (characterArray[i] != '\u0000') 
			{
				lee = i + 1;
				break;

			}
		}

	}
}
		
	

