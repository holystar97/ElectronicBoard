package org.techtown.mk_20191221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int TextSize=6;
    Button plus;
    Button minus;
    EditText edit;
    TextView maintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus=(Button) findViewById(R.id.plus);
        minus=(Button) findViewById(R.id.minus);
        maintext=(TextView) findViewById(R.id.maintext);

        ButtonSizeChange ButtonSizeChange =new ButtonSizeChange();

        plus.setOnClickListener(ButtonSizeChange);
        minus.setOnClickListener(ButtonSizeChange);

        edit=(EditText) findViewById(R.id.edittext);

        edit.addTextChangedListener(new AddTextChange());

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
