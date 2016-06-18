package com.example.user.myapp4.move;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.user.myapp4.R;

public class MovieActivity extends Activity {
    GridView gv;
    MovieGridAdapter adapter;
//    final  int pos = position;
    Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("그리드 뷰 영화 포스터");
        gv = (GridView) findViewById(R.id.gv);
        adapter = new MovieGridAdapter(this);
        gv.setAdapter(adapter);

    }

    public int getCount() {
        return  posterID.length;
    }
    public View getView(int position, View converView, ViewGroup parent){
        ImageView iv = new ImageView(MovieActivity.this);
        iv.setLayoutParams(new GridView.LayoutParams(100,150) );
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setPadding(5,5,5,5);
        final  int pos = position;
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = View.inflate(MovieActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MovieActivity.this);
                ImageView IvPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                IvPoster.setImageResource(posterID[pos]);
                dlg.setTitle("큰포스터");
                dlg.setIcon(R.drawable.movie);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
//        findViewById(R.id.ivPoster).setOnClickListener(this);

        return  iv;
    }

}
