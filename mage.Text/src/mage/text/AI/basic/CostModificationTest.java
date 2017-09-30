package mage.text.AI.basic;

import mage.constants.Zone;
import mage.game.GameException;
import mage.text.serverside.serverside.base.CardTestPlayerBaseAI;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LevelX2
 */
public class CostModificationTest extends CardTestPlayerBaseAI {
    
    /**
     * There seems to be a problem when playing Fluctuator against Computer.
     * Once played, I am stuck at "Waiting for Computer" forever...
     */
    @Test
    @Ignore
    // TODO: Check why sometimes Silvercoat Lion is not cast from AI
    public void testFluctuator() throws GameException {
        try {
            reset();
        } catch (FileNotFoundException ex) {

            Logger.getLogger(CostModificationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        currentGame.setStartingPlayerId(playerA.getId());
        currentGame.setSimulation(true);
        
        
       
        String[] graveyard = {
            "Sunbond",
            "Swamp",
            "Chrome Mox"
        };
        
        String[] library = {
            "Sunbond", 
            "Swamp",
            "Chrome Mox"
        };


        String[] hand = {
                "Sunbond",
                "Swamp",
                "Chrome Mox"
        };

        String[] battlefield = {
                "Sunbond",
                "Swamp",
                "Chrome Mox"
        };

        addCard(Zone.BATTLEFIELD);

        Arrays.stream(hand).forEach(name -> addCard(Zone.HAND, playerA, name));
        Arrays.stream(library).forEach(name -> addCard(Zone.HAND, playerA, name));
        Arrays.stream(graveyard).forEach(name -> addCard(Zone.HAND, playerA, name));

        boolean go = true;
        currentGame.getWinner();
        while (go) {
            boolean priorityA;
            priorityA = playerA.priority(currentGame);
            Logger.getLogger("SIMILATION").log(Level.FINER, "P: %s", priorityA);
            
            boolean priorityB;
            priorityB = playerB.priority(currentGame);
            Logger.getLogger("SIMILATION").log(Level.FINER, "P: %s", priorityA);
            
            
        }
    }
}