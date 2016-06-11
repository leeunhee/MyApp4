package com.example.user.myapp4.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.user.myapp4.R;
import com.example.user.myapp4.member.MemberBean;
import com.example.user.myapp4.member.MemberDAO;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class Login2Activity extends Activity implements View.OnClickListener {

    EditText etID, etPWD;
    TextView resultValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etID = (EditText) findViewById(R.id.etID);
        etPWD = (EditText) findViewById(R.id.etPWD);

        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
        resultValue = (TextView) findViewById(R.id.resultValue);
    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pwd = etPWD.getText().toString();
        // 새로 배우는 개념
        MemberBean member = new MemberBean();
//        MemberService service = new MemberServiceImpl(); // 0611
        MemberDAO dao = new MemberDAO(this.getApplicationContext());// 0611_1
        // 암호화
        Log.d("id", id);
        member.setId(id);
        member.setPwd(pwd);
//        String msg = service.signup(member); // void 여서 -> string 으로 변경
        member = dao.login(member); // void 여서 -> string 으로 변경 // 0611_1
        Log.d("================", member.getName());
        Log.i("Editid=>", member.getName());

        System.out.println("member.getName()="+member.getName());
        if(member.getName().isEmpty() == true){
            resultValue.setText("로그인 결과 :: 실패 ㅠ.ㅜ");

        }else {
            Log.i("DB 다녀온 결과 ID ", member.getId());
            resultValue.setText("로그인 결과 :: ID = " + member.getId() + " Name = " + member.getName() + "님 환영합니다.^^");

        }

    }
}

