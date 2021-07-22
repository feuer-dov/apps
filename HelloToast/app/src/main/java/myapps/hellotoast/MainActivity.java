package myapps.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int count;
    private Button zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.show_count);
        zeroButton = (Button) findViewById(R.id.zero_button);
        count = 0;
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        count++;
        textView.setText(Integer.toString(count));
        zeroButton.setBackgroundColor(1);
        if(count % 2 == 0){
            view.setBackgroundColor(1);
        }
        else{
            view.setBackgroundColor(0);
        }
    }

    public void zeroAction(View view) {
        count = 0;
        textView.setText(Integer.toString(count));

    }
}