package entity;

import java.util.ArrayList;
import java.util.List;

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
	
	static List <Account> listeComptes = new ArrayList <Account>(); 

	/**
	 * Constructeur de la classe Account
	 * @param parLog
	 * @param parPass
	 */
	public Account(LoginType parLog,PasswordType parPass){
		id+=1;
		login=parLog;
		password=parPass;
		listeComptes.add(this);
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
	
	/**
	 * Permet de chercher un Account dans la liste de comptes
	 * @param id
	 * @param pwd
	 * @return boolean
	 */
	public static boolean chercherCompte (LoginType id,PasswordType pwd) {
		for (Account a : listeComptes) {
			if (a.getLogin().equals(id) && a.getPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Permet de récupérer la liste des comptes
	 * @return listeComptes
	 */
	public static List <Account> getAccountList () {
		return listeComptes;
	}
	
	/**
	 * Permet de récupérer un Account parmi la liste de comptes
	 * @param id
	 * @param pwd
	 * @return account
	 */
	public static Account getCompte (LoginType id,PasswordType pwd) {
		for (Account a : listeComptes) {
			if (a.getLogin().equals(id) && a.getPassword().equals(pwd)) {
				return a;
			}
		}
		return null;
	}

	public String toString() {
		return login + "-" + password;
	}

}
