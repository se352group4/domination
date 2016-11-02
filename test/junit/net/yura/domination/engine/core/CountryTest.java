package net.yura.domination.engine.core;

import org.junit.Test;
import junit.framework.TestCase;
import java.util.List;
import java.util.Collections;

public class CountryTest extends TestCase{
	
	private Country country;
	private Country neighbour1;
	private Country neighbour2;
	private Country nonNeightbour;
	private Country crossContinentNeighbour;
	private Continent continent;
	private Continent neighbourContinent;
	private List<Country> crossContinentCountries;
        
	protected void setUp() {
		continent = new Continent("timmay", "North Murca", 5, 8);
		neighbourContinent = new Continent("beep", "South Murca", 3, 10);
		country = new Country(0, "1", "zimbabwe", continent, 100, 100);
		neighbour1 = new Country(0, "2", "Kansas", continent, 200, 200);
		neighbour2 = new Country(0, "3", "Mississippi", continent, 150, 300);
		nonNeightbour = new Country(0, "4", "Maine", continent, 10, 90);
		crossContinentNeighbour = new Country(0, "4", "Alaska", neighbourContinent, 10, 90);
                crossContinentCountries = Collections.singletonList(crossContinentNeighbour);                
	}
	@Test
	public void testNeighbours() {
                assertFalse(country.isNeighbours(neighbour1));
		country.addNeighbour(neighbour1);
		assertTrue(country.isNeighbours(neighbour1));
                
                assertFalse(country.isNeighbours(neighbour2));
		country.addNeighbour(neighbour2);
		assertTrue(country.isNeighbours(neighbour2));
                
                assertEquals(Collections.emptyList(), country.getCrossContinentNeighbours());
                
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
