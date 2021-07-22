package myapps.basketballapp;

import org.junit.Test;

import java.util.ArrayList;

import myapps.basketballapp.models.League;
import myapps.basketballapp.models.Player;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void leagueCreation() {
        League league = new League("MyLeague");
        Player dov = new Player("Dov");
        Player sam = new Player("Sam");
        Player aj = new Player("Aj");

        league.addPlayer(dov);
        league.addPlayer(sam);
        league.addPlayer(aj);

        Player dovCheck = league.getPlayer("Dov");
        ArrayList<Object> playerArrayList = league.getPlayerArrayList();
        assertEquals(dov, playerArrayList.get(1));
        assertEquals(dov, dovCheck);
    }
}