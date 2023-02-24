package edu.uga.cs1302.shapes;

import java.awt.Color;


// This is not an abstract class, so it is "concrete".
// It must define getArea().  But we know how to calculate
// a rectangle's area.  It is a "concrete" shape.
public class Rectangle extends Shape2D {

    private int width;	// must be positive
    private int height;	// must be positive

    public Rectangle()
    { 
	super(Color.BLACK); 
	this.width = 1;
	this.height = 1; 
    }

    public Rectangle( Color color, int width, int height )
    { 
	super(color); 

	if( width <= 0 )
	    throw new ShapeException( "Rectangle: width must be positive" );
	this.width = width;

	if( height <= 0 )
	    throw new ShapeException( "Rectangle: height must be positive" );
	this.height = height; 
    }

    public int getWidth()
    {
	return width;
    }

    public void setWidth( int width )
    {
	if( width <= 0 )
	    throw new ShapeException( "Rectangle: width must be positive" );
	this.width = width;
    }

    public int getHeight()
    {
	return height;
    }

    public void setHeight( int height )
    {
	if( height <= 0 )
	    throw new ShapeException( "Rectangle: height must be positive" );
	this.height = height;
    }

    // We can compute the area of a rectangle.
    public int getArea() 
    { 
	return width * height;
    }

    @Override
    public boolean equals(Object obj) {
	if( obj == this ) return true;
	if( obj == null 
	    || obj.getClass() != this.getClass() )
	    return false;

	// we need to downcast to access the other Rectangle's
	Rectangle otherRectangle = (Rectangle) obj; // downcasting!
	return color != null && 
	    color.equals( otherRectangle.color ) &&
	    width == otherRectangle.width &&
	    height == otherRectangle.height;
    }

    // Overridden toString()
    public String toString()
    {
	return "Rectangle: color: " + color + " width: " + width + " height: " + height;
    }
}
