package com.example.user.myapp4.singup;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapp4.R;

public class SingupActivity extends Activity implements View.OnClickListener{
    EditText etID, etPWD, etNAME, etMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        etID = (EditText) findViewById(R.id.etID);
        etPWD = (EditText) findViewById(R.id.etPWD);
        etNAME = (EditText) findViewById(R.id.etNAME);
        etMail = (EditText) findViewById(R.id.etMail);
        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
