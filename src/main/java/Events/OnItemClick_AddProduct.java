package Events;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andreagraziani.myapplication.Activity_ProductCustomization;
import com.example.andreagraziani.myapplication.R;

import Product.Product;
import SelectedProduct.SelectedProduct;


/**
 * This class is used to update selected sweetener product by user.
 * @author Andrea Graziani
 * @version 1.0
 */
public class OnItemClick_AddProduct implements AdapterView.OnItemClickListener
{
    private ListView list;
    private Context context;

    /**
     * Constructs a newly allocated "Event_OpenActivity_2"
     * @param arg0 - Represents the activity context.
     * @param arg1 - Represents an activity object.
     */
    public OnItemClick_AddProduct(Context arg0, ListView arg1)
    {
        this.context = arg0;
        this.list = arg1;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Product x = (Product) list.getItemAtPosition(i);
        SelectedProduct choice = SelectedProduct.getInstance();

        choice.set_MainProduct(x);

        if(!x.getStr_name().equals(context.getString(R.string.str_espresso))) choice.set_AlcoholProduct(null);

        Toast.makeText(this.context, context.getString(R.string.str_choice_you_chose) + " " + x.getStr_name(), Toast.LENGTH_LONG).show();

        Event.openNewActivity(context, Activity_ProductCustomization.class);
    }
}


