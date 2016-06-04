package com.example.user.myapp4.calc;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp4.R;

public class CalcActivity extends Activity implements  View.OnClickListener {
//    Button btPlus, btMinus, btMuti, btDevide, btMod;
    EditText etNum1, etNum2;
    TextView Resultvalue1;
    String resS1;
    int num1, num2;
    int res1, res2, res3, res4, res5;
//    CalcService service = new CalcServiceImpl(); // Oncreate 나 OnClick에 모두 인식되도록 그런데 아래 줄처럼 한다
    CalcService service ;
    //     인스턴스 변수는 초기화 안한다. 필요에 따라 인스턴스 변수 초기화하기 하기위해서는 생성자에서 초기화, 생성자 없으면 생성자를 대체하는 메소드에서 초기화
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        service = new CalcServiceImpl(); // 초기화 ...................................
        this.setTitle("간단계산 EHLEE");
        etNum1 = (EditText) findViewById(R.id.Input1);
        etNum2 = (EditText) findViewById(R.id.Input2);
//        resS1 = etNum1.getText().toString();
//        resS2 = etNum2.getText().toString();
        num1 = Integer.parseInt(etNum1.getText().toString());
//        System.out.println(etNum1.getText().toString());
        num2 = Integer.parseInt(etNum2.getText().toString());

//        btPlus = (Button) findViewById(R.id.btPlus);
//        btMinus = (Button) findViewById(R.id.btMinus);
//        btMuti = (Button) findViewById(R.id.btMuti);
//        btDevide = (Button) findViewById(R.id.btDivide);
//        btMod = (Button) findViewById(R.id.btMod);
        Resultvalue1 = (TextView) findViewById(R.id.resultValue);
//        res1 = Integer.parseInt(etNum1.toString())+Integer.parseInt(etNum2.toString());


        ((Button) findViewById(R.id.btPlus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btMinus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btMuti)).setOnClickListener(this);
        ((Button) findViewById(R.id.btDivide)).setOnClickListener(this);
        ((Button) findViewById(R.id.btMod)).setOnClickListener(this);

//        btPlus.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Resultvalue1.setText("계산결과 >> " + res1);
//                return false;
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        etNum1 = (EditText) findViewById(R.id.Input1);
        etNum2 = (EditText) findViewById(R.id.Input2);
        num1 = Integer.parseInt(etNum1.getText().toString());
        num2 = Integer.parseInt(etNum2.getText().toString());
        String msg;
        int result = 0;
        switch (v.getId()){
            case R.id.btPlus : result = service.plus(num1,num2); break;
            case R.id.btMinus: result = service.minus(num1,num2);break;
            case R.id.btMuti: result = service.multi(num1,num2);break;
            case R.id.btDivide: result = service.devide(num1,num2);break;
            case R.id.btMod: result = service.nmg(num1,num2);break;
        }
//        Log.d(msg, "카우프지수"); // log 보기
        Resultvalue1.setText("계산결과 :: " + res1);
    }
}
