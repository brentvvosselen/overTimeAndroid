package com.example.brentvanvosselen.overtime.ui;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.brentvanvosselen.overtime.R;
import com.example.brentvanvosselen.overtime.domain.DomainController;

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
        final DatePicker expirationDatePicker = (DatePicker)findViewById(R.id.expiration_date_picker);
        /*Initialize the button + onclick event*/
        Button addBtn = (Button)findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try{
                    String name = nameTxt.getText().toString();
                    int quantity = Integer.parseInt(quantityTxt.getText().toString());
                    Date expirationDate = new Date(expirationDatePicker.getYear() - 1900,expirationDatePicker.getMonth(),expirationDatePicker.getDayOfMonth());
                    DomainController.getInstance().addProduct(name,quantity,expirationDate);
                    showListActivity();

                } catch(NumberFormatException ex){

                    Snackbar.make(view, "There was no valid number in the quantity field", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } catch(IllegalArgumentException ex){
                      Snackbar.make(view, ex.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }
            }
        });




    }

    private void showListActivity(){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }
}
