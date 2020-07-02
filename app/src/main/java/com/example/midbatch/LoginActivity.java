package com.example.midbatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText temail, tpass;
    private String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        initViews();
    }

    private void initViews() {
        temail = findViewById(R.id.myemail);
        tpass = findViewById(R.id.mypassword);
    }

    public void submit(View view) {

        if (valid()) {
            Toast.makeText(this, email + "\t" + password, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean valid() {
        email = temail.getText().toString();
        password = tpass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            //Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            temail.setError("Please enter email id");
            temail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(password)) {
            //Toast.makeText(this, "Please enter roll", Toast.LENGTH_SHORT).show();
            tpass.setError("Please enter Password");
            tpass.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void goToRegister(View view){
        startActivity(new Intent(this,RegisterActivity.class));
        finish();
    }
}
