package datatypes;

/**
 * Datatype qualit� d'air
 * @author Moi
 *
 */
public record AirQualityType (int airQuality) {
	public String toString() {
		switch (airQuality) {
		case 1:
			return "La qualit� de l'air est bonne !";
		case 2:
			return "La qualit� de l'air est passable";
		case 3:
			return "La qualit� de l'air est mod�r�";
		case 4:
			return "La qualit� de l'air est mauvaise";
		default:
			return "La qualit� de l'air est tr�s mauvaise";
		}
}
}