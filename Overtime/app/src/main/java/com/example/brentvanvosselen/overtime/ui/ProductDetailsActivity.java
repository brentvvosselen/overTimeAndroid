package com.example.brentvanvosselen.overtime.ui;

import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.brentvanvosselen.overtime.R;
import com.example.brentvanvosselen.overtime.domain.CustomFunctions;
import com.example.brentvanvosselen.overtime.domain.DomainController;
import com.example.brentvanvosselen.overtime.domain.Product;

import org.w3c.dom.Text;

public class ProductDetailsActivity extends AppCompatActivity {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";

    private TextView productNameTxt;
    private TextView quantityTxt;
    private TextView expirationdateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        productNameTxt = (TextView)findViewById(R.id.product_name_details_txt);
        quantityTxt = (TextView)findViewById(R.id.quantity_details_txt);
        expirationdateTxt = (TextView)findViewById(R.id.expiration_date_details_txt);

        int id = extras.getInt(EXTRA_QUOTE);

            Product product = DomainController.getInstance().getProductById(id);
            productNameTxt.setText(product.getName());
            quantityTxt.setText(String.valueOf(product.getQuantity()));
            expirationdateTxt.setText(CustomFunctions.getDateString(product.getExpirationDate()));




    }
}
