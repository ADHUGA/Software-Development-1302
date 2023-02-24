package edu.uga.cs1302.shapes;

import java.awt.Color;


// This is not an abstract class, so it is "concrete"
// It must define getArea().  But we know how to calculate
// a triangle's area.  It is a "concrete" shape.
public class Triangle extends Shape2D {

    private int base;	// must be positive
    private int height;	// must be positive

    public Triangle()
    { 
	super(Color.BLACK); 
	this.base = 1; 
	this.height = 1; 
    }

    public Triangle( Color color, int base, int height )
    { 
	super(color); 

	if( base <= 0 )
	    throw new ShapeException( "Triangle: base must be positive" );
	this.base = base; 

	if( height <= 0 )
	    throw new ShapeException( "Triangle: height must be positive" );
	this.height = height; 
    }

    public int getBase()
    {
	return base;
    }

    public void setBase( int base )
    {
	if( base <= 0 )
	    throw new ShapeException( "Triangle: base must be positive" );
	this.base = base;
    }

    public int getHeight()
    {
	return height;
    }

    public void setHeight( int height )
    {
	if( height <= 0 )
	    throw new ShapeException( "Triangle: height must be positive" );
	this.height = height;
    }

    // We can compute the area of a triangle.
    public int getArea() 
    { 
	return base * height / 2;
    }

    // Overridden toString()
    public String toString()
    {
	return "Triangle: base: " + base + " height: " + height;
    }
}
