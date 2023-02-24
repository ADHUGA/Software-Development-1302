package edu.uga.cs1302.vehicles;

public abstract class Vehicle implements Transporter
{
    private String name;//This is private to ensure proper encapsulation.
    private String manufacturer;//This is private to ensure proper encapsulation.
    private int year;//This is private to ensure proper encapsulation.
    private int maxPassengers; //This is private to ensure proper encapsulation.
    private int topSpeed;	//This is private to ensure proper encapsulation.
    protected static int COUNT = 0; //This is protected so it can be used in the child classes. Not public because I can't violate encapsulation

    //This is a constructor
    public Vehicle(String n, String m, int y, int p, int s)
    {
		name = n;
		manufacturer = m;
		year = y;
		maxPassengers = p;
		topSpeed = s;
		COUNT++;
    }
    
    public String getName () //public getter to get name so it can be used anywhere
    {
    	return name;
    }
    
    public void setName (String n)
    {
    	this.name = n;
    }
    
    public String getManufacturer () //public getter to get manufacturer so it can be used anywhere
    {
    	return manufacturer;
    }
    
    public void setManufacturer (String m)
    {
    	this.manufacturer = m;
    }
    
    public int getYear () //public getter to get year so it can be used anywhere
    {
    	return year;
    }
    
    public void setYear (int y)
    {
    	this.year = y;
    }
    
    @Override //Addeed overide
    public int getMaxPassengers ()
    {
    	return maxPassengers;
    }

    @Override
    public void setMaxPassengers (int maxPassengers)
    {
    	this.maxPassengers = maxPassengers;
    }

    @Override
    public int getTopSpeed () //public getter to get topSPeed so it can be used anywhere
    {
    	return topSpeed;
    }

    @Override
    public void setTopSpeed (int topSpeed) 
    {
    	this.topSpeed = topSpeed;
    }
    
    @Override
    public String toString ()
    {
    	return this.name;
    }
    
    @Override
    public boolean equals(Object obj) //Overriden equals method just in case I needed it.
    {
    	if( obj == this) return true;
    	if(obj == null || !(obj instanceof Vehicle)) return false;
    	Vehicle otherVehicle = (Vehicle) obj;
    	return name != null && name.equals(otherVehicle.name ) && manufacturer != null && manufacturer.equals(otherVehicle.manufacturer) && year == otherVehicle.year && maxPassengers == otherVehicle.maxPassengers && topSpeed == otherVehicle.topSpeed;
    	
    }
}
