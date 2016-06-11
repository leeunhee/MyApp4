package com.example.user.myapp4.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, null, null, 1); // DB_NAME, null, DB_VERSION , 1
//        super(context, name, factory, version);
    }
    // DB 생성
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // DB update
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // MemberServiceImpl 에 있던 부분 가져다가 @Override 지운다
//    @Override // 지운다
    public String signup(MemberBean member) {
        String name = member.getName();
        String id = member.getId();
        String pwd = member.getPwd();
        String email = member.getEmail();

        Log.i("name-", name);
        Log.i("id-", id);
        Log.i("pwd-", pwd);
        Log.i("email-", email);
        return "회원가입을 축하합니다";
    }

//    @Override // 지운다
    public MemberBean login(MemberBean member) {
        MemberBean mem = new MemberBean();
        return mem;
    }

//    @Override // 지운다
    public MemberBean update(MemberBean member) {
        MemberBean mem = new MemberBean();
        return mem;
    }

//    @Override // 지운다
    public String delete(MemberBean member) {
        return "삭제 완료";
    }

}
