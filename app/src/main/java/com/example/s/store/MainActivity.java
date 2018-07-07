package com.example.s.store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.example.s.store.models.Product;
import com.example.s.store.models.ProductRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Product> productsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialProduct();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ma_product_list_rv);
        ProductRecyclerView productAdapter = new ProductRecyclerView(productsList);
        recyclerView.setAdapter(productAdapter);

        Button btnAdd = findViewById(R.id.product_add_btn);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void initialProduct() {
        productsList = new ArrayList<>();
        productsList.add(new Product("Tomato", 250,1));
        productsList.add(new Product("Potato", 150, 1));
        productsList.add(new Product("Cucumber", 200, 1));
    }


}
