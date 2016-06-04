package com.example.user.myapp4.kaup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp4.R;

public class KaupActivity extends Activity implements View.OnClickListener{
    EditText etName,etWeight,etHeight;
    TextView resultCalc;
    String name,result;
    Button btnCalc;
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
}

    @Override
    public void onClick(View v) {
        name = etName.getText().toString();
        resultCalc = (TextView) findViewById(R.id.resultCalc);
        weight = Double.parseDouble(etWeight.getText().toString());
        height = Double.parseDouble(etHeight.getText().toString());

        KaupService service = new KaupServiceImpl();

        result = service.getKaup(weight, height);
        resultCalc.setText(name + "님의 계산결과: " + result);

    }
}
