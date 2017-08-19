package com.example.brentvanvosselen.overtime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.brentvanvosselen.overtime.R;

import org.w3c.dom.Text;

public class ProductDetailsActivity extends AppCompatActivity {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";

    private TextView productNameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        productNameTxt = (TextView)findViewById(R.id.product_name_details_txt);
        String tmp = extras.getString(EXTRA_QUOTE);
        productNameTxt.setText(tmp);
    }
}
