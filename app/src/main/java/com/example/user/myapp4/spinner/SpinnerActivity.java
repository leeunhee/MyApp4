package com.example.user.myapp4.spinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.user.myapp4.R;

import static com.example.user.myapp4.R.id.spinner1;

public class SpinnerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        setTitle("스피너 **");
        String[] movie = {"쿵푸펜더", "짱구", "아저씨", "아바타", "대부", "국가대표","토이","암닭"};
        Spinner spinner = (Spinner) findViewById(spinner1);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,movie);
        spinner.setAdapter(adapter);

    }
}
