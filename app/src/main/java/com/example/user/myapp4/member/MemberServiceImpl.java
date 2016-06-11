package com.example.user.myapp4.member;

import android.app.Activity;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberServiceImpl extends Activity implements MemberService {
//    MemberDAO dao = new MemberDAO(this.getApplicationContext()); // 0611
    MemberDAO dao = null; // 0611_1
    @Override
    public String signup(MemberBean member) {
        String msg = dao.signup(member); // Activity에 전달하는 방식의 서비스.
        return msg;
//        return dao.signup(member); // 위 두줄을 하나로
    }
//    public String signup(MemberBean member); // 메소드 Create
//    public MemberBean login(MemberBean member); // 메소드 Read
//    public MemberBean update(MemberBean member); // 메소드 Update
//    public String delete(MemberBean member); // 메소드 Delete
    @Override
    public MemberBean login(MemberBean member) {
        return dao.login(member);
    }

    @Override
    public MemberBean update(MemberBean member) {

        return dao.update(member);
    }

    @Override
    public String delete(MemberBean member) {
        return dao.delete(member);
    }
}
