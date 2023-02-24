// Greatly simplified, but similar to the LinkedList class in OpenJDK.
package edu.uga.cs1302.list;

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Iterator;
import java.io.Serializable;



/**
 * This class provides a simple generic list implmented as a doubly linked list. 
 * It is similar to the LinkedList class included in the java.util package.
 *
 * The elements on the list are ordered, and the first element of the list 
 * is at position 0 and the last element is at position list.size() minus 1.
 */
public class SimpleLinkedList<E> 
    implements SimpleList<E>, Iterable<E>, Serializable
{
    private Node<E> first;        // first node of the list
    private Node<E> last;         // last node of the list
    private int     count;	  // number of list elements
    private int     modCount;     // the total number of modifications 
    			          // (add and remove calls)

    /**
     * Creates an empty SimpleLinkedList.
     */
    public SimpleLinkedList()
    {
	first = null;
	last = null;
	count = 0;
	modCount = 0;
    }

    /**
     * Checks if this SimpleLinkedList is empty.
     * @return true if and only if the list is empty
     */
    public boolean isEmpty()
    {
	return count == 0;
    }

    /**
     * Returns the number of elements in this SimpleLinkedList.
     * @return the number of elements in this list
     */
    public int size()
    {
	return count;
    }

    /**
     * Adds an element at the end of this list.
     * @param e the element to be added to the end of this list
     * @return true
     */
    public boolean add( E e )
    {
	Node<E> node = new Node<E>( e, last, null );

	if( last == null )  // list is empty
	    first = node;
	else
	    last.next = node;
	last = node;
	count++;
	modCount++;     // increase modification count; element added
	return true;
    }

    /**
     * Adds an element at a specific spot(index) that the user wants
     * @param index is the location within the list that the user wants to add an element , e the element to be added to the spot the user wants
     * @return true
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size(), ConcurrentModificationException if the count doesn't equal the modCount
     */
    public boolean add( int index, E e ) throws ConcurrentModificationException //Handling the
    {//Return removed element
    	if (index < 0 || index > size()) //Your suggestion/request as per the document
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	
    	if(count != modCount) //This handles the Concurrent Modification error
    	{
    		throw new ConcurrentModificationException();
    	}
    	 	
    	Node<E> node = new Node<E>(e, last, null);
    	
    	if (isEmpty()) //count is equal to 0 we replace first and last
    	{
    		first = node;
    		last = node;
    	}
    	else if (index == size()) //This is pretty much your boolean add method above the reason why were are doing it her is because
    	{// It is just the same as appending it the end and the directions specifically request this.
    		if( last == null )
    		{// if list is empty, the first node of the list is replaced 
    		    first = node;
    		}
    		else
    		{
    		    last.next = node;
    		}
    		last = node;
    		count++;		//increase count; element added
    		modCount++;     // increase modification count; element added
    		return true;
    	}
    	else if(index == 0)
    	{
    		node.next = first;
    		first = node;
    	}
    	else
    	{
    		Node<E> initial = first;
    		Node<E> designation;
    		for (int i = 0; i <index - 1; i++) //Use a loop to add onto the node
    		{
    			initial = initial.next;
    		}
    		designation = initial.next;
    		initial.next = node;
    		node.next = designation;
    		if (designation == null) //If it is empty we just assign the last element the node
    		{
    			last = node;
    		}
    	}
    	modCount++; //Increment both of these to stop an error
    	count++;
	return true;
    }

    /**
     * Returns the element of the list at the indicated position.
     * @param index the position of the list element to return
     * @return the element at position index
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size()
     */
    public E get( int index )
    { 
	validateIndex( index, count-1 ); // must be an index of an existing element
	Node<E> node = getNodeAt( index );
	return node.elem;
    }   
	    
    /**
     * Removes a specific element of the list at the associated index number
     * @param index is the number that corresponds to the certain element you want to be removed from the list
     * @return the new list of elements with your modification
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than/equal to size(), ConcurrentModificationException if the count doesn't equal the modCount
     */
    public E remove( int index ) throws ConcurrentModificationException //Don't really need to put this here because I can choose to not handle it.
    {
    	if (index < 0 || index >= size()) //Your request as per the document
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	
    	if(count != modCount) //This handles the Concurrent Modification error
    	{
    		throw new ConcurrentModificationException();
    	}
    	
    	E counterElements; //This will hold our elements

        if (first == last) 
        {
        	counterElements = first.elem;
            first = last = null;
        } 
        else if (index == 0) 
        {
        	counterElements = first.elem; //using method given above for the first element
            first = first.next;
        } 
        else 
        {
            Node<E> initial = first;
            Node<E> designation;
            for (int i = 0; i < index - 1; i++) //Building up the node
            {
            	initial = initial.next;
            }
            designation = initial.next;
            counterElements = designation.elem;
            if (designation != null) //Checking for empty spaces
            {
            	designation = designation.next;
            }
            initial.next = designation;

            if (designation == null) //Checking for empty spaces
            {
            	last = initial;
            }
        }
        
        modCount--;
        count--; //Decrement both of these to avoid error
        return counterElements; // 
    }

    /**
     * Tells the user at what index does the element they supplied occur at within the list
     * @param e potential element of the node list
     * @return -1
     * @throws  ConcurrentModificationException if the count doesn't equal the modCount
     */
    public int indexOf( E e ) //Uses equals comparison
    {
    	if(count != modCount) //This handles the Concurrent Modification error
    	{
    		throw new ConcurrentModificationException();
    	}
    	
    	Node<E> node = first;
        int c = 0;
        while (node != null) 
        {
            if (e.equals(node.elem)) //This goes through the list and
            {
            	return c;
            }
            c = c + 1;
            node = node.next;
        }
	return -1;
    }

    /**
     * Returns an Iterator of the list elements, starting at the beginning of this list.
     * @return the created Iterator
     */
    public Iterator<E> iterator() 
    {
        return new SimpleLinkedListIterator( 0 );
    }

    /**
     * Returns a ListIterator of the list elements, starting at the given position in this list.
     * @param index the position of the first element on the list to be returned from the iterator
     * @return the created ListIterator
     * throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to the size of the list
     */
    public ListIterator<E> listIterator( int index ) 
    {
	validateIndex( index, count ); // must be possible to insert after the last element
        return new SimpleLinkedListIterator( index );
    }

    // The methods and inner classes below are private, and are intended for internal use only.

    // Return the node at a given index.
    // The argument, index, must be verified to be a legal index into this list.
    private Node<E> getNodeAt( int index )
    {
	Node<E> curr = first;
	for( int i = 0; i < index; i++ )
	    curr = curr.next;
	return curr;
    }

    // Verify that a given index is within bounds 0 through end.
    // The second argument, end, should be either count minus 1, if the given index must
    // be a valid index of an existing element, or count, if an insert is to be at 
    // the end of a list, or an iterator starting at the right end of the list.
    private void validateIndex( int index, int end )
    {
	if( index < 0 || index > end )
	    throw new IndexOutOfBoundsException( "Illegal list index: " + index );
    }

    // This is a private inner class implementing a doubly-linked list node.
    // It makes sense for this class to be private, as it is only useful internally to
    // the SimpleLinnkedList class.
    // Because this class is private, so it is accessible only to the host class SimpleLinkedList,
    // therefore, there is no need to define the variables as private.
    private static class Node<E> {
        E       elem;
        Node<E> next;
        Node<E> prev;

        Node( E elem, Node<E> prev, Node<E> next ) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * This class provides an iterator for the SimpleLinkedList.
     * Some methods have not been implemented intentaionlly;  you 
     * are not expected to implement them.
     */
    private class SimpleLinkedListIterator
	implements ListIterator<E>
    {
	private Node<E> currNode;
	private Node<E> previouslyReturned;
	private int     currPos; // index of the element to be returned next
        private int     expectedModCount; // the count of modifications at the time of this iteractor creation

	// Creates a new iterator starting at position index.
	// javadoc comment needed
	public SimpleLinkedListIterator( int index )
	{
	    validateIndex( index, count ); // verify the staring index;  may be equal to count
	    expectedModCount = modCount;
	    previouslyReturned = null;
	    if( count == 0 )
		currNode = null;
	    else
		currNode = getNodeAt( index );
	    currPos = index;
	}
	    
	// Returns true if this list iterator has more elements when traversing the list forward.
	// javadoc comment needed
	public boolean hasNext() 
	{
	    return currPos < count;
	}

	// Returns true if this list iterator has more elements when traversing the list in the reverse direction.
	// javadoc comment needed
	public boolean hasPrevious()
	{
	    return currPos > 0;
	}

	// Returns the next element on the list.
	// May throw NoSuchElementException if the next element does not exist.
	public E next() 
	{
	    checkForComodification();
	    if( currPos >= count || currNode == null )
		throw new NoSuchElementException();
	    previouslyReturned = currNode;
	    currPos++;
	    currNode = currNode.next;
	    return previouslyReturned.elem;
	}

	// Returns the index of the element that would be returned by a call to next.
	// javadoc comment needed
	public int nextIndex() 
	{
	    return currPos;
	}

	// Returns the previous element in the list.
	// javadoc comment needed
	public E previous() 
	{
	    checkForComodification();
	    if( currPos <= 0 )
		throw new NoSuchElementException();
	    currPos--;
	    if( currNode == null ) {
		currNode = last;
		previouslyReturned = last;
		return previouslyReturned.elem;
	    }
	    else {
		currNode = currNode.prev;
		previouslyReturned = currNode;
		return previouslyReturned.elem;
	    }
	}

	// Returns the index of the element that would be returned by a call to previous.
	// javadoc comment needed
	public int previousIndex() 
	{
	    return currPos - 1;
	}

	// The following are optional operations which are not supported in the 
	// SimpleLinkedList implementation.

	// Adds a new element
	// not implemented here
	public void add(Object e)
	{
	    throw new UnsupportedOperationException( "add called while iterating is not available" );
	}

	// Removes from the list the last element that was returned by next or previous (optional operation).
	// not implemented here
	public void remove() 
	{
	    throw new UnsupportedOperationException( "remove called while iterating is not available" );
	}

	// Replaces the last element returned by next or previous with the specified element (optional operation).
	// not implemented here
	public void set(Object e)
	{
	    throw new UnsupportedOperationException( "set called while iterating is not available" );
	}

	// check if there was a concurrent modification of the list contents.
	// if yes, throw a ConcurrentModificationException exception
	private final void checkForComodification() 
	{
	    if( expectedModCount != SimpleLinkedList.this.modCount )
		throw new ConcurrentModificationException( "list modified while iterator is in progress" );
	}
    }
}
