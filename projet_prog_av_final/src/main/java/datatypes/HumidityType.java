package datatypes;

/**
 * Datatype humidité
 * @author Moi
 *
 */
public record HumidityType (double humidity) {
	public HumidityType  {
		if (humidity<0 || humidity>100)
			throw new IllegalArgumentException ("Erreur : humidité incorrecte !");
	}
	public String toString() {
		return "Le taux d'humidité est de : "+humidity+"%";
	}
	public double getHumidity() {
		return humidity;
	}
}
