package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import datatypes.*;

class TestProjet {

	@Test
	void testTemperature() {
		TemperatureType pwd = new TemperatureType(100);
		assertThrows(IllegalArgumentException.class, () -> new TemperatureType(-1100),"Température incorrect");
		Assertions.assertEquals(100,pwd.getTemperature());
		
	}
	
	@Test
	void testHumidity() {
		HumidityType hmd = new HumidityType (20);
		assertThrows(IllegalArgumentException.class, () -> new HumidityType(-1100),"Humidité incorrect");
		Assertions.assertEquals(20,hmd.getHumidity());
	}
	
	@Test
	void testLocation() {
		LocationType loc = new LocationType (180,20);
		assertThrows(IllegalArgumentException.class, () -> new LocationType(-1100,9000),"Localisation incorrect");
		Assertions.assertEquals(180,loc.getLongitude());
		Assertions.assertEquals(20,loc.getLatitude());
	}

	@Test
	void testLogin() {
		LoginType log = new LoginType ("azertyuiop");
		assertThrows(IllegalArgumentException.class, () -> new LoginType("aaab"),"Identifiant incorrect");
		Assertions.assertEquals(true,log.isValid());
	}
	
	@Test
	void testVent() {
		WindType wnd = new WindType (50);
		Assertions.assertEquals(50,wnd.getWindSpeed());
		assertThrows(IllegalArgumentException.class, () -> new WindType(200),"Vitesse vent incorrect");

	}
	
	
	
}
