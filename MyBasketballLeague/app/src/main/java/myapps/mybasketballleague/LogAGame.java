package myapps.mybasketballleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import myapps.mybasketballleague.models.Game;
import myapps.mybasketballleague.models.League;
import myapps.mybasketballleague.models.Player;
import myapps.mybasketballleague.models.Team;

public class LogAGame extends AppCompatActivity {

    private League testLeague;
    private Team raptors;
    private Team warriors;
    public static Game game;
    public Team homeTeam;
    public Team awayTeam;

    public static final String HOME_TEAM = "home_team";
    public static final String AWAY_TEAM = "away_team";

    TextView homeScoreTextView;
    TextView awayScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_a_game);
        testLeague = new League("NBA");

        Player lowry = new Player("Kyle Lowry");
        Player siakam = new Player("Pascal Siakam");
        Player fredVanVleet = new Player("Fred Van Vleet");
        Player boucher = new Player("Chris Boucher");
        Player trent = new Player("Gary Trent");

        raptors = new Team("Raptors");
        raptors.addPlayer(lowry);
        raptors.addPlayer(trent);
        raptors.addPlayer(siakam);
        raptors.addPlayer(fredVanVleet);
        raptors.addPlayer(boucher);

        Player curry = new Player("Steph Curry");
        Player wiggins = new Player("Andrew Wiggins");
        Player oubre = new Player("Kelly Oubre");
        Player looney = new Player("Kevon Looney");
        Player draymond = new Player("Draymond Green");

        warriors = new Team("Warriors");
        warriors.addPlayer(curry);
        warriors.addPlayer(wiggins);
        warriors.addPlayer(oubre);
        warriors.addPlayer(looney);
        warriors.addPlayer(draymond);
        //note this entire league is a test league

        testLeague.addTeam(raptors);
        testLeague.addTeam(warriors);

        game = new Game(warriors, raptors);

        game.setPg(curry);
        game.setSg(wiggins);
        game.setSf(oubre);
        game.setPf(draymond);
        game.setC(looney);

        //note that the method knows which team each player is on since every player has a team
        game.setPg(lowry);
        game.setSg(fredVanVleet);
        game.setSf(trent);
        game.setPf(siakam);
        game.setC(boucher);


        //under here stays
        homeTeam = game.getHomeTeam();
        awayTeam = game.getAwayTeam();


        homeScoreTextView = findViewById(R.id.home_team_score);
        awayScoreTextView = findViewById(R.id.away_team_score);
    }

    public void onShotMadeHomeClicked(View view) {
        onShotMade(homeTeam);
    }

    public void onShotMadeAwayClicked(View view) {
        onShotMade(awayTeam);
    }

    public void onShotMade(Team team){

    }

    public void onTurnoverClickHome(View view) {
        onTurnover(HOME_TEAM);
    }

    public void onTurnoverClickAway(View view) {
        onTurnover(AWAY_TEAM);
    }

    public void onTurnover(String teamStatus){
        Intent turnoverIntent = new Intent(this, PlayerSelection.class);
        turnoverIntent.putExtra("team_status", teamStatus);
        startActivity(turnoverIntent);
    }

    private void setScore(){
        homeScoreTextView.setText(game.getHomeScore());
    }
}