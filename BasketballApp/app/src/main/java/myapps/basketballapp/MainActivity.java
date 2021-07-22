package myapps.basketballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import myapps.basketballapp.models.League;
import myapps.basketballapp.models.Player;

public class MainActivity extends AppCompatActivity {

    public static League league;
    ArrayAdapter adapter;
    ListView listView;
    Button addPlayerButton;
    Toast toast;
    EditText editText;
    ArrayList<String> playerNameArrayList;
    DatabaseReference leaguesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.playersList);
        addPlayerButton = findViewById(R.id.addPlayerButton);
        editText = findViewById(R.id.editTextPlayerName);

        league = new League("My League");
        Player dov = new Player("Dov");
        Player sam = new Player("Sam");
        Player aj = new Player("Aj");

        league.addPlayer(dov);
        league.addPlayer(sam);
        league.addPlayer(aj);

        leaguesDatabaseReference = FirebaseDatabase.getInstance().getReference("leagues");
        leaguesDatabaseReference.child(league.getLeagueName()).updateChildren(league.getPlayerHashMap());


        //populate list view
        playerNameArrayList = league.getPlayerNameArrayList();
        adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, playerNameArrayList);
        listView.setAdapter(adapter);

        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast for debugging
                toast = Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT);
                toast.show();

                String playerName = editText.getText().toString();

                league.addPlayer(new Player(playerName));
                leaguesDatabaseReference.child(league.getLeagueName()).updateChildren(league.getPlayerHashMap());
                playerNameArrayList.add(playerName); //need to add to arraylist to display in listview
                adapter.notifyDataSetChanged();

                editText.setText("");

                //come back and error check for if player already exists
                //also note firebase will crash app if empty text is submitted
            }
        });

        //remember to add the add a player button
    }



    public void onGoToStatLogClicked(View view) {
        //send to log a game page with league in a bundle
        Intent intent = new Intent(this, LogAStatActivity.class);

        startActivity(intent);
    }
}