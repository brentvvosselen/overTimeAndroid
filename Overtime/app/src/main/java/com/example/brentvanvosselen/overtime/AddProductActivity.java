package com.example.brentvanvosselen.overtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Delete the action bar*/
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_add_product);

        /*Initialize the textFields*/
        final EditText nameTxt = (EditText)findViewById(R.id.name_txt);
            /*Initialize the numeric fields and disable 0 */
            final EditText quantityTxt = (EditText)findViewById(R.id.quantity_txt);
            quantityTxt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (editable.length() == 1 && editable.toString().equals("0"))
                        quantityTxt.setText("");
                }
            });
        /*Initialize the datepicker*/
        DatePicker expirationDatePicker = (DatePicker)findViewById(R.id.expiration_date_picker);
        /*Initialize the button + onclick event*/
        Button addBtn = (Button)findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTxt.setText("test");
            }
        });




    }
}
