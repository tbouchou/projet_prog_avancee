package datatypes;

/**
 * Datatype humidit�
 * @author Moi
 *
 */
public record HumidityType (double humidity) {
	public String toString() {
		return "Le taux d'humidit� est de : "+humidity+"%";
	}
}
