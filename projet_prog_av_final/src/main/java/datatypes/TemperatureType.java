package datatypes;

/**
 * Datatype temperature
 * @author Moi
 *
 */
public record TemperatureType (double temperature) {
	public TemperatureType {
		if (temperature<-100 || temperature>100)
			throw new IllegalArgumentException ("Erreur : temp�rature incorrect !");
	}
	public String toString() {
		return "La temp�rature est de : "+temperature+" �C";
	}
	
	public double getTemperature () {
		return temperature;
	}
}