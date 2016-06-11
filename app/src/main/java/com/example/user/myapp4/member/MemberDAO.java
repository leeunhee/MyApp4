package com.example.user.myapp4.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, "hanbitDB", null, 1); // DB_NAME, null, DB_VERSION , 1

//        super(context, name, factory, version);
    }
    // DB 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("Create table member2 (id text, pw text, name text , email text);");

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
        SQLiteDatabase db = this.getReadableDatabase();
        Log.i("Editid=>", member.getId());
        Cursor cursor  = db.rawQuery("Select id, pw, name, email from member where id = '"+ member.getId() +"' and pw = '"+ member.getPwd() +"' ; ", null);
//        Cursor cursor  = db.rawQuery("Select id, pw, name, email from member; ", null);
        String cid = "";
        String pw = "";
        String cname = "";
        String email = "";
        while (cursor.moveToNext()) {
            cid = cursor.getString(0);
            pw = cursor.getString(1);
            cname = cursor.getString(2);
            email = cursor.getString(3);

        }
        MemberBean mem = new MemberBean();
        mem.setId(cid);
        mem.setName(cname);
        mem.setPwd(pw);
        mem.setEmail(email);
        Log.i("id=>", cid);
        Log.i("pwd=>", pw);
        Log.i("name=>", cname);
        Log.i("email=>", email);
        cursor.close(); // 빠트리지 말자
        db.close();// 빠트리지 말자
//        mem.setId(member.getId());
//        mem.setName("이은희");
//        mem.setPwd(member.getPwd());
//        mem.setEmail("leeunhee@hotmail.com");
//        Log.i("id=", mem.getId());
//        Log.i("name=", mem.getName());
//        Log.i("pwd=", mem.getPwd());
//        Log.i("email=", mem.getEmail());


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
