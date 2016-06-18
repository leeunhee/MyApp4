package com.example.user.myapp4.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapp4.R;
import com.example.user.myapp4.calc.CalcActivity;
import com.example.user.myapp4.group.GroupActivity;
import com.example.user.myapp4.kaup.KaupActivity;
import com.example.user.myapp4.login.Login2Activity;
import com.example.user.myapp4.signup.SignupActivity;

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
        ((Button) findViewById(R.id.btSingup)).setOnClickListener(this); // 20160611
        ((Button) findViewById(R.id.btGroup)).setOnClickListener(this); // 20160618
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
                startActivity(new Intent(this, Login2Activity.class));
                break;
            case R.id.btSingup: // 20160611
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.btGroup: // 20160618
                startActivity(new Intent(this, GroupActivity.class));
                break;
        }
    }

}
