package com.example.user.myapp4.move;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.user.myapp4.R;

public class MovieActivity extends Activity {
    GridView gv;
    MovieGridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("그리드 뷰 영화 포스터");
        gv = (GridView) findViewById(R.id.gv);
        adapter = new MovieGridAdapter(this);
        gv.setAdapter(adapter);

    }
}
