package datatypes;

/**
 * Datatype localisation
 * @author Moi
 *
 */
public record LocationType (double longitude,double latitude) {
	public LocationType {
		if (latitude<-90 || latitude>90 || longitude<-180 || longitude>180)
			throw new IllegalArgumentException ("Erreur : latitude ou longitude incorrecte(s) !");
	}
	public String toString() {
		return "La localisation est en longitude: "+longitude+" et latitude : "+latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	
}