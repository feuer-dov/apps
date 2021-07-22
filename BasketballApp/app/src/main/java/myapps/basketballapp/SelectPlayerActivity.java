package myapps.basketballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import myapps.basketballapp.models.League;
import myapps.basketballapp.models.Player;

public class SelectPlayerActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    String stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);

        listView = findViewById(R.id.playersList);

        Intent intent = getIntent();

        stat = intent.getStringExtra("stat");

        ArrayList<String> playerNameArrayList = MainActivity.league.getPlayerNameArrayList();


        adapter = new ArrayAdapter(SelectPlayerActivity.this, R.layout.support_simple_spinner_dropdown_item, playerNameArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPlayerName = adapter.getItem(position).toString();
                Player player = MainActivity.league.getPlayer(selectedPlayerName);
                //note that a change to the player will update the player in the league's hashmap

                applyStat(player, stat);
                updateDatabase(player);
                finish();
            }
        });

    }

    private void applyStat(Player player, String stat) {
        if(stat.equals("+1 Point")){
            player.addPoints(1);
        }
        else if(stat.equals("+2 Points")){
            player.addPoints(2);
        }
        else if(stat.equals("Assist")){
            player.addAssist();
        }
        else if(stat.equals("Rebound")){
            player.addRebound();
        }
        else if(stat.equals("Shot Missed")){
            player.addShotMissed();
        }
        else if(stat.equals("Turnover")){
            player.addTurnover();
        }

    }

    private void updateDatabase(Player player) {
        DatabaseReference playerReference = FirebaseDatabase.getInstance().getReference("leagues");
        HashMap<String, Object> mapForAddingPlayer = new HashMap<>();
        mapForAddingPlayer.put(player.getName(), player);
        playerReference.child(MainActivity.league.getLeagueName()).updateChildren(mapForAddingPlayer);
    }
}