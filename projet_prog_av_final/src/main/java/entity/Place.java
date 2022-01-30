package entity;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import datatypes.AirQualityType;
import datatypes.HumidityType;
import datatypes.LocationType;
import datatypes.TemperatureType;
import datatypes.WindType;

/**
 * La classe Place, permet de g�n�rer une instance regroupant les informations m�t�orologiques souhait�es
 * @author Moi
 *
 */
public class Place {
	AirQualityType airQuality ;
	WindType windSpeed;
	LocationType location;
	TemperatureType temperature;
	HumidityType humidity;

	/**
	 * Constructeur de la classe Place
	 * @param parAirQuality
	 * @param parWindSpeed
	 * @param parLocation
	 * @param parTemperature
	 * @param parHumidity
	 */
	public Place(AirQualityType parAirQuality,WindType parWindSpeed,LocationType parLocation,TemperatureType parTemperature,HumidityType parHumidity){
		airQuality=parAirQuality;
		windSpeed=parWindSpeed;
		location=parLocation;
		temperature=parTemperature;
		humidity=parHumidity;
	}

	/**
	 * M�thode toString, retourne la t�mp�rature, la vitesse du vent, l'humidit�, la localisation et la qualit� de l'air
	 */
	public String toString() {
		
		return "Temperature : "+temperature+"\n"+
				"Vitesse de vent : "+windSpeed+"\n"+
				"Humidit� : "+humidity+"\n"+
				"Localisation : "+location+"\n"+
				"Qualit� de l'air : "+airQuality+"\n";
		
	}
	
	/**
	 * Getter qualit� de l'air
	 * @return airQuality
	 */
	public AirQualityType getAirQuality() {
		return airQuality;
	}

	/**
	 * Getter vitesse du vent
	 * @return windSpeed
	 */
	public WindType getWind() {
		return windSpeed;
	}

	/**
	 * Getter localisation
	 * @return location
	 */
	public LocationType getLocation() {
		return location;
	}

	/**
	 * Getter temperature
	 * @return temperature
	 */
	public TemperatureType getTemperature (){
		return temperature;
	}

	/**
	 * Getter humidit�
	 * @return humidity
	 */
	public HumidityType getHumidity() {
		return humidity;
	}
	
		
		
		
}
