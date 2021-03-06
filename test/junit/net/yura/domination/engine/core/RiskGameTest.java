package net.yura.domination.engine.core;

import java.io.File;
import java.util.Vector;
import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;
import net.yura.domination.engine.RiskUIUtil;

public class RiskGameTest extends TestCase {
    
    private RiskGame instance;

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
    private Player plr1;
    private Player plr2;
    private Country[] countries;
    
    public RiskGameTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();

        try {
            RiskUIUtil.mapsdir = new File("./game/Domination/maps").toURI().toURL();
            instance = new RiskGame();
        }
        catch(Exception ex) {
            throw new RuntimeException(ex);
        }

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

    /**
     * Test of trade method, of class RiskGame.
     */
    public void testTrade() {
        System.out.println("trade");

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
    
    private void addPlayersAndStart()
    {
        try {
            // Add players
            instance.addPlayer(0, "tester1", 1, "one");
            instance.addPlayer(0, "tester2", 2, "two");
            
            // Start the game
            instance.startGame(0, 0, true, true);
        }
        catch(Exception ex) {
            fail();
        }
    }

    public void testCheckPlayerWonImmediate()
    {
        addPlayersAndStart();
        // No player should have won right after the game starts
        assertFalse(instance.checkPlayerWon());
    }

    public void testCheckPlayerWonWithAllCountries()
    {
        addPlayersAndStart();
        
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
        addPlayersAndStart();
        
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
        addPlayersAndStart();

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
        addPlayersAndStart();
        
        
        
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
     
    public void testRollDice()
    {
        addPlayersAndStart();
        
        int lastDie = 0;
        
        for(int i : instance.rollDice(5))
        {
            if(lastDie == 0)
                lastDie = i;
            else
            {
                assertTrue(i <= lastDie);
                lastDie = i;
            }
        }
    }
    
    public void testFindCardAndRemoveIt()
    {
        addPlayersAndStart();
        int count = instance.getCards().size();
        assertEquals(Card.WILDCARD, instance.findCardAndRemoveIt(Card.WILDCARD).getName());
        count -= 1;
        assertEquals(count, instance.getCards().size());
        assertEquals("Siam", instance.findCardAndRemoveIt("33").getCountry().getName());
        count -= 1;
        assertEquals(count, instance.getCards().size());
               
    }
    
    public void testGetCards()       
    {
        addPlayersAndStart();
        
        instance.setCurrentPlayer(00);
        
        instance.getCurrentPlayer().giveCard((Card)instance.getCards().firstElement());
        instance.getCurrentPlayer().giveCard((Card)instance.getCards().elementAt(15));
        instance.getCurrentPlayer().giveCard((Card)instance.getCards().lastElement());
                
        Card[] c = instance.getCards("1", "16", Card.WILDCARD);
        assertEquals("Alaska", c[0].getCountry().getName());
        assertEquals("Ukraine", c[1].getCountry().getName());
        assertEquals(Card.WILDCARD, c[2].getName());
        
    }

    private void getToSetupDone() {
        // Set up with 2 players
        assertEquals(0, instance.getPlayers().size());
        addPlayersAndStart();
        assertEquals(2, instance.getPlayers().size());

        // Leave Player 1 with 1 army
        plr1 = instance.getPlayer("tester1");
        plr1.loseExtraArmy(plr1.getExtraArmies() - 1);
        assertEquals(1, plr1.getExtraArmies());

        // Leave Player 2 with 1 army
        plr2 = instance.getPlayer("tester2");
        plr2.loseExtraArmy(plr2.getExtraArmies() - 1);
        assertEquals(1, plr2.getExtraArmies());

        // Assertions about the game state
        countries = instance.getCountries();
        assertTrue(countries.length > 3);
        assertTrue(countries[0].isNeighbours(countries[1]));
        assertEquals(RiskGame.STATE_PLACE_ARMIES, instance.getState());

        // Set player 1 to be the current player
        instance.setCurrentPlayer(0);

        //PLAYER 1
        assertEquals(plr1, instance.getCurrentPlayer());
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(0, plr1.getExtraArmies());
        instance.endGo();

        //PLAYER 2
        assertEquals(plr2, instance.getCurrentPlayer());
        assertEquals(1, instance.placeArmy(countries[1], 1));
        assertEquals(0, plr2.getExtraArmies());
        instance.endGo();

        assertTrue(instance.getSetupDone());
    }

    public void testGetNoAttackDice() {
        getToSetupDone();

        //PLAYER 1
        assertEquals(plr1, instance.getCurrentPlayer());
        assertEquals(3, plr1.getExtraArmies());
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(0, plr1.getExtraArmies());
        instance.endGo();

        assertTrue(instance.getSetupDone());

        assertEquals(RiskGame.STATE_ATTACKING, instance.getState());

        instance.attack(countries[0], countries[1]);

        assertEquals(3, instance.getNoAttackDice());
    }

    public void testGetNoAttackDiceNegativeArmies() {
        getToSetupDone();
        //PLAYER 1
        assertEquals(plr1, instance.getCurrentPlayer());
        assertEquals(3, plr1.getExtraArmies());
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        plr1.loseExtraArmy(2);
        assertEquals(-1, plr1.getExtraArmies());
        assertEquals(1, instance.placeArmy(countries[0], -1));
        assertEquals(0, plr1.getExtraArmies());
        instance.endGo();

        assertTrue(instance.getSetupDone());

        assertEquals(RiskGame.STATE_ATTACKING, instance.getState());

        instance.attack(countries[0], countries[1]);

        assertEquals(3, instance.getNoAttackDice());
    }

    public void testGetNoDefenseDice() {
        getToSetupDone();

        //PLAYER 1
        assertEquals(plr1, instance.getCurrentPlayer());
        assertEquals(3, plr1.getExtraArmies());
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(0, plr1.getExtraArmies());
        instance.endGo();

        assertEquals(RiskGame.STATE_ATTACKING, instance.getState());

        instance.attack(countries[0], countries[1]);

        assertEquals(3, instance.getNoAttackDice());
        assertEquals(1, instance.getNoDefendDice());

        instance.retreat();
        instance.endAttack();
        instance.noMove();
        countries[0].removeArmies(2);
        instance.endGo();

        //PLAYER 2
        assertEquals(plr2, instance.getCurrentPlayer());
        assertEquals(3, plr2.getExtraArmies());
        assertEquals(1, instance.placeArmy(countries[1], 1));
        assertEquals(1, instance.placeArmy(countries[1], 1));
        assertEquals(1, instance.placeArmy(countries[1], 1));
        assertEquals(0, plr1.getExtraArmies());
        instance.endGo();

        assertEquals(RiskGame.STATE_ATTACKING, instance.getState());

        instance.attack(countries[1], countries[0]);

        assertEquals(3, instance.getNoAttackDice());
        assertEquals(2, instance.getNoDefendDice());

        instance.retreat();
        instance.endAttack();
        instance.noMove();
        instance.endGo();

        //PLAYER 1
        assertEquals(plr1, instance.getCurrentPlayer());
        assertEquals(3, plr1.getExtraArmies());
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(1, instance.placeArmy(countries[0], 1));
        assertEquals(0, plr1.getExtraArmies());
        instance.endGo();

        assertEquals(RiskGame.STATE_ATTACKING, instance.getState());

        instance.attack(countries[0], countries[1]);

        assertEquals(3, instance.getNoAttackDice());
        assertEquals(3, instance.getNoDefendDice());
    }
    public void testCanContinueDomination() {
        addPlayersAndStart();

        // start domination game
        try {
            instance.startGame(0, 0, true, true);
        }
        catch(Exception ex) {
            fail();
        }
        // Set up the player to win
        instance.setCurrentPlayer(1);
        Player plyr = instance.getCurrentPlayer();

        // Set up the play to own all the countries
        for(Country c : instance.getCountries()){
            c.setOwner(plyr);
        }

        instance.checkPlayerWon();

        // Player can not continue because game is domination
        assertFalse(instance.canContinue());
    }

    public void testCanContinueNoWinNotDom() {
        addPlayersAndStart();

        // start capital game
        try {
            instance.startGame(2, 0, true, true);
        }
        catch(Exception ex) {
            fail();
        }
        instance.setCurrentPlayer(1);
        Player plyr = instance.getCurrentPlayer();

        // give player 1 country
        instance.getCountries()[0].setOwner(plyr);

        // player has not won so game state is not game over
        instance.checkPlayerWon();

        // Player can not continue because current game is not finished
        assertFalse(instance.canContinue());
    }
    private RiskGame game;
    private static final String CYAN_PLAYER_NAME = "cyan_player";
    private static final String GREEN_PLAYER_NAME = "green_player";
    private static final int DEFAULT_INITIAL_EXTRA_ARMIES = 40;
    private static final int TEST_WITH_EXTRA_ARMIES = 1;
    private static final int INITIAL_ARMIES_TO_REMOVE = DEFAULT_INITIAL_EXTRA_ARMIES - TEST_WITH_EXTRA_ARMIES;
    private Country country0; // Owned by the cyan player
    
    private Player cyanPlayer;
    private Player greenPlayer;
    public void capitalSetup() {

        try {
            RiskUIUtil.mapsdir = new File("./game/Domination/maps").toURI().toURL();
            game = new RiskGame();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        game.addPlayer(Player.PLAYER_HUMAN, CYAN_PLAYER_NAME, ColorUtil.CYAN, "address");
        game.addPlayer(Player.PLAYER_HUMAN, GREEN_PLAYER_NAME, ColorUtil.GREEN, "address");

        try {
            game.startGame(RiskGame.MODE_CAPITAL, RiskGame.CARD_INCREASING_SET, true, false);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        country0 = game.getCountries()[0];
        country1 = game.getCountries()[1];
        cyanPlayer = game.getPlayer(CYAN_PLAYER_NAME);
        greenPlayer = game.getPlayer(GREEN_PLAYER_NAME);

        cyanPlayer.loseExtraArmy(INITIAL_ARMIES_TO_REMOVE);
        greenPlayer.loseExtraArmy(INITIAL_ARMIES_TO_REMOVE);

        game.setCurrentPlayer(0);

        // Cyan player's turn
        game.placeArmy(country0, 1);
        game.endGo();

        game.setCurrentPlayer(1);
        // Green  player's turn
        game.placeArmy(country1, 1);
        game.endGo();

        // Cyan player's turn with 3 armies left to place
        game.placeArmy(country0, 1);
        game.placeArmy(country0, 1);
        game.placeArmy(country0, 1);
    }

    public void testCanContinueDomWinNotDom() {
        addPlayersAndStart();

        // start capital game
        try {
            instance.startGame(2, 0, true, true);
        }
        catch(Exception ex) {
            fail();
        }
        // Set up the player to win
        instance.setCurrentPlayer(1);
        Player plyr = instance.getCurrentPlayer();

        // Set up the play to own all the countries
        for(Country c : instance.getCountries()){
            c.setOwner(plyr);
        }

        instance.checkPlayerWon();

        // Player can not continue because they already have all countries
        assertFalse(instance.canContinue());
    }
//    public void testCheckPlayerWonCapital() {
//
//        // start capital game
//        capitalSetup();
//        // Set up the player to win
//        game.setCurrentPlayer(0);
//        assertTrue(game.setCapital(country0));
//        assertEquals(country0, game.getCurrentPlayer().getCapital());
//
//        game.endGo();
//        assertEquals(game.getState(), RiskGame.STATE_SELECT_CAPITAL);
//        game.setCapital(country1);
//        assertTrue(game.setCapital(country1));
//        assertEquals(country1, game.getCurrentPlayer().getCapital());
//
//        game.setCurrentPlayer(0);
//        country0.setOwner(game.getCurrentPlayer());
//        country1.setOwner(game.getCurrentPlayer());
//        game.getCurrentPlayer().newCountry(country0);
//        game.getCurrentPlayer().newCountry(country1);
//
//
//        // Player can continue because they won capital mode but dont own all countries
//        assertTrue(game.checkPlayerWon());
//    }

////    public void testCanContinueWinCapital() {
////
////
////        // start capital game
////        capitalSetup();
////        // Set up the player to win
////        game.setCurrentPlayer(0);
////        game.setCapital(country0);
////
////        game.setCurrentPlayer(1);
////        game.setCapital(country1);
////
////        game.setCurrentPlayer(0);
////        country0.setOwner(game.getCurrentPlayer());
////        country1.setOwner(game.getCurrentPlayer());
////        game.getCurrentPlayer().newCountry(country0);
////        game.getCurrentPlayer().newCountry(country1);
////
////        game.checkPlayerWon();
////        assertTrue(game.canContinue());
//
//    }
}
