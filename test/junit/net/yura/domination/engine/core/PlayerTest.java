package net.yura.domination.engine.core;

import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;

public class PlayerTest extends TestCase {

    public PlayerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private static Player createTestPlayer() {
        return new Player(Player.PLAYER_HUMAN, "Bob", ColorUtil.BLACK, "address");
    }

    public void testNextTurn() {
        System.out.println("nextTurn");
        Player player = createTestPlayer();
        assertEquals(1, player.getStatistics().size());
        player.nextTurn();
        assertEquals(2, player.getStatistics().size());
        Statistic stat = player.getStatistics().get(1);
        player.nextTurn();
        assertEquals(3, player.getStatistics().size());
        assertEquals(stat, player.getStatistics().get(1));

    }

    public void testGetStatistics_StatType() {
        System.out.println("getStatistics");

        Player player = createTestPlayer();
        for (StatType type : StatType.values()) {
            double[] stats = player.getStatistics(type);

            assertEquals(1, stats.length);

            for (Double stat : stats) {
                assertTrue(stat >= 0);
            }
        }

        player.nextTurn();
        player.nextTurn();

        for (StatType type : StatType.values()) {
            double[] stats = player.getStatistics(type);

            assertEquals(3, stats.length);

            for (Double stat : stats) {
                assertTrue(stat >= 0);
            }
        }
    }

    public void testGetNoArmies() {
        System.out.println("getNoArmies");
        // player.getNoArmies();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testAddArmies() {
        System.out.println("addArmies");
        // player.addArmies(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testLoseExtraArmy() {
        System.out.println("loseExtraArmy");
        // player.loseExtraArmy(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testGiveCard() {
        System.out.println("giveCard");
        // player.giveCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testTakeCard() {
        System.out.println("takeCard");
        // player.takeCard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testTradeInCards() {
        System.out.println("tradeInCards");
        Player player = new Player(Player.PLAYER_HUMAN, "Bob", ColorUtil.BLACK, "address");

        Country country1 = new Country();
        Country country2 = new Country();
        Country country3 = new Country();
        Country country4 = new Country();

        player.newCountry(country1);
        player.newCountry(country2);
        player.newCountry(country3);
        player.newCountry(country4);

        Card card1 = new Card(Card.CAVALRY, country1);
        Card card2 = new Card(Card.CANNON, country2);
        Card card3 = new Card(Card.WILDCARD, country3);

        player.giveCard(card1);
        player.giveCard(card2);
        player.giveCard(card3);

        player.tradeInCards(card1, card2, card3);

        assertEquals(Player.noaFORcard, country1.getArmies());
        assertEquals(0, country2.getArmies());
        assertEquals(0, country3.getArmies());
        assertEquals(0, country4.getArmies());

        assertEquals(0, player.getCards().size());
    }

    public void testGetNoTerritoriesOwned() {
        System.out.println("getNoTerritoriesOwned");
        // player.getNoTerritoriesOwned();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testNewCountry() {
        System.out.println("newCountry");
        // player.newCountry(newCountry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testLostCountry() {
        System.out.println("lostCountry");
        // player.lostCountry(lessCountry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testAddPlayersEliminated() {
        System.out.println("addPlayersEliminated");
        // player.addPlayersEliminated(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testIsAlive() {
        System.out.println("isAlive");
        // player.isAlive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
