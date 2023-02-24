package edu.uga.cs1302.shapes;

// a simple exception class
// it is an unchecked exception
public class ShapeException extends RuntimeException 
{
    public ShapeException() {
        super();
    }

    public ShapeException( String msg ) {
        super( msg );
    }
}
