package com.example.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.example.myfirstapp.R;

public class DurationTextView extends TextView {

    private static String template = "%s & %s & %s";
    private static final String TAG = DurationTextView.class.getSimpleName();

    public DurationTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs,
                R.styleable.DurationTextView);
        template = attributes.getString(R.styleable.DurationTextView_template);
        boolean test = attributes.getBoolean(R.styleable.DurationTextView_test,
                false);
        Log.d(TAG, "template = " + template);
        Log.d(TAG, "test = " + test);
        attributes.recycle();
    }

    /**
     * Updates the text of the view with the new duration, properly formatted
     * 
     * @param duration
     *            duration in seconds
     */
    public void setDuration(float duration) {
        int sec = (int) (duration % 60);
        duration /= 60;
        int min = (int) duration % 60;
        duration /= 60;
        int hours = (int) duration % 60;

        String hrText = "0 hours";
        String minText = "0 minutes";
        String secText = "0 seconds";

        if (hours > 0) {
            hrText = hours + " hours";
        }
        if (min > 0) {
            minText = min + " minutes";
        }
        if (sec > 0) {
            secText = sec + " seconds";
        }

        if (template == null) {
            template = "%s & %s & %s";
        }
        String durationText = String.format(template, hrText, minText, secText);
        setText(durationText);

    }
}
