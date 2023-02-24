package edu.uga.cs1302.list;

public class DemoSimpleLinkedList 
{

   public static void main(String[] args)
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
}