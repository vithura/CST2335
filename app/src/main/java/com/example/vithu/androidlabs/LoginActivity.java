package com.example.vithu.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {


    protected static final String ACTIVITY_NAME ="LoginActivity";
    private Button button;
    private EditText loginEditText;
    private SharedPreferences sharedPref;
    private static final String DEFAULT_EMAIL_KEY = "DEFULT_EMAIL_KEY";
    private static final String MY_PREF = "MY_PREF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEditText = findViewById(R.id.editText);
        sharedPref = getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        String defaultEmail = sharedPref.getString(DEFAULT_EMAIL_KEY, "email@domain.com");


        loginEditText.setText(defaultEmail);

        button = (Button)findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = loginEditText.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("DefaultMail", email);
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }
    public void callback(){

    }
    protected void OnResume(Bundle savedInstance){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    protected void onStart(Bundle savedInstance) {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause(Bundle savedInstance) {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop(Bundle savedInstance) {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    protected void onDestroy(Bundle savedInstance) {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
