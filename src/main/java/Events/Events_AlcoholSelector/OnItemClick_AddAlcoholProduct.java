package Events.Events_AlcoholSelector;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.andreagraziani.myapplication.Activity_ProductCustomization;

import Events.Event;
import Product.Product;
import SelectedProduct.SelectedProduct;


/**
 * This class is used to update selected alcohol product by user.
 * @author Andrea Graziani
 * @version 1.0
 */
public class OnItemClick_AddAlcoholProduct implements AdapterView.OnItemClickListener
{
    private ListView list;
    private Context context;

    /**
     * Constructs a newly allocated "Event_OpenActivity_2"
     * @param arg0 - Represents the activity context.
     * @param arg1 - Represents an activity object.
     */
    public OnItemClick_AddAlcoholProduct(Context arg0, ListView arg1)
    {
        this.context = arg0;
        this.list = arg1;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        SelectedProduct.getInstance().set_AlcoholProduct((Product) list.getItemAtPosition(i));
        Event.openNewActivity(context, Activity_ProductCustomization.class);
    }
}


