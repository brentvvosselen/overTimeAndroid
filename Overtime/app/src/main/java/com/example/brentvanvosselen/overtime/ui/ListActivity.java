package com.example.brentvanvosselen.overtime.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.brentvanvosselen.overtime.R;
import com.example.brentvanvosselen.overtime.adapter.ProductAdapter;
import com.example.brentvanvosselen.overtime.domain.DomainController;
import com.example.brentvanvosselen.overtime.domain.Product;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements ProductAdapter.ItemClickCallback{
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";


    private RecyclerView recView;
    private ProductAdapter adapter;
    private ArrayList listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
               addProduct();
            }
        });

        //set the listdata
        listData = (ArrayList)DomainController.getInstance().getProducts();
        //the recyclerview item in content_list.xml
        recView = (RecyclerView)findViewById(R.id.product_rec_list);
        //layoutmanager: GridlayoutManager or StaggeredGridLayoutManager;
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ProductAdapter(DomainController.getInstance().getProducts(),this);
        recView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //start the addProduct activity
    private void addProduct(){
        Intent intent = new Intent(this,AddProductActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int p) {
        int id = ((Product)listData.get(p)).getId();
        Intent i = new Intent(this, ProductDetailsActivity.class);

        Bundle extras = new Bundle();
        extras.putInt(EXTRA_QUOTE,id);

        i.putExtra(BUNDLE_EXTRAS,extras);
        startActivity(i);

        //pas new data and update
        //adapter.setListData(listData);
        //adapter.notifyDataSetChanged();
    }
}
