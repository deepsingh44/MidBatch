package com.example.midbatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private EditText troll, tname, temail, tpass;
    private Spinner tcourse;
    private RadioGroup trg;
    private CheckBox tcondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.register);
        initViews();

    }

    private void initViews() {
        troll = findViewById(R.id.roll);
        tname = findViewById(R.id.name);
        temail = findViewById(R.id.email);
        tpass = findViewById(R.id.pass);
        tcourse = findViewById(R.id.course);
        trg = findViewById(R.id.bg);
        tcondition = findViewById(R.id.condition);
        RadioButton rrr = findViewById(R.id.r1);
        rrr.setChecked(true);
    }

    public void submit(View v) {
        if (valid()) {

        }
    }

    private String roll, name, email, gender, pass, condition, course;

    private boolean valid() {
        roll = troll.getText().toString();
        name = tname.getText().toString();
        email = temail.getText().toString();
        pass = tpass.getText().toString();
        course = tcourse.getSelectedItem().toString();
        RadioButton r = findViewById(trg.getCheckedRadioButtonId());
        gender = r.getText().toString();

        if (TextUtils.isEmpty(roll)) {
            Toast.makeText(this, "please enter roll", Toast.LENGTH_SHORT).show();
            troll.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show();
            tname.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            temail.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            tpass.requestFocus();
            return false;
        } else if (!password(pass)) {
            Toast.makeText(this, "password must have a small letter\n upper case\nlower case\n special character and \n length should be greater than 6", Toast.LENGTH_SHORT).show();
            tpass.requestFocus();
            return false;
        } else if (course.equalsIgnoreCase("select course")) {
            Toast.makeText(this, "please select course", Toast.LENGTH_SHORT).show();
            tcourse.requestFocus();
            return false;
        } else if (!tcondition.isChecked()) {
            Toast.makeText(this, "please accept terms and conditions.", Toast.LENGTH_SHORT).show();
            tcondition.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void reset(View v) {

    }

    private String passwordPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!?&()@$%#]).{6,15})";

    private boolean password(String pass) {
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

}
