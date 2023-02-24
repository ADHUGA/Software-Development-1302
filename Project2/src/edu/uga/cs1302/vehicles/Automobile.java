package edu.uga.cs1302.vehicles;

public class Automobile extends Vehicle
{
    private int horsepower;//This is private to ensure proper encapsulation.
    
    public Automobile(String n, String m, int y, int p, int s, int h) //Parameter matches that of the parent class with the added variable of h set to exclusive variable of automobile.
    {
    	super( n, m, y, p, s); //Using parent's parameters.
    	horsepower = h;
    }
    
    public int getHorsepower()
    {
    	return horsepower;
    }

    public void setHorsepower(int h)
    {
    	horsepower = h;
    }
    
    @Override
    public boolean equals(Object obj) //Overriden equals method just in case I needed it.
    {
    	if( obj == this) return true;
    	if(obj == null || !(obj instanceof Vehicle)) return false;
    	Vehicle otherVehicle = (Vehicle) obj;
    	return getName() != null && getName().equals(otherVehicle.getName() ) && getManufacturer() != null && getManufacturer().equals(otherVehicle.getManufacturer()) && getYear() == otherVehicle.getYear() && getMaxPassengers() == otherVehicle.getMaxPassengers() && getTopSpeed() == otherVehicle.getTopSpeed();	
    }    
}
