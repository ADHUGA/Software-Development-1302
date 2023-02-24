package edu.uga.cs1302.vehicles;

public class Animal extends Vehicle implements Flyable, Floatable //Added comma for multiple implements
{
    private String beast;//This is private to ensure proper encapsulation.
    private int maxRange;//This is private to ensure proper encapsulation.
    private int maxAltitude;//This is private to ensure proper encapsulation.
    private int tonnage;//This is private to ensure proper encapsulation.
    
    public Animal(String n, String m, int y, int p, int s, String b, int mA, int mR,int t)//Parameter matches that of the parent class with the added variable of b set to exclusive variable of animal.
    {
    	super( n, m, y, p, s);//Using parent's parameters.
    	beast = b;
    	maxAltitude = mA;
    	maxRange = mR;
    	tonnage = t;
    }

    public String getBeast()
    {
    	return beast;
    }

    public void setBeast(String b)
    {
    	beast = b;
    }

    @Override
    public int getMaxAltitude() 
    {
       return maxAltitude;
    }

    @Override
    public void setMaxAltitude(int maxAltitude) 
    {
       this.maxAltitude = maxAltitude;
    }

    @Override
    public int getMaxRange() 
    {
       return maxRange;
    }

    @Override
    public void setMaxRange(int maxRange) 
    {
       this.maxRange = maxRange;
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
