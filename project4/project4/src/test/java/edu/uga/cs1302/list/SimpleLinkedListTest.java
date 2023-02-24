package edu.uga.cs1302.list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import edu.uga.cs1302.list.SimpleLinkedList;
import static org.junit.Assert.*;

import java.util.ListIterator;

public class SimpleLinkedListTest 
{
	@Before
	public void setUp()
	{
		SimpleLinkedList<String> sList = new SimpleLinkedList<String>();

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       System.out.println( "Adding at end: A B C D E F" );

	       sList.add( "A" );
	       sList.add( "B" );
	       sList.add( "C" );
	       sList.add( "X" );
	       sList.add( "D" );
	       sList.add( "E" );
	       sList.add( "F" );
	       sList.remove( 3 );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Adding at " + sList.size() + ": Z" );

	       sList.add( sList.size(), "Z" ); //Index is equal to size

	       System.out.println( "Adding at 0: X" );
	       sList.add( 0, "X" );

	       System.out.println( "Adding at 1: Y" );
	       sList.add( 1, "Y" );
	       
	       for( int i = 0; i < sList.size(); i++ )//I added this
	    	   System.out.print( sList.get( i ) );
	       System.out.println("");

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );
	       
	       for( int i = 0; i < sList.size(); i++ )
	    	   System.out.print( sList.get( i ) );//I added this
	       System.out.println("");

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Removed from: 1: " + sList.remove( 1 ) );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Removed from: 7: " + sList.remove( 7 ) );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Removed from: 0: " + sList.remove( 0 ) );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );
	}
	
	@After
	public void tearDown()
	{
		SimpleLinkedList<String> sList = new SimpleLinkedList<String>();

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       System.out.println( "Adding at end: A B C D E F" );

	       sList.add( "A" );
	       sList.add( "B" );
	       sList.add( "C" );
	       sList.add( "X" );
	       sList.add( "D" );
	       sList.add( "E" );
	       sList.add( "F" );
	       sList.remove( 3 );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Adding at " + sList.size() + ": Z" );

	       sList.add( sList.size(), "Z" ); //Index is equal to size

	       System.out.println( "Adding at 0: X" );
	       sList.add( 0, "X" );

	       System.out.println( "Adding at 1: Y" );
	       sList.add( 1, "Y" );
	       
	       for( int i = 0; i < sList.size(); i++ )//I added this
	    	   System.out.print( sList.get( i ) );
	       System.out.println("");

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );
	       
	       for( int i = 0; i < sList.size(); i++ )
	    	   System.out.print( sList.get( i ) );//I added this
	       System.out.println("");

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Removed from: 1: " + sList.remove( 1 ) );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Removed from: 7: " + sList.remove( 7 ) );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );

	       System.out.println( "Removed from: 0: " + sList.remove( 0 ) );

	       if( sList.isEmpty() )
		   System.out.println( "sList is empty: no elements: " + sList.size() );
	       else
		   System.out.println( "sList is not empty: no elements: " + sList.size() );

	       for( int i = 0; i < sList.size(); i++ )
		   System.out.println( "Element at: " + i + ": " + sList.get( i ) );
	}
	
	
	@Test
	public void testNewLinkedList() 
	{
		SimpleLinkedList<Integer> listTester = new SimpleLinkedList<>();
		assertTrue(listTester.isEmpty());
		listTester.add(2);
		
		assertFalse(listTester.isEmpty());
		
	}
	
	
	
	 

}
