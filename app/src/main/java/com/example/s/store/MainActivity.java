package com.example.s.store;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s.store.models.Product;
import com.example.s.store.models.ProductRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    List<Product> productsList;
    List<Product> productsInBasket = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialProduct();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ma_product_list_rv);
        ProductRecyclerView productAdapter = new ProductRecyclerView(productsList);
        recyclerView.setAdapter(productAdapter);



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  void onClickBtnAdd(View view){
        View parent = (View) view.getParent();
        TextView textView = (TextView)parent.findViewById(R.id.prod_name_tv);
        Button btnIdAdd  = (Button) parent.findViewById(R.id.product_add_btn);
        Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
        addInBasket((Integer)btnIdAdd.getTag());
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addInBasket(int id){
        for (Product product: productsList ) {
            if(product.getId() == id)
                productsInBasket.add(product);
        }
        //@SuppressLint("ResourceType") Menu menu = findViewById(R.menu.main_menu);
        //menu.getItem(1).setIcon(R.drawable.ic_add_shopping_cart_black_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         item.setIcon(R.drawable.ic_add_shopping_cart_black_24dp);
        return super.onOptionsItemSelected(item);
    }

    private void initialProduct() {
        productsList = new ArrayList<>();
        productsList.add(new Product(1,"Tomato", 250,1));
        productsList.add(new Product(2,"Potato", 150, 1));
        productsList.add(new Product(3,"Cucumber", 200, 1));
    }


}
