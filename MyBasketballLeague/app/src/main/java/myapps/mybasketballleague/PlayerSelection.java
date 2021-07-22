package myapps.mybasketballleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import myapps.mybasketballleague.models.Game;

public class PlayerSelection extends AppCompatActivity {

    Button pgButton;
    Button sgButton;
    Button sfButton;
    Button pfButton;
    Button cButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("player_selection", "onCreate started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);
        pgButton = findViewById(R.id.pg_button);
        sgButton = findViewById(R.id.sg_button);
        sfButton = findViewById(R.id.sf_button);
        pfButton = findViewById(R.id.pf_button);
        cButton = findViewById(R.id.c_button);

        Intent intent = getIntent();
        Game game = LogAGame.game;
        String teamStatus = intent.getStringExtra("team_status");

        if(teamStatus.equals(LogAGame.HOME_TEAM)){
            pgButton.setText(game.getPgHome().name);
            sgButton.setText(game.getSgHome().name);
            sfButton.setText(game.getSfHome().name);
            pfButton.setText(game.getPfHome().name);
            cButton.setText(game.getcHome().name);
        } else {
            pgButton.setText(game.getPgAway().name);
            sgButton.setText(game.getSgAway().name);
            sfButton.setText(game.getSfAway().name);
            pfButton.setText(game.getPfAway().name);
            cButton.setText(game.getcAway().name);
        }
        Log.d("player_sel_finished", "onCreate finished");
    }


}