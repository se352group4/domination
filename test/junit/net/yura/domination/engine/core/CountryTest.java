package net.yura.domination.engine.core;

import org.junit.Test;
import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;

public class CountryTest extends TestCase{
	
	private Country country;
	private Country neighbour1;
	private Country neighbour2;
	private Country nonNeightbour;
	private Country crossContinentNeighbour;
	private Continent Continent;
	private Continent neighbourContinent;
	private List<Country> crossContinentCountries;
        
	protected void setUp() {
		Continent = new Continent("timmay", "North Murca", 5, 8);
		neighbourContinent = new Continent("beep", "South Murca", 3, 10);
		country = new Country(0, "1", "zimbabwe", Continent, 100, 100);
		neighbour1 = new Country(0, "2", "Kansas", Continent, 200,200);
		neighbour2 = new Country(0, "3", "Mississippi", Continent, 150,300);
		nonNeightbour = new Country(0, "4", "Maine", Continent, 10,90);
		crossContinentNeighbour = new Country(0, "4", "Alaska", neighbourContinent, 10,90);
                crossContinentCountries = new ArrayList<Country>(2);
                crossContinentCountries.add(crossContinentNeighbour);
                
	}
	@Test
	public void testNeighbours() {
                assertFalse(country.isNeighbours(neighbour1));
		country.addNeighbour(neighbour1);
		assertTrue(country.isNeighbours(neighbour1));
                
                assertFalse(country.isNeighbours(neighbour2));
		country.addNeighbour(neighbour2);
		assertTrue(country.isNeighbours(neighbour2));
                
                assertEquals(new ArrayList<Country>(2), country.getCrossContinentNeighbours());
                
                assertFalse(country.isNeighbours(crossContinentNeighbour));
		country.addNeighbour(crossContinentNeighbour);
		assertTrue(country.isNeighbours(crossContinentNeighbour));
                
                assertEquals(crossContinentCountries, country.getCrossContinentNeighbours());
                
                assertFalse(country.isNeighbours(nonNeightbour));
	}
        
        @Test
	public void testArmies() {
            assertEquals(0, country.getArmies());
            country.addArmies(5);
            assertEquals(5, country.getArmies());
            country.addArmy();
            assertEquals(6, country.getArmies());
            country.removeArmies(4);
            assertEquals(2, country.getArmies());
            country.looseArmy();
            assertEquals(1, country.getArmies());
        }

        
}
