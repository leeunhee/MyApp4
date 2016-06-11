package com.example.user.myapp4.member;

/**
 * Created by USER on 2016-06-11.
 */
public interface MemberService {
    public String signup(MemberBean member); // 메소드 Create
    public MemberBean login(MemberBean member); // 메소드 Read
    public MemberBean update(MemberBean member); // 메소드 Update
    public String delete(MemberBean member); // 메소드 Delete

}
