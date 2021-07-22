package myapps.shoppinglist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;
    public TextView textView7;
    public TextView textView8;
    public TextView textView9;
    public TextView textView10;
    public ArrayList<TextView> textViews;
    public int index;

    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = 0;

        textView1 = findViewById(R.id.text_view_1);
        textView2 = findViewById(R.id.text_view_2);
        textView3 = findViewById(R.id.text_view_3);
        textView4 = findViewById(R.id.text_view_4);
        textView5 = findViewById(R.id.text_view_5);
        textView6 = findViewById(R.id.text_view_6);
        textView7 = findViewById(R.id.text_view_7);
        textView8 = findViewById(R.id.text_view_8);
        textView9 = findViewById(R.id.text_view_9);
        textView10 = findViewById(R.id.text_view_10);

        textViews = new ArrayList<>();

        textViews.add(textView1);
        textViews.add(textView2);
        textViews.add(textView3);
        textViews.add(textView4);
        textViews.add(textView5);
        textViews.add(textView6);
        textViews.add(textView7);
        textViews.add(textView8);
        textViews.add(textView9);
        textViews.add(textView10);
    }

    public void onAddItemClick(View view){
        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(requestCode == RESULT_OK){
                if(index <= 9){
                    String itemName = data.getStringExtra("item_name");
                    TextView textView = textViews.get(index);
                    textView.setText(itemName);
                    index++;
                }
            }
        }
    }
}