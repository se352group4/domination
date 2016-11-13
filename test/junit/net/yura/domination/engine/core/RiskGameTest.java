package net.yura.domination.engine.core;

import java.io.File;
import junit.framework.TestCase;
import net.yura.domination.engine.RiskUIUtil;

public class RiskGameTest extends TestCase {
    
    private Continent continent;
    private Country country1;
    private Country country2;
    private Country country3;
    private Country country4;
    private Country country5;
    private Country country6;
    private Country country7;
    private Country country8;
    private Country country9;
    private Country country10;
    private Player p1;
    private Player p2;
    
    public RiskGameTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
        
        continent = new Continent("timmay", "North Murca", 5, 8);
        country1 = new Country(0, "1", "zimbabwe", continent, 100, 100);
        country2 = new Country(1, "2", "Djibouti", continent, 200, 200);
        country3 = new Country(2, "3", "tom", continent, 300, 100);
        country4 = new Country(3, "4", "bob", continent, 200, 300);
        country5 = new Country(4, "5", "here", continent, 500, 100);
        country6 = new Country(5, "6", "there", continent, 200, 500);
        country7 = new Country(6, "7", "where", continent, 400, 100);
        country8 = new Country(7, "8", "murca", continent, 200, 400);
        country9 = new Country(8, "9", "canada", continent, 500, 500);
        country10 = new Country(9, "10", "mexico", continent, 400, 400);
        p1 = new Player(0, "tester", 7, "here");    
        p2 = new Player(0, "tester2", 9, "there");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of trade method, of class RiskGame.
     */
    public void testTrade() {
        System.out.println("trade");
      
        RiskGame instance;

        try {
            RiskUIUtil.mapsdir = new File("./game/Domination/maps").toURI().toURL();
            instance = new RiskGame();
        }
        catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        
        //Country country =  new Country(1, "name", "Full Name", new Continent("name", "Full Name", 5, 0xFFFF0000), 10, 10);
        // 3 different cards = there are 24 combinations

        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.CANNON, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );


