import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.awt.Color;

import edu.uga.cs1302.shapes.Rectangle;


//  Step 1. Create a testing class using JUnit 4
//
public class RectangleTester {

    // Declare variables for the objects to be
    // tested.
    private Rectangle r1, r2;

    // Create a setUp() method to instantiate and  
    // initialize the objects under test. This method  
    // is invoked before EVERY test case.
    //
    // In JUnit 4 -- use the @Before annotation
    //
    @Before
    public void setUp() {
        r1 = new Rectangle();
        r2 = new Rectangle( Color.RED, 2, 3 );
    }

    // Create a tearDown() method to clean up after 
    // EACH test case. Unless you need something more than 
    // general garbage collection, such as closing I/O  
    // streams, you can leave this method out.
    //
    // In JUnit 4 -- use the @After annotation
    //
    @After
    public void tearDown() {
        r1 = null;
        r2 = null;
    }

    // Create the test cases.

    // Test Case 1: Instantiation of a default Rectangle object 
    //
    // In JUnit 4 -- use the @Test annotation
    //
    @Test
    public void testInstantiateDefault() {
        assertEquals( r1.getColor(), Color.BLACK );
        assertEquals( r1.getWidth(), 1 );
        assertEquals( r1.getHeight(), 1 );
    }


    // Test Case 2: Instantiation of a Rectangle object 
    // with legal user-supplied values for the attributes 
    // above the legal boundary.
    //
    @Test
    public void testInstantiateLegal() {
        r1 = new Rectangle( Color.RED, 2, 3 );
        assertEquals( r1.getColor(), Color.RED );
        assertEquals( r1.getHeight(), 3 );
        assertEquals( r1.getWidth(), 2 );
   }

    // Test Case 3: Instantiation of a Rectangle object 
    // with an illegal user-supplied value for width.
    //
    @Test( expected = edu.uga.cs1302.shapes.ShapeException.class )
    public void testInstantiateIllegalWidth() {
	new Rectangle( Color.RED, -3, 5 );
    }
      
    // Test Case 4: Setters used to change a Rectangle's sides: legal input.
    //
    @Test
    public void testSetSidesLegal() {
        r2.setHeight( 11 );
        r2.setWidth( 12 );
        assertEquals( r2.getHeight(), 11 );
        assertEquals( r2.getWidth(), 12 );
    }

    // Test Case 5: Setter used to change a Rectangle's side: illegal input.
    //
    @Test( expected = edu.uga.cs1302.shapes.ShapeException.class )
    public void testSetHeightIllegal() {
	r2.setHeight( -11 );
    }

    // Test Case 6: Setter used to change a Rectangle's side: illegal input.
    //
    @Test( expected = edu.uga.cs1302.shapes.ShapeException.class )
    public void testSetWidthIllegal() {
        r2.setWidth( -11 );
    }

    // Test Case 7: Mutator to change a Rectangle's color: legal input.
    //
    @Test
    public void testOffsetMutatorLegal() {
        r2.setColor( Color.RED );
        assertEquals( r2.getColor(), Color.RED );
    }

    // Test Case 8: Equality test: true
    //
    @Test
    public void testEqualityTrue() {
	r1.setColor( Color.RED );
	r1.setWidth( 2 );
	r1.setHeight( 3 );
	assertTrue( r1.equals( r2 ) );
    }

    // Test Case 9: Equality test: false
    //
    @Test
    public void testEqualityFalse() {
	r1.setColor( Color.RED );
	r1.setWidth( 7 );
	r1.setHeight( 3 );
	assertTrue( !r1.equals( r2 ) );
    }

    // Test Case 10: toString test
    //
    @Test
    public void testToString() {
	r1.setColor( Color.RED );
	r1.setWidth( 5 );
	r1.setHeight( 4 );
	assertTrue( r1.toString().equals( "Rectangle: color: java.awt.Color[r=255,g=0,b=0] width: 5 height: 4" ) );
    }

}
