package datatypes;

/**
 * Datatype qualité d'air
 * @author Moi
 *
 */
public record AirQualityType (int airQuality) {
	public String toString() {
		switch (airQuality) {
		case 1:
			return "La qualité de l'air est bonne !";
		case 2:
			return "La qualité de l'air est passable";
		case 3:
			return "La qualité de l'air est modéré";
		case 4:
			return "La qualité de l'air est mauvaise";
		default:
			return "La qualité de l'air est très mauvaise";
		}
}
}