package com.example.user.myapp4.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.user.myapp4.R;
import com.example.user.myapp4.calc.CalcActivity;
import com.example.user.myapp4.kaup.KaupActivity;
import com.example.user.myapp4.login.LoginActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btKaup, btCalc, btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btKaup = (Button) findViewById(R.id.btKaup);
//        btCalc = (Button) findViewById(R.id.btCalc);
//        btLogin = (Button) findViewById(R.id.btLogin);

//        btKaup.setOnClickListener(this);
//        btCalc.setOnClickListener(this);
//        btLogin.setOnClickListener(this);

        ((Button) findViewById(R.id.btKaup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btCalc)).setOnClickListener(this);
        ((Button) findViewById(R.id.btLogin)).setOnClickListener(this);
        ((Button) findViewById(R.id.btSingup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btKaup:
//                Intent intent = new Intent(this, KaupActivity.class);
//                startActivity(intent);
                startActivity(new Intent(this, KaupActivity.class)); // 위 두 줄을 한 줄로 함
                break;
            case R.id.btCalc:
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btSingup:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

}
