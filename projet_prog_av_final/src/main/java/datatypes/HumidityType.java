package datatypes;

/**
 * Datatype humidit�
 * @author Moi
 *
 */
public record HumidityType (double humidity) {
	public HumidityType  {
		if (humidity<0 || humidity>100)
			throw new IllegalArgumentException ("Erreur : humidit� incorrecte !");
	}
	public String toString() {
		return "Le taux d'humidit� est de : "+humidity+"%";
	}
	public double getHumidity() {
		return humidity;
	}
}
