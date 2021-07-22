package myapps.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
    }

    public void openWebsite(View view) {
        //fetch string url from the edittext
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url); //parse to Uri

        //Implicit intent with (action, data for action); ACTION_VIEW is the action of putting
        //something in view, and the webpage is what will be shown
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //if the device is able to handle the action, start activity.
        //note the intent already has the "knowledge" that it will open a webpage
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't handle this");
        }
    }
}