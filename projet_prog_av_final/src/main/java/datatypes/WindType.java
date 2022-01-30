package datatypes;

/**
 * Datatype vitesse du vent
 * @author Moi
 *
 */
public record WindType (double windSpeed) {
	
	/**
	 * Méthode toString
	 */
	public WindType {
		if (windSpeed<0 || windSpeed>100)
			throw new IllegalArgumentException ("Erreur : vitesse de vent incorrect !");
	}
	public String toString() {
		return "La vitesse de vent est de : "+windSpeed+" /km/h";
	}
	
	public double getWindSpeed () {
		return windSpeed;
	}
}