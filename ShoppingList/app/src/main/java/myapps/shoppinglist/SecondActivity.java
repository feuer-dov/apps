package myapps.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View view){
        String itemName = ((Button) view).getText().toString();
        Intent intent = new Intent();
        intent.putExtra("item_name", itemName);
        setResult(RESULT_OK, intent);
        finish();
    }
}