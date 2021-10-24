package model;

import datatypes.LoginType;
import datatypes.PasswordType;

/**
 * La classe Account permettra de gérer un compte avec ses préférences
 * @author Moi
 *
 */
public class Account {

	static int id=0;
	LoginType login;
	PasswordType password;

	/**
	 * Constructeur de la classe Account
	 * @param parLog
	 * @param parPass
	 */
	public Account(LoginType parLog,PasswordType parPass){
		id+=1;
		login=parLog;
		password=parPass;
	}

	/**
	 * Getter id utilisateur
	 * @return id
	 */
	public int getId (){
		return id;
	}

	/**
	 * Getter mot de passe
	 * @return password
	 */
	public PasswordType getPassword (){
		return password;
	}

	/**
	 * Getter nom d'utilisateur
	 * @return login
	 */ 
	public LoginType getLogin (){
		return login;
	}

}
