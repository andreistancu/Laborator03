package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        final Button button0 = (Button) findViewById(R.id.button0);
        final EditText phoneNumber = (EditText) findViewById(R.id.editText);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button0.getText().toString();
                phoneNumber.setText(phoneNumber.getText().toString() + buttonText);
                phoneNumber.setSelection(phoneNumber.getText().length());
            }
        });

        final ImageButton callButton = (ImageButton) findViewById(R.id.call_button);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Phone Dialer Activity", "wrong number");
                try {
                    Intent dialIntent = new Intent(Intent.ACTION_CALL);
                    String number = phoneNumber.getText().toString();
                    dialIntent.setData(Uri.parse(number));
                    startActivity(dialIntent);
                } catch (ActivityNotFoundException ex) {
                    ex.printStackTrace();
                    Log.e("call failed", "wrong number", ex);
                }
            }
        });
    }
}
