package datatypes;

/**
 * Datatype temperature
 * @author Moi
 *
 */
public record TemperatureType (double temperature) {
	public String toString() {
		return "La temp�rature est de : "+temperature+" �C";
	}
}