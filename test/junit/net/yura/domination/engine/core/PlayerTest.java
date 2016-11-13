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
        Player player = createTestPlayer();
        assertEquals(0, player.getNoArmies());

        Country country1 = new Country();
        player.newCountry(country1);
        country1.addArmies(4);
        assertEquals(4, player.getNoArmies());

        Country country2 = new Country();
        player.newCountry(country2);
        country2.addArmies(5);
        assertEquals(9, player.getNoArmies());

        player.lostCountry(country2);
        assertEquals(4, player.getNoArmies());
    }

    public void testManipulateExtraArmies() {
        System.out.println("ManipulateExtraArmies");
        Player player = createTestPlayer();
        assertEquals(0, player.getExtraArmies());
        player.addArmies(20);
        assertEquals(20, player.getExtraArmies());
        player.loseExtraArmy(3);
        assertEquals(17, player.getExtraArmies());
    }

    public void testTakeCard() {
        System.out.println("takeCard");
        Player player = createTestPlayer();

        assertEquals(0, player.getCards().size());

        Country country = new Country();
        Card card1 = new Card(Card.CANNON, country);
        Card card2 = new Card(Card.INFANTRY, country);
        player.giveCard(card1);

        assertEquals(card1, player.takeCard());
        assertEquals(0, player.getCards().size());

        player.giveCard(card1);
        player.giveCard(card2);

        assertEquals(card1, player.takeCard());
        assertEquals(1, player.getCards().size());
        assertEquals(card2, player.getCards().get(0));
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

        Card card4 = new Card(Card.WILDCARD, country4);

        player.giveCard(card4);
        player.giveCard(card2);
        player.giveCard(card3);

        player.tradeInCards(card4, card2, card3);

        assertEquals(Player.noaFORcard, country1.getArmies());
        assertEquals(Player.noaFORcard, country2.getArmies());
        assertEquals(0, country3.getArmies());
        assertEquals(0, country4.getArmies());

        assertEquals(0, player.getCards().size());

        Country country5 = new Country();
        Card card5 = new Card(Card.INFANTRY, country5);

        player.giveCard(card4);
        player.giveCard(card5);
        player.giveCard(card3);

        player.tradeInCards(card4, card5, card3);

        assertEquals(Player.noaFORcard, country1.getArmies());
        assertEquals(Player.noaFORcard, country2.getArmies());
        assertEquals(Player.noaFORcard, country3.getArmies());
        assertEquals(0, country4.getArmies());
        assertEquals(0, country5.getArmies());

        assertEquals(0, player.getCards().size());

        Country country6 = new Country();
        Card card6 = new Card(Card.WILDCARD, country6);

        player.giveCard(card4);
        player.giveCard(card5);
        player.giveCard(card6);

        player.tradeInCards(card4, card5, card6);

        assertEquals(0, country4.getArmies());
        assertEquals(0, country5.getArmies());
        assertEquals(0, country6.getArmies());

        assertEquals(0, player.getCards().size());
    }

    public void testManipulateCountries() {
        System.out.println("ManipulateCountries");
        Player player = createTestPlayer();
        assertEquals(0, player.getNoTerritoriesOwned());

        Country country1 = new Country();
        player.newCountry(country1);
        assertEquals(1, player.getNoTerritoriesOwned());

        Country country2 = new Country();
        player.newCountry(country2);
        assertEquals(2, player.getNoTerritoriesOwned());

        player.lostCountry(country1);
        assertEquals(1, player.getNoTerritoriesOwned());

        assertEquals(country2, player.getTerritoriesOwned().get(0));
    }

    public void testIsAlive() {
        System.out.println("isAlive");

        Player player = createTestPlayer();
        assertFalse(player.isAlive());

        Country country1 = new Country();
        player.newCountry(country1);
        assertTrue(player.isAlive());

        player.addArmies(2);
        assertTrue(player.isAlive());

        player.lostCountry(country1);
        assertTrue(player.isAlive());

        player.loseExtraArmy(2);
        assertFalse(player.isAlive());
    }

}
