package com.example.brentvanvosselen.overtime.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.brentvanvosselen.overtime.R;
import com.example.brentvanvosselen.overtime.domain.CustomFunctions;
import com.example.brentvanvosselen.overtime.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brentvanvosselen on 18/08/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{

    private List<Product> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public void setListData(ArrayList<Product> list){
        this.listData.clear();
        this.listData.addAll(list);
    }

    public ProductAdapter(List<Product> listData, Context c) {
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
        Product p =  listData.get(position);
        holder.productName.setText(p.getName());
        holder.quantity.setText(p.getQuantity() + " pcs.");
        holder.expirationDate.setText(CustomFunctions.getDateString(p.getExpirationDate()));

    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView productName;
        private TextView quantity;
        private TextView expirationDate;
        private Button buttonShow;

        private View container;
        public ProductHolder(View itemView) {
            super(itemView);

            productName = (TextView)itemView.findViewById(R.id.cont_productname_lbl);
            quantity = (TextView)itemView.findViewById(R.id.cont_quantity_lbl);
            expirationDate =(TextView)itemView.findViewById(R.id.cont_expiration_lbl);
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
