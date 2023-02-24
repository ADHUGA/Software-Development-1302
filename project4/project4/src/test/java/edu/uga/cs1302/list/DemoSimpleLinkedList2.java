package edu.uga.cs1302.list;

import java.util.ListIterator;

public class DemoSimpleLinkedList2
{

   public static void main(String[] args)
   {
       SimpleLinkedList<String> sList = new SimpleLinkedList<String>();
       SimpleLinkedList<Integer> iList = new SimpleLinkedList<Integer>();

       if( sList.isEmpty() )
	   System.out.println( "sList is empty: no elements: " + sList.size() );
       else
	   System.out.println( "sList is not empty: no elements: " + sList.size() );

       System.out.println( "Adding at end: A B C D E F" );

       sList.add( "A" );
       sList.add( "B" );
       sList.add( "C" );
       sList.add( "D" );
       sList.add( "E" );
       sList.add( "F" );

       if( sList.isEmpty() )
	   System.out.println( "sList is empty: no elements: " + sList.size() );
       else
	   System.out.println( "sList is not empty: no elements: " + sList.size() );

       ListIterator<String> iter = sList.listIterator( 0 );
       String item = null;
       boolean forward = true;

       if( iter.hasNext() ) {
	   item = iter.next();
	   forward = true;
	   System.out.println( "First item: " + item );
       }

       if( iter.hasNext() ) {
	   item = iter.next();
	   forward = true;
	   System.out.println( "Second item: " + item );
       }

       if( iter.hasPrevious() ) {
	   item = iter.previous();
	   if( forward ) {
	       if( iter.hasPrevious() ) {
		   item = iter.previous();
		   System.out.println( "Previous item: " + item );
	       }
	       else
		   System.out.println( "Top of the list" );
	   }
	   else
	       System.out.println( "Previous item: " + item );
       }

    }
}
