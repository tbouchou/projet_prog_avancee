package datatypes;

/**
 * Datatype temperature
 * @author Moi
 *
 */
public record TemperatureType (double temperature) {
	public String toString() {
		return "La température est de : "+temperature+" °C";
	}
}