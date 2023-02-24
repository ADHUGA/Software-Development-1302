package edu.uga.cs1302.vehicles;

public class Ship extends Vehicle implements Floatable
{
    private String owner;
    private int tonnage;
    
    public Ship(String n, String m, int y, int p, int s, String o,int t)//Parameter matches that of the parent class with the added variable of o exclusive to owner.
    {
    	super( n, m, y, p, s);//Using parent's parameters.
    	owner = o;
    	tonnage = t;
    }
    
    public String getOwner()
    {
    	return owner;
    }

    public void setOwner(String o)
    {
    	owner = o;
    }

    @Override
    public int getTonnage() 
    {
	 return tonnage;
    }

    @Override
    public void setTonnage(int tonnage) 
    {
	 this.tonnage = tonnage;
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
