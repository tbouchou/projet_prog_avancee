package datatypes;

/**
 * Datatype localisation
 * @author Moi
 *
 */
public record LocationType (String longitude,String latitude) {
	public String toString() {
		return "La localisation est en longitude: "+longitude+" et latitude : "+latitude;
	}
}