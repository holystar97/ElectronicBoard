package org.techtown.mk_20191221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {

    TextView maintext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        String text= getIntent().getStringExtra("text");

        maintext=(TextView) findViewById(R.id.textView);
        maintext.setText(text);

    }
}
