package com.agneshandayani.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonLogin;
    Button buttonRegister;
    Button buttonMain;

    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqliteHelper = new SqliteHelper(this);
        initViews();

        buttonLogin.setOnClickListener(view -> {

            if (validate()) {

                String Email = editTextEmail.getText().toString();
                String Password = editTextPassword.getText().toString();

                User currentUser = sqliteHelper.Authenticate(new User(null, null, Email, Password));

                if (currentUser != null) {
                    Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();

                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {

                    Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                }
            }
        });

        buttonRegister= findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(i);
        });

        buttonMain= findViewById(R.id.buttonMain);
        buttonMain.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });

    }

    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    public boolean validate() {
        boolean valid = false;
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();
        return valid;
    }
}