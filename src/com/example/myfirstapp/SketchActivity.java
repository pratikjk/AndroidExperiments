package com.example.myfirstapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.customviews.SketchView;

public class SketchActivity extends Activity {
    LinearLayout mLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sketch_activity);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mLl.setBackgroundColor(Color.WHITE);
    }

    public void clear(View v) {
        ((SketchView) mLl.findViewById(R.id.sketch_view)).clear();
    }
}
