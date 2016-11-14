package net.yura.domination.engine.core;

import java.io.File;
import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;
import net.yura.domination.engine.RiskUIUtil;

/**
 * Test case for RiskGame tests in a scenario with 2 human players.
 *
 * In setUp(), a RiskGame is started with two players, a cyan and a green player
 * playing in MODE_DOMINATION, with the CARD_INCREASING_SET card option, and
 * with recycle cards and the 3 dice options off (see the options for the
 * RiskGame constructor).
 *
 * Cyan starts with 4 armies on country0 and Green starts with 1 army on
 * country1. All other countries have no armies. At the start of each test, it
 * is Cyan's turn to attack (RiskGame is in the STATE_ATTACKING state).
 */
public class RiskGame2PlayerTest extends TestCase {

    private RiskGame game;
    private static final String CYAN_PLAYER_NAME = "cyan_player";
    private static final String GREEN_PLAYER_NAME = "green_player";
    private static final int DEFAULT_INITIAL_EXTRA_ARMIES = 40;
    private static final int TEST_WITH_EXTRA_ARMIES = 1;
    private static final int INITIAL_ARMIES_TO_REMOVE = DEFAULT_INITIAL_EXTRA_ARMIES - TEST_WITH_EXTRA_ARMIES;
    private Country country0; // Owned by the cyan player
    private Country country1; // Owned by the green player
    private Player cyanPlayer;
    private Player greenPlayer;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        try {
            RiskUIUtil.mapsdir = new File("./game/Domination/maps").toURI().toURL();
            game = new RiskGame();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        game.addPlayer(Player.PLAYER_HUMAN, CYAN_PLAYER_NAME, ColorUtil.CYAN, "address");
        game.addPlayer(Player.PLAYER_HUMAN, GREEN_PLAYER_NAME, ColorUtil.GREEN, "address");

        try {
            game.startGame(RiskGame.MODE_DOMINATION, RiskGame.CARD_INCREASING_SET, true, false);
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

        // Green  player's turn
        game.placeArmy(country1, 1);
        game.endGo();

        // Cyan player's turn with 3 armies left to place
        game.placeArmy(country0, 1);
        game.placeArmy(country0, 1);
        game.placeArmy(country0, 1);
    }

    public void testSetup() {
        assertEquals(cyanPlayer, game.getCurrentPlayer());
        assertEquals(RiskGame.STATE_ATTACKING, game.getState());
        assertEquals(4, country0.getArmies());
        assertEquals(1, country1.getArmies());
    }

    public void testSuccessfulAttack() {
        assertTrue(game.attack(country0, country1));
        assertEquals(RiskGame.STATE_ROLLING, game.getState());
        assertEquals(country0, game.getAttacker());
        assertEquals(country1, game.getDefender());
    }

    public void testAttackWithOpponentCountry() {
        assertFalse(game.attack(country1, country0));
        assertEquals(RiskGame.STATE_ATTACKING, game.getState());
    }

    public void testRollAWhenNotAttacking() {
        assertFalse(game.rollA(3));
    }

    public void testRollA() {
        game.attack(country0, country1);
        assertTrue(game.rollA(3));
        assertEquals(3, game.getAttackerDice());
        assertEquals(RiskGame.STATE_DEFEND_YOURSELF, game.getState());
    }

    public void testBattle() {
        game.attack(country0, country1);

        game.rollA(3);
        game.rollD(1);
        int[] attackerRoll = new int[]{6, 6, 6};
        int[] defenderRoll = new int[]{1};

        int[] battleResults = game.battle(attackerRoll, defenderRoll);
        assertEquals("RiskGame.battle(int[], int[]) failed", 1, battleResults[0]);

        assertEquals("Incorrect number of attacker armies lost", 0, battleResults[1]);
        assertEquals("Incorrect number of defender armies lost", 1, battleResults[2]);
        assertTrue("The battle results incorrectly indicates that the attacker lost.", battleResults[3] != 0);
        assertEquals("The battle results incorrectly indicates that the attacker did not eliminate the other player.", 2, battleResults[3]);
        assertEquals("Incorrect minimum movement of armies into captured country.", 3, battleResults[4]);
        assertEquals("Incorrect maximum movement of armies into captured country.", 3, battleResults[5]);
    }

}
