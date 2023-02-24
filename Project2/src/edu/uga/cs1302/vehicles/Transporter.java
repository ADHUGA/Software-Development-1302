package edu.uga.cs1302.vehicles;

public interface Transporter //Interface with methods that have no body
{
	public int getMaxPassengers();
	public void setMaxPassengers(int maxPassengers);
	public int getTopSpeed();
	public void setTopSpeed(int topSpeed);
}