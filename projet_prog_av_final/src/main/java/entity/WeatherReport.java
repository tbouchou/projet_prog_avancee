package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import datatypes.*;



/**
 * La classe WeatherReport, permet de générer un compte-rendu de données météorologiques actuelles :
 * température, vitesse du vent, humidité, localisation et qualité de l'air
 * @author Moi
 *
 */
public class WeatherReport {
	
	Account compte;
	Place place;
	Date date ; 
	static List <WeatherReport> listWR = new ArrayList <WeatherReport>();
	String ville;
	String imgURL;
	
	/**
	 * Constructeur WeatherReport
	 * @param parCompte
	 * @param parPlace
	 */
	public WeatherReport (Account parCompte,Place parPlace) {
		this.date=new Date(System.currentTimeMillis());
		this.compte=parCompte;
		this.place=parPlace;
	}	
	
	
	private static final String API_KEY = "a4036c6f889794512116e3a729b2f0a7";
    	static BufferedReader reader;
    	static String line;
    	static StringBuffer responseContent = new StringBuffer();
		private static HttpURLConnection connection;
    	
		
		static AirQualityType airQuality ;
		static WindType windSpeed;
		static LocationType location;
		static TemperatureType temperature;
		static HumidityType humidity; 
		
		

		/**
		 * Constructeur WeatherReport, permet à l'utilisateur de choisir la ville pour laquelle il souhaite des informations au travers de l'API OpenWeather
		 * @param args
		 */
    	public WeatherReport(String ville,Account parCompte){

    		this.ville=ville;
    		compte=parCompte;
    	String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+ville+"&appid="+ API_KEY + "&lang=French&units=metric" ;

		try {
			
			StringBuffer responseContent = getStringBuffer(urlString);
			
			if (responseContent.indexOf("city not found")!=-1) {
				throw new IllegalArgumentException ("erreur");
			}
			Map<String,Object> respMap = jsonToMap(responseContent.toString());
			
			this.date=new Date(System.currentTimeMillis());
			Map<String,Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String,Object> coordMap = jsonToMap(respMap.get("coord").toString());
			Map<String,Object> windMap = jsonToMap(respMap.get("wind").toString());
			String imgMap = respMap.get("weather").toString();
			//imgMap = imgMap.replace("[", "");
			//imgMap = imgMap.replace("]", "");
			imgMap = imgMap.replace("=", ":");
			JSONArray array = new JSONArray(imgMap);  
			for(int i=0; i < array.length(); i++)   
			{  
				JSONObject object = array.getJSONObject(i);  
				imgURL=object.getString("icon");  
			}
			
			double lat= (double) coordMap.get("lat");
			double lon = (double) coordMap.get("lon");
			
			int qualiteAir = airIndex(lat,lon);
			double windType=(double) windMap.get("speed");
			double tempType=(double) mainMap.get("temp");
			double humType=(double) mainMap.get("humidity");
			
			airQuality = new AirQualityType(qualiteAir);
			windSpeed = new WindType(windType);
			location= new LocationType(lat,lon);
			temperature= new TemperatureType(tempType);
			humidity=new HumidityType(humType);
			
			place = new Place(airQuality,windSpeed,location,temperature,humidity);
			
			System.out.println(place);
			listWR.add(this);
					
			
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
	    } 
    	
    	/**
    	 * Méthode getStringBuffer, permet de retourner l'ensemble des informations contenu dans l'URL de l'API prit en paramètre
    	 * @param urlS
    	 * @return responseContent
    	 * @throws IOException
    	 */
    	public static StringBuffer getStringBuffer (String urlS) throws IOException {
			StringBuffer responseContent = new StringBuffer();
			URL url = new URL(urlS);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			if (status>299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				//responseContent.append('[');
				while ((line=reader.readLine()) != null){
					responseContent.append(line);
				}
				//responseContent.append(']');
				reader.close();
			}
			else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
				//responseContent.append('[');
				while ((line=reader.readLine()) != null){
					responseContent.append(line);
				}
				//responseContent.append(']');
				reader.close();
			}
			return responseContent;
		}
    	
    	/**
    	 * Méthode jsonToMap, permet comme son nom l'indique de transformer les données récupérées en json vers une map java
    	 * @param str
    	 * @return
    	 */
		public static Map<String,Object> jsonToMap (String str){
			Map<String,Object> map = new Gson().fromJson(
					str, new TypeToken<HashMap<String, Object>>() {}.getType()
					);
			return map;
		}

		/**
		 * Méthode airIndex, permet de récupérer l'index de qualité d'air à partir de données géographique
		 * @param lat
		 * @param lon
		 * @return
		 * @throws IOException
		 */
    	public static int airIndex (double lat,double lon) throws IOException {
			String urlS= "https://api.openweathermap.org/data/2.5/air_pollution?lat="+lat+"&lon="+lon+"&appid="+ API_KEY ;
   		 	StringBuffer responseContent = getStringBuffer(urlS);
			
			JSONObject obj= new JSONObject (responseContent.toString());
			JSONArray obj2= obj.getJSONArray("list");
			JSONObject obj3 = obj2.getJSONObject(0);
			JSONObject obj4 = obj3.getJSONObject("main");
			int index=(int) obj4.get("aqi");
			return index;
			
			
			
    	}
    	
    	/**
    	 * Getter place, retourne la Place du WeatherReport
    	 * @return place
    	 */
    	public Place getPlace () {
    		return place;
    	}
    	
    	/**
    	 * Getter static de la liste des WeatherReport
    	 * @return listWR
    	 */
    	public static List<WeatherReport> getListWR (){
    		return listWR;
    	}
    	
    	/**
    	 * Getter Account, retourne le Account du WeatherReport
    	 * @return
    	 */
    	public Account getAccount () {
    		return compte;
    	}
    	
    	/**
    	 * Getter Date, retourne la Date du WeatherReport
    	 * @return
    	 */
    	public Date getDate () {
    		return date;
    	}
    	
    	/**
    	 * Getter String, retourne la Ville du WeatherReport
    	 * @return ville
    	 */
    	public String getVille () {
    		return ville;
    	}
    	
    	/**
    	 * Getter String, retourne l'image OpenWeather pour le WeatherReport
    	 * @return imgURL
    	 */
    	public String getImgURL () {
    		return imgURL;
    	}
    	
}
