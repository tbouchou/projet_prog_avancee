package datatypes;

/**
 * Datatype mot de passe
 * @author Moi
 *
 */
public record PasswordType (String password) {
	public PasswordType {
		boolean isValid = true;
		String errorMessage = "";

        if (password.length() < 8 || password.length() > 20)
        {
                System.out.println("Password must be less than 20 and more than 8 characters in length.");
                isValid = false;
                errorMessage+="Password must be less than 20 and more than 8 characters in length.\n";
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
                System.out.println("Password must have atleast one uppercase character");
                isValid = false;
                errorMessage+="Password must have atleast one uppercase character\n";
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
                System.out.println("Password must have atleast one lowercase character");
                isValid = false;
                errorMessage+="Password must have atleast one lowercase character\n";
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
                System.out.println("Password must have atleast one number");
                isValid = false;
                errorMessage+="Password must have atleast one number\n";
        }
        String specialChars = "(.*[@,#,$,%,&,*].*)";
        if (!password.matches(specialChars ))
        {
                System.out.println("Password must have atleast one special character among @#$%");
                isValid = false;
                errorMessage+="Password must have atleast one special character among @#$%";
        }
        if (!isValid)
        	throw new IllegalArgumentException ("Le mot de passe ne respecte pas la complexité requise");
	}
	/*public boolean isValid () {
		return isValid;
	}*/
}