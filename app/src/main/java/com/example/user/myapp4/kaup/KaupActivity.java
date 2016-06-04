package com.example.user.myapp4.kaup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp4.R;
import com.example.user.myapp4.main.MainActivity;

public class KaupActivity extends Activity implements View.OnClickListener{
    EditText etName,etWeight,etHeight;
    TextView resultCalc;
    String name,result;
    Button btnCalc, returnMain;
    //    double weight,height;
    double  weight,height;
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaup);

        etName = (EditText) findViewById(R.id.name);
        etWeight = (EditText) findViewById(R.id.weight);
        etHeight = (EditText) findViewById(R.id.height);
        btnCalc = (Button) findViewById(R.id.btnCalc);
//        weight = Double.parseDouble(etWeight.getText().toString());
//        height = Double.parseDouble(etHeight.getText().toString());
        btnCalc.setOnClickListener(this);
//        returnMain.setOnClickListener(this);
        ((Button)findViewById(R.id.returnMain)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalc:
            Toast tMsg = Toast.makeText(KaupActivity.this,"토스트연습", Toast.LENGTH_SHORT);
            tMsg.show(); // 화면에 찍어보기
            name = etName.getText().toString();
            resultCalc = (TextView) findViewById(R.id.resultCalc);
            weight = Double.parseDouble(etWeight.getText().toString());
            height = Double.parseDouble(etHeight.getText().toString());

            KaupService service = new KaupServiceImpl();

            result = service.getKaup(weight, height);
            Log.d(result, "카우프지수"); // log 보기
            resultCalc.setText(name + "님의 계산결과: " + result);
            break;

            case R.id.returnMain:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }


    }
}
