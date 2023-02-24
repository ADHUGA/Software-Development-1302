public class User 
{
    public static void main( String[] args)
    {
	// I am calling the static methods from the ident.jar file and putting them in a logical as you stated.
	System.out.println("I am " + UserIdentifier.getUserName() + " on " + UserIdentifier.getOSName());
    }
}
