package com.rishad.swimlaps;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class SessionActivity extends AppCompatActivity {
    Chronometer mChronometer;
    static long mCurrentChronometerValue = 0;
    static String mCurrentChronometerValueString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        if (mCurrentChronometerValueString.length() > 0) {
            mChronometer.setText(mCurrentChronometerValueString);
        }

        /*
         * Pause
         */
        Button newSessionButton = (Button) findViewById(R.id.pauseButton);
        newSessionButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                mChronometer.stop();
                mCurrentChronometerValueString = (String) mChronometer.getText();
                mCurrentChronometerValue = mChronometer.getBase() - SystemClock.elapsedRealtime();

                Intent intent = new Intent(view.getContext(), PauseActivity.class);
                startActivity(intent);
            }
        });

        /*
         * Go
         */
        Button goButton = (Button) findViewById(R.id.goButton);
        goButton.setOnClickListener(mStartListener);
    }

    View.OnClickListener mStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime() + mCurrentChronometerValue);
            mChronometer.start();
        }
    };

    View.OnClickListener mStopListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.stop();
        }
    };

    View.OnClickListener mResetListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
        }
    };
}
