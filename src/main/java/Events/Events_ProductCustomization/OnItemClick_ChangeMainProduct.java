package Events.Events_ProductCustomization;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import com.example.andreagraziani.myapplication.Activity_ProductSelector;

import Events.Event;

/**
 * This event allow user to open "Activity_ProductSelector" to change main selected product.
 * @author Andrea Graziani
 * @version 1.0
 */
public class OnItemClick_ChangeMainProduct implements AdapterView.OnItemClickListener
{
    private Context context;

    /**
     * Constructs a newly allocated "Event_OpenActivity_2"
     * @param arg0 - Represents "Context" object.
     */
    public OnItemClick_ChangeMainProduct(Context arg0)
    {
        this.context = arg0;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Event.openNewActivity(context, Activity_ProductSelector.class);
    }

}


