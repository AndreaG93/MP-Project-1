package com.example.andreagraziani.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.Vector;
import Adapters.AdapterListView_Product;
import Dialog.DialogBuilder;
import Events.OnItemClick_AddProduct;
import Events.OnclickListener_UpdateSelectorProduct;
import Product.Product;
import Product.ProductDatabaseSQL;
import SelectedProduct.SelectedProduct;

public class Activity_ProductSelector extends AppCompatActivity {

    private ProductDatabaseSQL myProductDatabaseSQL;
    private Vector<Product> myAllProductVector;
    private static SelectedProduct mySelectedProduct = SelectedProduct.getInstance();


    public void init() {
        //******************************************************************************************
        // Initialization vector...
        this.myProductDatabaseSQL = ProductDatabaseSQL.getInstance(this);
        this.myAllProductVector = myProductDatabaseSQL.getVector(this.getString(R.string.str_drink), "%", mySelectedProduct.getSortBy(), mySelectedProduct.isAscendentOrder());

        //******************************************************************************************
        // Initialization ListView: Adapter and Event.
        ListView x = (ListView) findViewById(R.id.list);

        x.setAdapter(new AdapterListView_Product(this, this.myAllProductVector));
        x.setOnItemClickListener(new OnItemClick_AddProduct(this, x));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_selector);
        setTitle(R.string.str_activity_1);
        init();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activiy_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        OnclickListener_UpdateSelectorProduct Event = new OnclickListener_UpdateSelectorProduct(this);

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_sort_by:
                DialogBuilder.sortByDialog(this, Event).show();
                return true;

            case R.id.menu_order_by:
                DialogBuilder.orderByDialog(this, Event).show();
                return true;

            default:

                return super.onOptionsItemSelected(item);




        }
    }


}
