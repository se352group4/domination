package net.yura.domination.engine.core;

import junit.framework.TestCase;

public class ContinentTest extends TestCase {
    
    private Continent continent;
    private Country country;
    private Country country2;
    private Player player;
    private Player player2;
    
    public void setUp() {
        continent = new Continent("con1", "Continent 1", 5, 1);
        country = new Country(0, "cou1", "Country 1", continent, 0, 0);
        country2 = new Country(1, "cou2", "Country 2", continent, 50, 50);
        player = new Player(0, "Player 1", 0, "address");
        player2 = new Player(0, "Player 2", 1, "address2");
    }
    
    public void testTerritoriesContained() {
        assertFalse(continent.getTerritoriesContained().contains(country));
        
        continent.addTerritoriesContained(country);
        assertTrue(continent.getTerritoriesContained().contains(country));
        
        continent.addTerritoriesContained(country2);
        assertTrue(continent.getTerritoriesContained().contains(country2));
    }
    
    public void testGetOwner() {
        assertEquals(null, country.getOwner());
        
        country.setOwner(player);
        assertEquals("Player 1", country.getOwner().toString());
        
        country.setOwner(player2);
        assertEquals("Player 2", country.getOwner().toString());
    }
    
    public void testGetNumberOwned() {
        assertEquals(0, continent.getNumberOwned(player));
        
        continent.addTerritoriesContained(country);
        country.setOwner(player);
        assertEquals(1, continent.getNumberOwned(player));
        
        continent.addTerritoriesContained(country2);
        country2.setOwner(player);
        assertEquals(2, continent.getNumberOwned(player));
    }
    
    public void testIsOwned() {
        continent.addTerritoriesContained(country);
        country.setOwner(player);
        assertTrue(continent.isOwned(player));
        
        continent.addTerritoriesContained(country2);
        assertFalse(continent.isOwned(player));
        
        country2.setOwner(player);
        assertTrue(continent.isOwned(player));
    }
    
    public void testGetBorderCountries() {
        // TODO: Test this
    }
    
}
