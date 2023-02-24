package edu.uga.cs1302.shapes;

import java.awt.Color;


// This is not an abstract class, so it is "concrete".
// It must define getArea().  But we know how to calculate
// a circlee's area.  It is a "concrete" shape.
public class Circle extends Shape2D {

    private static final double PI = 3.14159;

    private int radius;

    public Circle()
    { 
	super(Color.BLACK); 
	this.radius = 1; 
    }

    public Circle( Color color, int radius )
    { 
	super(color); 

	if( radius <= 0 )
	    throw new ShapeException( "Circle: radius must be positive" );
	this.radius = radius; 
    }

    public int getRadius()
    {
	return radius;
    }

    public void setRadius( int radius )
    {
	if( radius <= 0 )
	    throw new ShapeException( "Circle: radius must be positive" );
	this.radius = radius;
    }

    // We can compute the area of a circle.
    public int getArea() 
    { 
	return (int) (PI * radius * radius);
    }

    // Overridden toString()
    public String toString()
    {
	return "Circle: radius: " + radius;
    }
}
