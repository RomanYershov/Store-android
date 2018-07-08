package com.example.s.store.models;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s.store.R;

import java.util.List;

public class ProductRecyclerView extends RecyclerView.Adapter<ProductRecyclerView.ProductViewHolder> {
    List<Product> products;

    public ProductRecyclerView(@NonNull List<Product> products){
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ProductViewHolder(layoutInflater.inflate(R.layout.products, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
         Product product = products.get(position);
         holder.name.setText(product.getName());
         holder.price.setText(String.valueOf(product.getPrice()));
         holder.id.setTag(product.getId());
        // holder.image.setImageResource(R.drawable.round);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        public Button id;
        public TextView name;
        public TextView price;
        public ImageView image;


        public ProductViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.product_add_btn);
            name = itemView.findViewById(R.id.prod_name_tv);
            price = itemView.findViewById(R.id.prod_price_tv);

        }
    }
}
