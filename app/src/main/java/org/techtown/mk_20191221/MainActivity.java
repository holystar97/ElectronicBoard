package org.techtown.mk_20191221;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLayout;
    int mDefaultColor;
    int tDefaultColor;
    int TextSize=6;
    Button plus;
    Button minus;
    Button right;
    Button left;
    Button text,back,blink,stop;
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
        text=(Button) findViewById(R.id.text);
        back=(Button) findViewById(R.id.back);
        mLayout=(LinearLayout)findViewById(R.id.Linear);
        mDefaultColor= ContextCompat.getColor(MainActivity.this,R.color.colorPrimary);
        tDefaultColor= ContextCompat.getColor(MainActivity.this,R.color.colorPrimary);
        blink=(Button) findViewById(R.id.blink);
        stop=(Button) findViewById(R.id.stop);

        plus.setOnClickListener(new ButtonSizeChange());
        minus.setOnClickListener(new ButtonSizeChange());
        right.setOnClickListener(new FlowText());
        left.setOnClickListener(new FlowText());
        text.setOnClickListener(new ChangeColor());
        back.setOnClickListener(new ChangeColor());
        blink.setOnClickListener(new Blink());
        stop.setOnClickListener(new Blink());


        edit.addTextChangedListener(new AddTextChange());

        animationToLeft= new TranslateAnimation(450,-1200,0,0);
        animationToLeft.setDuration(12000);
        animationToLeft.setRepeatMode(Animation.RESTART);
        animationToLeft.setRepeatCount(Animation.INFINITE);


        animationToRight= new TranslateAnimation(450,1200,0,0);
        animationToRight.setDuration(12000);
        animationToRight.setRepeatMode(Animation.RESTART);
        animationToRight.setRepeatCount(Animation.INFINITE);

    }


//    public void nonblink(){
//
//    Thread thread =new PrintThread();
//    thread.start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    .interrupt();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }





    class Stop implements  View.OnClickListener{

        @Override
        public void onClick(View view) {

//            nonblink();

        }
    }


    class Blink implements View.OnClickListener{

        public void blink(){

            final Handler handler=new Handler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int timeToBlink=500;
                    try{
                        Thread.sleep(timeToBlink);
                    }catch(Exception e){}

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            maintext=(TextView)findViewById(R.id.maintext);
                            if(maintext.getVisibility()==View.VISIBLE){
                                maintext.setVisibility(View.INVISIBLE);
                            }else{
                                maintext.setVisibility(View.VISIBLE);
                            }
                            blink();
                        }

                    });
                }
            }).start();
        }

        @Override
        public void onClick(View view) {
            blink();

        }

    }


    class ChangeColor implements  View.OnClickListener{

        @Override
        public void onClick(View view) {

            int id=view.getId();
            openColorPicker(id);
        }
    }

    public void openColorPicker(final int id){
        AmbilWarnaDialog colorPicker =new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                mDefaultColor=color;
                tDefaultColor=color;
                 switch(id){
                    case R.id.text:
                        maintext.setTextColor(tDefaultColor);
                        break;
                    case R.id.back:
                        mLayout.setBackgroundColor(mDefaultColor);
                        break;
                }

            }
        });
        colorPicker.show();
    }


    class ChangeTextColor implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //AmbilWarnaDialog .Builder builder = new ColorPickerDialog.Builder(this);
            //ColorPickerDialog.newBuilder().setDialogType(ColorPickerDialog.TYPE_PRESETS).show(this);
        }
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
