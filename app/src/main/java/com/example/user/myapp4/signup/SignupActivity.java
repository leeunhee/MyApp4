package com.example.user.myapp4.signup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp4.R;
import com.example.user.myapp4.member.MemberBean;
import com.example.user.myapp4.member.MemberDAO;
import com.example.user.myapp4.member.MemberService;
import com.example.user.myapp4.member.MemberServiceImpl;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etID, etPWD, etNAME, etMail;
    TextView resultValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        etID = (EditText) findViewById(R.id.etID);
        etPWD = (EditText) findViewById(R.id.etPWD);
        etNAME = (EditText) findViewById(R.id.etNAME);
        etMail = (EditText) findViewById(R.id.etMail);
        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
        resultValue = (TextView) findViewById(R.id.resultValue);
    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String name = etNAME.getText().toString();
        String pwd = etPWD.getText().toString();
        String email = etMail.getText().toString();
        // 새로 배우는 개념
        MemberBean member = new MemberBean();
        MemberService service = new MemberServiceImpl();
        MemberDAO dao = new MemberDAO(this.getApplicationContext()); // --
        // 암호화
        member.setId(id);
        member.setName(name);
        member.setPwd(pwd);
        member.setEmail(email);
//        String msg = service.signup(member); // void 여서 -> string 으로 변경
        String msg = dao.signup(member); // void 여서 -> string 으로 변경 // --
        resultValue.setText("회원가입 결과 :: " + msg);

    }
}
