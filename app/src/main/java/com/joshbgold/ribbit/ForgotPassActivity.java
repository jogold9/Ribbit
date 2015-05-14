package com.joshbgold.ribbit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;


public class ForgotPassActivity extends Activity {

    protected EditText mEmailText;
    protected Button mSubmitButton;
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        mEmailText = (EditText)findViewById(R.id.emailText);
        mSubmitButton = (Button)findViewById(R.id.submitButton);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmailText.getText().toString();
                if ((email != null) && (email != "")){
                    ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
                        @Override
                        public void done(com.parse.ParseException e) {
                            if (e == null) {
                                Toast.makeText(getApplicationContext(), "An email was successfully sent with reset instructions.", Toast
                                        .LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Something went wrong. Please enter a valid email address.  If needed, look" +
                                        " at the ParseException to see what's up.", Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please enter a valid email address.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forgot_pass, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
