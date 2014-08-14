package com.example.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.customviews.DrawableView;

public class MainActivity extends SimpleViewServerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DurationTextView dtv1 = (DurationTextView)
        // findViewById(R.id.mytextview1);
        // dtv1.setDuration(25);
        //
        // DurationTextView dtv2 = (DurationTextView)
        // findViewById(R.id.mytextview2);
        // dtv2.setDuration(11250);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        ll.setBackgroundColor(Color.WHITE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void setCycling(View v) {
        DrawableView dv = (DrawableView) findViewById(R.id.mydrawview3);
        dv.showCyclingData();
    }

    public void setRunning(View v) {
        DrawableView dv = (DrawableView) findViewById(R.id.mydrawview3);
        dv.showRunningData();
    }

    public void setDancing(View v) {
        DrawableView dv = (DrawableView) findViewById(R.id.mydrawview3);
        dv.showDancingData();
    }

}
