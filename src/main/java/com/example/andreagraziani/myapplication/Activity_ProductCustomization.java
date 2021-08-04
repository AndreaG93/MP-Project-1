package com.example.andreagraziani.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import java.util.Vector;
import Adapters.AdapterListView_CustomizationProduct;
import Adapters.AdapterListView_SelectedProduct;
import Events.Events_ProductCustomization.OnItemClick_ChangeMainProduct;
import Events.Events_ProductCustomization.OnItemClick_OpenSelectors;
import Events.closing;

public class Activity_ProductCustomization extends AppCompatActivity
{
    public void init()
    {
        //******************************************************************************************
        // Initialization vector...
        Vector<String> vector_1 = new Vector<String>();
        Vector<String> vector_2 = new Vector<String>();
        vector_1.add("string_1");
        vector_1.add("string_2");
        vector_2.add("string_3");

        //******************************************************************************************
        // Initialization "ListView"
        ListView x = (ListView) findViewById(R.id.activity_product_customization_selected_product);

        x.setAdapter(new AdapterListView_SelectedProduct(this, vector_2));
        x.setOnItemClickListener(new OnItemClick_ChangeMainProduct(this));

        //******************************************************************************************
        // Initialization "ListView"
        ListView y = (ListView) findViewById(R.id.activity_product_customization_product_customization);



        y.setAdapter(new AdapterListView_CustomizationProduct(this, vector_1));
        y.setOnItemClickListener(new OnItemClick_OpenSelectors(this));

        //******************************************************************************************
        // Closing button
        Button a = (Button) findViewById(R.id.closing);
        a.setOnClickListener(new closing(this));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_customization);
        setTitle(R.string.str_activity_2);

        init();

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        init();
    }

}
