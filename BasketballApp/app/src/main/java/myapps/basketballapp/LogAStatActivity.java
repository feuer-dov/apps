package myapps.basketballapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.basketballapp.models.League;

public class LogAStatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_a_stat);

    }


    public void onStatButtonClicked(View view) {
        Button button = (Button) view;
        String stat = button.getText().toString();

        Log.d("Tag", stat);
        Intent intent = new Intent(this, SelectPlayerActivity.class);
        intent.putExtra("stat", stat);

        startActivity(intent);
    }
}