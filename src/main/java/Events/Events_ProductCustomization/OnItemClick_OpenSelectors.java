package Events.Events_ProductCustomization;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.andreagraziani.myapplication.Activity_AlcoholSelector;
import com.example.andreagraziani.myapplication.Activity_SweetenerSelector;
import com.example.andreagraziani.myapplication.R;

import Events.Event;
import Product.Product;
import SelectedProduct.SelectedProduct;

/**
 * This event allow user to open "AlcoholSelector" and "SweetenerSelector" activities.
 * @author Andrea Graziani
 * @version 1.0
 */
public class OnItemClick_OpenSelectors implements AdapterView.OnItemClickListener
{
    private Context context;

    /**
     * Constructs a newly allocated "Event_OpenActivity_2"
     * @param arg0 - Represents "Context" object.
     */
    public OnItemClick_OpenSelectors(Context arg0)
    {
        this.context = arg0;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        if(i == 0) Event.openNewActivity(context, Activity_SweetenerSelector.class);
        if(i == 1)
        {
            SelectedProduct x = SelectedProduct.getInstance();
            String p = x.get_MainProduct().getStr_name();
            String q = context.getString(R.string.str_espresso);

            if(p.equals(q))
            {
                Event.openNewActivity(context, Activity_AlcoholSelector.class);
            }
            else
            {
                Toast.makeText(context, context.getString(R.string.Not_Alcohol), Toast.LENGTH_LONG).show();
            }



        }
    }

}


