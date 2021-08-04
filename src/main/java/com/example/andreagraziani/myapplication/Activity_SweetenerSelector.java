package com.example.andreagraziani.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import java.util.Vector;
import Adapters.AdapterListView_Product;
import Adapters.AdapterListView_Switcher;
import Events.Events_SweetenerSelector.OnCheckedChangeListener_Sweetener_DisableListView;
import Events.Events_SweetenerSelector.OnClickListener_ModifySugarQuantity;
import Events.Events_SweetenerSelector.OnItemClick_AddSweetenerProduct;
import Events.OnItemClick_DisableListView;
import Product.Product;
import Product.ProductDatabaseSQL;
import SelectedProduct.SelectedProduct;

public class Activity_SweetenerSelector extends AppCompatActivity {

    // Get information about selected product by user...
    private static SelectedProduct mySelectedProduct = SelectedProduct.getInstance();

    private ProductDatabaseSQL myProductDatabaseSQL;

    private Vector<Product> mySweetenerProductVector;
    private Vector<String> switcher_string;

    private RadioButton radioArray[];

    public void init() {
        //******************************************************************************************
        // Initialization "RadioButton"
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
        RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);

        radioArray = new RadioButton[]{radio1, radio2, radio3, radio4, radio5};

        OnClickListener_ModifySugarQuantity myEventSugar = new OnClickListener_ModifySugarQuantity(this, radioArray);

        for (RadioButton elem : radioArray) {
            elem.setOnClickListener(myEventSugar);
        }

        //******************************************************************************************
        // Initialization "Button"
        Button addButton = (Button) findViewById(R.id.add_sugar);
        Button reduceButton = (Button) findViewById(R.id.reduce_sugar);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectedProduct var = SelectedProduct.getInstance();

                if (var.get_SweetenerQuantity() < 5)
                    var.set_SweetenerQuantity(var.get_SweetenerQuantity() + 1);
                SugarEvent();
            }
        });

        reduceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectedProduct var = SelectedProduct.getInstance();

                if (var.get_SweetenerQuantity() > 1)
                    var.set_SweetenerQuantity(var.get_SweetenerQuantity() - 1);
                SugarEvent();
            }
        });

        //******************************************************************************************
        // Initialization vector...
        this.myProductDatabaseSQL = ProductDatabaseSQL.getInstance(this);
        this.mySweetenerProductVector = myProductDatabaseSQL.getVector(this.getString(R.string.str_Sweetener), "%", 'n', true);

        //******************************************************************************************
        // Initialization "ListView"
        ListView y = (ListView) findViewById(R.id.activity_sweetener_selector_list);

        y.setAdapter(new AdapterListView_Product(this, mySweetenerProductVector));
        y.setOnItemClickListener(new OnItemClick_AddSweetenerProduct(this, y));

        //******************************************************************************************
        // Initialization "ListView"
        ListView x = (ListView) findViewById(R.id.activity_sweetener_selector_switcher);
        Vector<String> vector = new Vector<String>();
        vector.add(this.getString(R.string.str_sugar_free_drink));

        RelativeLayout z = (RelativeLayout) findViewById(R.id.target_sugar);

        x.setAdapter(new AdapterListView_Switcher(this, vector, new OnCheckedChangeListener_Sweetener_DisableListView(y, z), true));
        x.setOnItemClickListener(new OnItemClick_DisableListView(this));

    }

    /**
     * This method is used to update "Sugar Quantity Display"
     */
    public void SugarEvent()
    {
        for (RadioButton elem : radioArray)
        {
            elem.setChecked(false);
        }

        for (int i = 0; i < mySelectedProduct.get_SweetenerQuantity(); i++)
        {
            radioArray[i].setChecked(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweetener_selector);
        setTitle(R.string.str_activity_3);

        init();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        SugarEvent();
    }
}
