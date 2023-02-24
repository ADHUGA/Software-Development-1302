package edu.uga.cs1302.vehicles;

import java.util.Scanner; //Importing keyboard

public class VehicleManager 
{
	public static void main(String[] args)
	{
		boolean repeat = true; //Boolean for while loop to continously give us options
		String userChoice; //Holds option by user
		
		Vehicle[] mobility = new Vehicle[15]; //All of my vehicles in an array
		mobility[0] = new Automobile("Batmobile", "Wayne Industries", 1966, 2, 329, 10000  );
		mobility[1] = new Automobile("Chick Magnet", "Johnny Bravo Industries", 1997, 2, 120, 1377 );
		mobility[2] = new Automobile("Flintstone Mobile", "Fred Industries", 1960, 4, 25, 20 );
		mobility[3] = new Airplane("Specter Speeder", "Fenton Works", 2004, 24, 3, 200, 38000, 10000000 );
		mobility[4] = new Airplane("Six Machine", "Viewtiful Joe", 2003, 6, 1, 150, 2000000, 2000000 );
		mobility[5] = new Airplane("Bebop", "Jet Black", 1998, 5, 10000, 16, 999999999, 999999999 );
		mobility[6] = new Ship("Flying Dutchman", "Nickelodeon", 1999, 50, 300, "Davy Jones", 149215);
		mobility[7] = new Ship("Leviathan", "The Almighty", 2017, 100000, 10000000, "Calus", 999999999);
		mobility[8] = new Ship("Sidon", "Zora Domain", 2017, 1, 125, "Mipha", 180 );
		mobility[9] = new Glider("Airbender Staff", "Air Temple Monks", 296, 1, 95, "Wood",50000, 500  );
		mobility[10] = new Glider("Static Saucer", "Virgil Hawkins", 1997, 1, 70, "Static Electricity", 75000, 60000 );
		mobility[11] = new Glider("Lucifer", "Devil May Cry", 2008, 1, 25, "Berial's Hell Gate", 30, 10 );
		mobility[12] = new Animal("Appa", "Team Avatar", 84, 7, 135, "Sky Bison" ,50000, 9999, 400);
		mobility[13] = new Animal("Naydra", "Golden Goddesses", 2017, 25, 350, "Spirit Dragon", 40000, 200000, 350);
		mobility[14] = new Animal("Druk", "The Fire Nation", 171, 5, 180, "Dragon",45000, 12000 ,300);
		
		while (repeat)
		{
			System.out.println("Press 1,2,3,4,5,6 for options considering the program. Press h to see help information and press q to terminate the program.");
			Scanner keyboard = new Scanner(System.in);
			userChoice = keyboard.nextLine();
			if (userChoice.equalsIgnoreCase("1"))
			{
				System.out.println("This is the toal number of vehicles in the system: " + Vehicle.COUNT); //Using protected static variable to count all vehicles
			}
			else if (userChoice.equalsIgnoreCase("2"))
			{
				for(int i = 0; i < mobility.length; i++)
				{
					System.out.println( "Name = " + mobility[i].toString() + ", Class = " + mobility[i].getClass().getSimpleName()); //Overriden toString with getSimpleName to give us the name and class name without the package
				}
			}
			else if (userChoice.equalsIgnoreCase("3"))
			{
				for(int i = 0; i < mobility.length; i++)
				{
					if(mobility[i] instanceof Flyable)
					{
						System.out.println("Name = " + mobility[i].toString() + " , Type = " + mobility[i].getClass().getSimpleName());
					}
				}
			}
			else if (userChoice.equalsIgnoreCase("4"))
			{
				for(int i = 0; i < mobility.length; i++)
				{
					if(mobility[i] instanceof Floatable)
					{
						System.out.println("Name = " + mobility[i].toString() + " , Type = " + mobility[i].getClass().getSimpleName());
					}
				}
			}
			else if (userChoice.equalsIgnoreCase("5"))
			{
				for(int i = 0; i < mobility.length; i++)
				{
					if(mobility[i] instanceof Floatable && mobility[i] instanceof Flyable)
					{
						System.out.println("Name = " + mobility[i].toString() + " , Type = " + mobility[i].getClass().getSimpleName());
					}
				}
			}
			else if (userChoice.equalsIgnoreCase("6"))
			{
				for(int i = 0; i < mobility.length; i++)
				{
					System.out.println("Type: " + mobility[i].getClass().getSimpleName());
					System.out.println("Name: " + mobility[i].getName());
					System.out.println("Manufacturer year: " + mobility[i].getManufacturer());
					System.out.println("Year: " + mobility[i].getYear());
					if(!(mobility[i]  instanceof Flyable) && !(mobility[i] instanceof Floatable))
					{
						if(mobility[i].getClass().equals(Automobile.class)) //This if statement and the one above is a bit redundant but incase I need another vehicle type.
						{
							Automobile au;
							au = (Automobile) mobility[i];
							System.out.println("Engine power: " + au.getHorsepower() + " hp");
						}
					}
					if(mobility[i] instanceof Flyable)
					{
						if(mobility[i].getClass().equals(Airplane.class))//Separation if the class implements Airplane
						{
							Airplane ai;
							ai = (Airplane) mobility[i];
							System.out.println("Number of engines = " + ai.getEngines());
							System.out.println("Max altitude: " + ai.getMaxAltitude() + " ft");
							System.out.println("Max range: " + ai.getMaxRange() + " mi");
						}
						else if(mobility[i].getClass().equals(Glider.class))
						{
							Glider gl;
							gl = (Glider) mobility[i];
							System.out.println("Type of material: " + gl.getWings());
							System.out.println("Max altitude: " + gl.getMaxAltitude() + " ft");
							System.out.println("Max range: " + gl.getMaxRange() + " mi");
						}
						else if(mobility[i].getClass().equals(Animal.class))
						{
							Animal an;
							an = (Animal) mobility[i];
							System.out.println("Type of beast: " + an.getBeast());
							System.out.println("Max altitude: " + an.getMaxAltitude() + " ft");
							System.out.println("Max range: " + an.getMaxRange() + " mi");
						}
					}
					if(mobility[i] instanceof Floatable)//Separation if the class implements Floatable
					{
						if(mobility[i].getClass().equals(Ship.class)) //Separation if the class implements Ship
						{
							Ship sh;
							sh = (Ship) mobility[i];
							System.out.println("Tonnage = " + sh.getTonnage());
							System.out.println("Owner = " + sh.getOwner());
						}
						else if(mobility[i].getClass().equals(Animal.class))
						{
							Animal an;
							an = (Animal) mobility[i];
							System.out.println("Tonnage = " + an.getTonnage());
						}
					}
					System.out.println("Max passengers: " + mobility[i].getMaxPassengers());
					System.out.println("Top Speed: " + mobility[i].getTopSpeed() + " mph");
					System.out.println(""); //Printing new line for clarity
				}
			}
			else if (userChoice.equalsIgnoreCase("h"))
			{
				System.out.println(" Press 1 to see how many vehicles are in the system.");
				System.out.println(" Press 2 to see the name and the class of each vehicle");
				System.out.println(" Press 3 to see which vehicles can fly. ");
				System.out.println(" Press 4 to see which vehicles can float. ");
				System.out.println(" Press 5 to see which vehicles can float AND fly. ");
				System.out.println(" Press 6 to see a description of each vehicle ");
				System.out.println(" Press h to see brief help information for your system ");
				System.out.println(" Press q to terminate the program. ");
			}
			else if (userChoice.equalsIgnoreCase("q"))
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Unrecognized command. Please enter a value 1-6, h for help, or q for quit.");
			}	
		}
		
	}
}
