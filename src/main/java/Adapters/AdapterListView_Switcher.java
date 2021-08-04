package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;
import com.example.andreagraziani.myapplication.R;
import java.util.Vector;
import SelectedProduct.SelectedProduct;

/**
 * This class represents an "Adapter" used to display a "Switcher" in a "ListView"
 *
 * @author Andrea Graziani
 * @see SelectedProduct
 * @version 1.0
 */
public class AdapterListView_Switcher extends BaseAdapter
{
    private static SelectedProduct mySelectedProduct = SelectedProduct.getInstance();

    private Vector<String> vector;
    private LayoutInflater inflater;
    private Switch.OnCheckedChangeListener event;
    private boolean isSugarSelector;

    /**
     * Constructs a newly allocated "AdapterListView_Switcher" object.
     *
     * @param arg0 - Represents a "Context" object.
     * @param arg1 - Represents a "Vector" object.
     */
    public AdapterListView_Switcher(@NonNull Context arg0, @NonNull Vector<String> arg1, Switch.OnCheckedChangeListener arg2, boolean dd)
    {
        this.vector = arg1;
        this.event = arg2;
        this.isSugarSelector = dd;
        this.inflater = (LayoutInflater) arg0.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public int getCount() {return vector.size();}

    @Override
    public String getItem(int position) {return vector.get(position);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if(view == null) view = inflater.inflate(R.layout.custom_list_row_switcher, null);

        ((TextView) view.findViewById(R.id.custom_text_view_row_switcher)).setText(vector.get(position));

        Switch x = (Switch) view.findViewById(R.id.custom_switcher);
        x.setOnCheckedChangeListener(this.event);

        if(this.isSugarSelector)
        {
            if (mySelectedProduct.get_SweetenerProduct() == null) x.setChecked(true);
        }
        else {
            if (mySelectedProduct.get_AlcoholProduct() == null) x.setChecked(true);
        }

        return view;
    }

}
