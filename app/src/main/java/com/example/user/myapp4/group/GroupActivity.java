package com.example.user.myapp4.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapp4.R;

public class GroupActivity extends Activity implements View.OnClickListener{
    GroupDBHelper  groupHelper = new GroupDBHelper(GroupActivity.this);

    SQLiteDatabase db;
    EditText etNAME06,etCNT06,resultValue06,etID;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
       etNAME06 = (EditText) findViewById(R.id.etNAME06);
       etCNT06 = (EditText) findViewById(R.id.etCNT06);
       resultValue06 = (EditText) findViewById(R.id.resultValue06);
       etID = (EditText) findViewById(R.id.etID);

       ((Button) findViewById(R.id.btReset06)).setOnClickListener(this);
       ((Button) findViewById(R.id.btInsert06)).setOnClickListener(this);
       ((Button) findViewById(R.id.btSearch06)).setOnClickListener(this);
       ((Button) findViewById(R.id.btUpate06)).setOnClickListener(this);
       ((Button) findViewById(R.id.btDelete06)).setOnClickListener(this);
       ((Button) findViewById(R.id.btList06)).setOnClickListener(this);
       ((Button) findViewById(R.id.btGroupCnt06)).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Cursor cursor = null;
        String id = null, name = null, num=null;
        switch (view.getId()) {
            case R.id.btReset06:
                db = groupHelper.getWritableDatabase();
                groupHelper.onUpgrade(db,1,2);
                db.close();
                break;
            case R.id.btInsert06:
                db = groupHelper.getWritableDatabase();
                db.execSQL("INSERT INTO girl_group(name,num) VALUES( '" +etNAME06.getText() + "'," + etCNT06.getText()+");");
                db.close();
                Toast.makeText(getApplicationContext(),"입력성공", Toast.LENGTH_LONG).show();
                break;
            case R.id.btSearch06:
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("Select * from girl_group where _id = '" +etID.getText() + "';", null);
                while(cursor.moveToNext()){
                    id = String.valueOf(cursor.getInt(0));
                    name = cursor.getString(1);
                    num = String.valueOf(cursor.getInt(2));
                }
                resultValue06.setText("NO."+id+", 그룹명 : "+name+", 멤버수 : "+num);
//
//                id = "NO"+"\r\n"+"-------------"+"\r\n";
//                name = "그룹이름"+"\r\n"+"-------------"+"\r\n";
//                num = "멤버수"+"\r\n"+"--------------"+"\r\n";
//                cursor.close();
                break;
            case R.id.btUpate06:
                db = groupHelper.getWritableDatabase();
                db.execSQL("Update girl_group set num = " +etCNT06.getText() + " where name = '" +etNAME06.getText()+"';");
                resultValue06.setText("수정 완료");
                db.close();
                break;
            case R.id.btDelete06:
                db = groupHelper.getWritableDatabase();
                db.execSQL("DELETE from girl_group where _id = " + etID.getText() );
                resultValue06.setText("삭제 완료");
                db.close();
                break;
            case R.id.btList06:
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girl_group;",null);
                id = "NO"+"\r\n"+"-------------"+"\r\n";
                name = "그룹이름"+"\r\n"+"-------------"+"\r\n";
                num = "멤버수"+"\r\n"+"--------------"+"\r\n";
                while (cursor.moveToNext()) {
                    id += cursor.getInt(0) + "\r\n";;
                    name += cursor.getString(1) + "\r\n";;
                    num += cursor.getInt(2) + "\r\n";;
                }
                resultValue06.setText(name+num);
                cursor.close();
                db.close();
                break;
            case R.id.btGroupCnt06:
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girl_group;",null);
                int count = cursor.getCount();
                cursor.close();
                resultValue06.setText("DB에 저장된 값 개수 >> " + count);
                db.close();
                break;


        }
    }
}
