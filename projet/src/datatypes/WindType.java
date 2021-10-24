package datatypes;

/**
 * Datatype vitesse du vent
 * @author Moi
 *
 */
public record WindType (double windSpeed) {
	
	/**
	 * M�thode toString
	 */
	public String toString() {
		return "La vitesse de vent est de : "+windSpeed+" /km/h";
	}
}