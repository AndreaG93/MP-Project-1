package Events;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Switch;

import com.example.andreagraziani.myapplication.R;

/**
 * Created by Andrea Graziani on 02/12/2016.
 */

public class OnItemClick_DisableListView implements AdapterView.OnItemClickListener
{
    private Context context;

    /**
     * Constructs a newly allocated "Event_OpenActivity_2"
     * @param arg0 - Represents the activity context.
     */
    public OnItemClick_DisableListView(Context arg0)
    {
        this.context = arg0;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Switch target = (Switch) view.findViewById(R.id.custom_switcher);
        if (target.isChecked()) target.setChecked(false);
        else target.setChecked(true);
    }
}