        // 3 cards are the same - 4 combinations
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );


        // 2 cards are the same - CANNON
        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.CANNON, RiskGame.CARD_INCREASING_SET) );

        // 2 cards are the same - INFANTRY
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );

        // 2 cards are the same - CAVALRY
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.CANNON, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        // 2 cards are the same - WILDCARD
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.CANNON, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );

        assertEquals(4, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );
        assertEquals(4, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_INCREASING_SET) );














        int all_INFANTRY = 4;
        int all_CAVALRY = 6;
        int all_CANNON = 8;
        int all_DIFF = 10;
        int all_WILDCARD = 12;


        // 3 different cards = there are 24 combinations

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.CANNON, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );


        // 3 cards are the same - 4 combinations
        assertEquals(all_CANNON, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_INFANTRY, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_CAVALRY, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_WILDCARD, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );


        // 2 cards are the same - CANNON
        assertEquals(all_CANNON, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_CANNON, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_CANNON, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.CANNON, RiskGame.CARD_FIXED_SET) );

        // 2 cards are the same - INFANTRY
        assertEquals(all_INFANTRY, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_INFANTRY, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_INFANTRY, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );

        // 2 cards are the same - CAVALRY
        assertEquals(all_CAVALRY, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.CANNON, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_CAVALRY, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_CAVALRY, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        // 2 cards are the same - WILDCARD
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.CANNON, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_FIXED_SET) );


        
        
        
        
        
        
        
        
        
        all_INFANTRY = 6;//4;
        all_CAVALRY = 8;//6;
        all_CANNON = 4;//8;
        all_DIFF = 10;
        int one_wildcard_2_the_same = 12;
        int one_wildcard_2_different = 0;
        int two_wildcards = 0;
        all_WILDCARD = 0;//12;


        // 3 different cards = there are 24 combinations

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(all_DIFF, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(one_wildcard_2_different, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );


        // 3 cards are the same - 4 combinations
        assertEquals(all_CANNON, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(all_INFANTRY, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(all_CAVALRY, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(all_WILDCARD, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );


        // 2 cards are the same - CANNON
        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CANNON, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );

        // 2 cards are the same - INFANTRY
        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CANNON, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );

        // 2 cards are the same - CAVALRY
        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CAVALRY, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.INFANTRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CAVALRY, Card.CANNON, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(one_wildcard_2_the_same, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.INFANTRY, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(0, instance.getTradeAbsValue(Card.CANNON, Card.CAVALRY, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        // 2 cards are the same - WILDCARD
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.CANNON, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.INFANTRY, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.WILDCARD, Card.WILDCARD, Card.CAVALRY, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.WILDCARD, Card.CANNON, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.WILDCARD, Card.INFANTRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.WILDCARD, Card.CAVALRY, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );

        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.CANNON, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.INFANTRY, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        assertEquals(two_wildcards, instance.getTradeAbsValue(Card.CAVALRY, Card.WILDCARD, Card.WILDCARD, RiskGame.CARD_ITALIANLIKE_SET) );
        
        
        
        
    }

    public void testAddDelPlayers()
    {
        RiskGame instance;

        try {
            RiskUIUtil.mapsdir = new File("./game/Domination/maps").toURI().toURL();
            instance = new RiskGame();
        }
        catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        
        assertFalse(instance.delPlayer("tester"));
        
        assertTrue(instance.addPlayer(0, "tester", 7, "here"));
        assertTrue(instance.addPlayer(0, "tester2", 9, "there"));
        
        assertFalse(instance.delPlayer("tester3"));
        
        assertTrue(instance.addPlayer(0, "tester3", 11, "where"));
        assertTrue(instance.delPlayer("tester3"));
        
        try {
            instance.startGame(0, 0, true, true);
        }
        catch(Exception ex) {
            fail();
        }
        
        assertFalse(instance.addPlayer(0, "fail", 0, "nowhere"));
        assertFalse(instance.delPlayer("tester"));
    }
    
    private RiskGame checkPlayerWonSetup()
    {
        RiskGame instance;

        try {
            RiskUIUtil.mapsdir = new File("./game/Domination/maps").toURI().toURL();
            instance = new RiskGame();
        }
        catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        
        try {
            // Add three players
            instance.addPlayer(0, "tester1", 1, "one");
            instance.addPlayer(0, "tester2", 2, "two");
            instance.addPlayer(0, "tester3", 3, "3");
            
            // Start the game
            instance.startGame(0, 0, true, true);
        }
        catch(Exception ex) {
            fail();
        }
        return instance;
    }

    public void testCheckPlayerWonImmediate()
    {
        RiskGame instance = checkPlayerWonSetup();
        // No player should have won right after the game starts
        assertFalse(instance.checkPlayerWon());
    }

    public void testCheckPlayerWonWithAllCountries()
    {
        RiskGame instance = checkPlayerWonSetup();
        
        // Set up the player to win
        instance.setCurrentPlayer(1);
        Player plyr = instance.getCurrentPlayer();
        
        // Set up the play to own all the countries
        for(Country c : instance.getCountries()){
            c.setOwner(plyr);
        }
        
        // The player should have won
        assertTrue(instance.checkPlayerWon());
    }
    
    public void testCheckPlayerWonWithAllButOneCountries()
    {
        RiskGame instance = checkPlayerWonSetup();
        
        // Set up the player to win
        instance.setCurrentPlayer(1);
        Player plyr = instance.getCurrentPlayer();
        
        Country[] cList = instance.getCountries();
        
        // Set up the player to own all the countries but one
        for(Country c : cList) c.setOwner(plyr);
        if (cList.length > 0) cList[0].setOwner(null);
        
        // The player should not have won
        assertFalse(instance.checkPlayerWon());
    }

    public void testNoEmptyCountries()
    {
        RiskGame instance = checkPlayerWonSetup();

        //There are empty countries initially
        assertFalse(instance.NoEmptyCountries());
        
        // Set up the player to own countries
        instance.setCurrentPlayer(1);
        Player plyr = instance.getCurrentPlayer();
        
        Country[] cList = instance.getCountries();
        
        // Set up the player to own all the countries
        for(Country c : cList) c.setOwner(plyr);
        
        //There should be no empty countries now
        assertTrue(instance.NoEmptyCountries());
        
        // make a single country empty
        if (cList.length > 0) cList[0].setOwner(null);
        
        //There should be an empty country now
        assertFalse(instance.NoEmptyCountries());
    }
    
     public void testGetConnectedEmpire()
    {
         RiskGame instance = checkPlayerWonSetup();
        
        
        
        country1.addNeighbour(country2);
        country1.addNeighbour(country3);
        country2.addNeighbour(country1);
        country2.addNeighbour(country4);
        country3.addNeighbour(country1);
        country3.addNeighbour(country5);
        country4.addNeighbour(country2);
        country4.addNeighbour(country6);
        country4.addNeighbour(country7);
        country5.addNeighbour(country3);
        country5.addNeighbour(country8);
        country5.addNeighbour(country9);
        country6.addNeighbour(country4);
        country6.addNeighbour(country7);
        country7.addNeighbour(country4);
        country7.addNeighbour(country6);
        country8.addNeighbour(country9);
        country8.addNeighbour(country5);
        country9.addNeighbour(country5);
        country9.addNeighbour(country8);
        country9.addNeighbour(country10);
        country10.addNeighbour(country9);
        
        
        Country[] array = new Country[10];
        array[0] = country1;
        array[1] = country2;
        array[2] = country3;
        array[3] = country4;
        array[4] = country5;
        array[5] = country6;
        array[6] = country7;
        array[7] = country8;
        array[8] = country9;
        array[9] = country10;
        
        for(Country c : array) 
        {
            c.setOwner(p1);
            p1.newCountry(c);
        }
        p1.lostCountry(country5);
        country5.setOwner(p2);
        p2.newCountry(country5);
        
        assertEquals(6, instance.getConnectedEmpire(p1).size());
        
        p2.lostCountry(country5);
        country5.setOwner(p1);
        p1.newCountry(country5);
        
        assertEquals(10, instance.getConnectedEmpire(p1).size());
        try 
        {
        setUp();
        }
        catch (Exception e) {}
    }
}
