package datatypes;

/**
 * Datatype humidité
 * @author Moi
 *
 */
public record HumidityType (double humidity) {
	public String toString() {
		return "Le taux d'humidité est de : "+humidity+"%";
	}
}
