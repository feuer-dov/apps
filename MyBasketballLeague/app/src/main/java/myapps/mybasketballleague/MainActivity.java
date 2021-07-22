package myapps.mybasketballleague;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import myapps.mybasketballleague.models.League;
import myapps.mybasketballleague.models.Player;
import myapps.mybasketballleague.models.Team;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogAGameClick(View view){
        Intent intent = new Intent(this, LogAGame.class);
        startActivity(intent);
    }

    public void onEditTeamsClick(View view) {
    }
}