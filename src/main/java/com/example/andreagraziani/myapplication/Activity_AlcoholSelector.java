package com.example.andreagraziani.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.Vector;
import Adapters.AdapterListView_Product;
import Adapters.AdapterListView_Switcher;
import Events.Events_AlcoholSelector.OnCheckedChangeListener_Alcohol_DisableListView;
import Events.Events_AlcoholSelector.OnItemClick_AddAlcoholProduct;
import Events.OnItemClick_DisableListView;
import Product.*;

public class Activity_AlcoholSelector extends AppCompatActivity {

    public void init()
    {
        // Initialization vector...
        ProductDatabaseSQL myProductDatabaseSQL = ProductDatabaseSQL.getInstance(this);
        Vector<Product> myAlcoholProductVector = myProductDatabaseSQL.getVector(this.getString(R.string.str_alcohol),"%", 'a', true);

        // Initialization texts...
        Vector<String> switcher_string = new Vector<String>();
        switcher_string.add(this.getString(R.string.str_alcohol_free_drink));

        //******************************************************************************************
        // Initialization ListView...
        ListView x = (ListView) findViewById(R.id.activity_alcohol_selector_list);

        x.setAdapter(new AdapterListView_Product(this, myAlcoholProductVector));
        x.setOnItemClickListener(new OnItemClick_AddAlcoholProduct(this, x));

        //******************************************************************************************
        // Initialization ListView...
        ListView y = (ListView) findViewById(R.id.activity_alcohol_selector_switcher);

        y.setAdapter(new AdapterListView_Switcher(this, switcher_string, new OnCheckedChangeListener_Alcohol_DisableListView(x), false));
        y.setOnItemClickListener(new OnItemClick_DisableListView(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_selector);
        setTitle(R.string.str_activity_4);

        init();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }
}
