/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.mage.text.serverside.serverside;

import mage.text.serverside.serverside.TestPlayRandomGame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shannah3
 */
public class TestPlayRandomGameTest {
    
    public TestPlayRandomGameTest() {
    }
    
    @Before
    public void setUp() {
        TestPlayRandomGame instance = new TestPlayRandomGame();
        
        instance.init();
    }

    @Test
    public void testPlayGames() throws Exception {
        System.out.println("playGames");
        TestPlayRandomGame instance = new TestPlayRandomGame();
        instance.playGames();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
