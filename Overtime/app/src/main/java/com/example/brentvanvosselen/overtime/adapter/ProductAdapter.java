package com.example.brentvanvosselen.overtime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.brentvanvosselen.overtime.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brentvanvosselen on 18/08/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{

    private List<String> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public void setListData(ArrayList<String> list){
        this.listData.clear();
        this.listData.addAll(list);
    }

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

    class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView productName;
        private Button buttonShow;

        private View container;
        public ProductHolder(View itemView) {
            super(itemView);

            productName = (TextView)itemView.findViewById(R.id.cont_productname_lbl);
            buttonShow = (Button)itemView.findViewById(R.id.cont_show_btn);
            buttonShow.setOnClickListener(this);
            container = itemView.findViewById(R.id.product_item_root);
            //container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.cont_show_btn){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }
}
