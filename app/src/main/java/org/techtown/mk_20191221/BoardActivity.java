package org.techtown.mk_20191221;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {

    TextView textView;
    ConstraintLayout layout;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            setContentView(R.layout.activity_board);

            String text= getIntent().getStringExtra("text");

            textView=(TextView) findViewById(R.id.textView);
            textView.setText(text);

            int mcolor=getIntent().getIntExtra("mcolor",1);
            textView.setBackgroundColor(mcolor);

            int tcolor=getIntent().getIntExtra("tcolor",1);
            textView.setTextColor(tcolor);

            int tsize=getIntent().getIntExtra("tsize",1);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,tsize+500);

            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

        }
}