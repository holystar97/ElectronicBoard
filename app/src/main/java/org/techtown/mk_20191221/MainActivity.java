package org.techtown.mk_20191221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int TextSize=6;
    Button plus;
    Button minus;
    Button right;
    Button left;
    EditText edit;
    TextView maintext;
    Animation animationToLeft, animationToRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus=(Button) findViewById(R.id.plus);
        minus=(Button) findViewById(R.id.minus);
        right=(Button) findViewById(R.id.right);
        left=(Button) findViewById(R.id.left);
        maintext=(TextView) findViewById(R.id.maintext);
        edit=(EditText) findViewById(R.id.edittext);


        plus.setOnClickListener(new ButtonSizeChange());
        minus.setOnClickListener(new ButtonSizeChange());
        right.setOnClickListener(new FlowText());
        left.setOnClickListener(new FlowText());

        edit.addTextChangedListener(new AddTextChange());

        animationToLeft= new TranslateAnimation(600,-1200,0,0);
        animationToLeft.setDuration(12000);
        animationToLeft.setRepeatMode(Animation.RESTART);
        animationToLeft.setRepeatCount(Animation.INFINITE);


        animationToRight= new TranslateAnimation(600,1200,0,0);
        animationToRight.setDuration(12000);
        animationToRight.setRepeatMode(Animation.RESTART);
        animationToRight.setRepeatCount(Animation.INFINITE);





    }

    class FlowText implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            int id=view.getId();
            switch(id){
                case R.id.left:
                       maintext.setAnimation(animationToLeft);
                    break;
                case R.id.right:
                    maintext.setAnimation(animationToRight);
                    break;
            }


        }
    }


    class AddTextChange implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            maintext.setText(edit.getText());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }


    }




    class ButtonSizeChange implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int id=view.getId();
            switch(id){
                case R.id.plus:
                    maintext.setTextSize(TypedValue.COMPLEX_UNIT_PX,maintext.getTextSize()+TextSize);
                    break;
                case R.id.minus:
                    maintext.setTextSize(TypedValue.COMPLEX_UNIT_PX,maintext.getTextSize()-TextSize);
                    break;
            }
        }
    }








}
