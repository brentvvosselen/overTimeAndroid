package com.example.brentvanvosselen.overtime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.brentvanvosselen.overtime.R;

import java.util.List;

/**
 * Created by brentvanvosselen on 18/08/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{

    private List<String> listData;
    private LayoutInflater inflater;

    public ProductAdapter(List<String> listData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        String item = listData.get(position);
        holder.productName.setText(item);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder{

        private TextView productName;
        private View container;
        public ProductHolder(View itemView) {
            super(itemView);

            productName = (TextView)itemView.findViewById(R.id.product_name_list_txt);
            container = itemView.findViewById(R.id.product_item_root);
        }
    }
}
