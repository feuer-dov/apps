package myapps.mybasketballleague;

import org.junit.Test;

import java.util.ArrayList;

import  myapps.mybasketballleague.models.*;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testTemplate(){

    }

    @Test
    public void testDefaultValues(){
        Player siakam = new Player("Pascal Siakam");
        int totalShots = siakam.getTotalShots();
        int madeShots = siakam.getMadeShots();
        int turnovers = siakam.getTurnovers();
        int assists = siakam.getAssists();
        String name = siakam.getName();
        assertEquals(0, siakam.getTotalShots());
    }

    @Test
    public void Test_01(){
        Player lowry = new Player("Kyle Lowry");
        lowry.assistMade();
        lowry.assistMade();
        lowry.twoPtShotMade();
        lowry.twoPtShotMade();
        lowry.twoPtShotMissed();
        lowry.twoPtShotMade();
        lowry.twoPtShotMade();

        assertEquals(5, lowry.getTotalShots());
        assertEquals(2, lowry.getAssists());
        assertEquals(4, lowry.getMadeShots());
        assertEquals(8, lowry.getPoints());
    }

    @Test
    public void Test_02(){
        Player lowry = new Player("Kyle Lowry");
        Player siakam = new Player("Pascal Siakam");
        Player fredVanVleet = new Player("Fred Van Vleet");
        Player boucher = new Player("Chris Boucher");

        Team raptors = new Team("Toronto Raptors");
        raptors.addPlayer(lowry);
        raptors.addPlayer(siakam);
        raptors.addPlayer(fredVanVleet);
        raptors.addPlayer(boucher);

        assertEquals(boucher, raptors.getTeam().get(3));

    }

    @Test
    public void Test_03(){
        Player lowry = new Player("Kyle Lowry");
        Player siakam = new Player("Pascal Siakam");
        Player fredVanVleet = new Player("Fred Van Vleet");
        Player boucher = new Player("Chris Boucher");

        Team raptors = new Team("Toronto Raptors");
        raptors.addPlayer(lowry);
        raptors.addPlayer(siakam);
        raptors.addPlayer(fredVanVleet);
        raptors.addPlayer(boucher);

        assertEquals(boucher, raptors.getTeam().get(3));
    }

    @Test
    public void Test_04_Stats(){
        Player lowry = new Player("Kyle Lowry");
        lowry.gamePlayed();
        lowry.twoPtShotMade();
        lowry.twoPtShotMade();
        lowry.twoPtShotMade();
        lowry.twoPtShotMade();
        lowry.gamePlayed();
        lowry.twoPtShotMade();

        //should be 5.0 ppg, and 100.0 fg%

        assertEquals(5.0, lowry.getPPG(), 0.1);
        assertEquals(100.0, lowry.getFgPercentage(), 0.1);
    }

    @Test
    public void ppgTest(){
        Player lowry = new Player("Kyle Lowry");
        Player siakam = new Player("Pascal Siakam");
        Player fredVanVleet = new Player("Fred Van Vleet");
        Player boucher = new Player("Chris Boucher");

        Team raptors = new Team("Toronto Raptors");
        raptors.addPlayer(lowry);
        raptors.addPlayer(siakam);
        raptors.addPlayer(fredVanVleet);
        raptors.addPlayer(boucher);

        Player curry = new Player("Steph Curry");
        Player wiggins = new Player("Andrew Wiggins");
        Player oubre = new Player("Kelly Oubre");
        Player looney = new Player("Kevon Looney");

        Team warriors = new Team("Warriors");
        warriors.addPlayer(curry);
        warriors.addPlayer(wiggins);
        warriors.addPlayer(oubre);
        warriors.addPlayer(looney);

        League nba = new League("NBA");
        nba.addTeam(raptors);
        nba.addTeam(warriors);

        int points = 5;
        for(Team team: nba.getTeams()){
            for (Player player : team.getTeam()) {
                player.setPoints(points);
                player.setGamesPlayed(2);
                points += 5;
            }
        } // this should have Looney with the most ppg and lowry with the least (2.5)

        ArrayList<Player> ppgList = nba.getPPGSorted();

        assertEquals(looney, ppgList.get(0));
        assertEquals(lowry.getPPG(), 2.5, 0.1);
        assertEquals(lowry, ppgList.get(ppgList.size()-1));
    }
}