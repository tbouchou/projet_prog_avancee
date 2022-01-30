package datatypes;

/**
 * Datatype login
 * @author Moi
 *
 */
public record LoginType (String login){
	static boolean isValid = false;
	public LoginType {
		if (login.length()<6 || login.length()>20)
			throw new IllegalArgumentException ("Le login doit contenir entre 6 et 20 caractères");
		isValid=true;
			
	}
	public boolean isValid () {
		return isValid;
	}

}