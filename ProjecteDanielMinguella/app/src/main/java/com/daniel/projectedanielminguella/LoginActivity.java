package com.daniel.projectedanielminguella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText et_email, et_password;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
    }


    public void login (View view) {

        if (checkFields(et_email.getText().toString(), et_password.getText().toString())) {
            SharedPreferences preferences = getSharedPreferences("myPreferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user", et_email.getText().toString());
            editor.commit();
            finish();
        }

    }

    private boolean checkFields(String email, String password) {
        boolean valid = true;
        if ("".equals(email)) {
            et_email.setError("Email no pot quedar buit");
            valid = false;
        }
        if ("".equals(password)) {
            et_password.setError("Password no pot quedar buit");
            valid = false;
        }
        return valid;
    }

    public void goTo(View view) {
        String text = "https://www.abc.es/play/cine/peliculas/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(text));
        startActivity(intent);
    }
}
