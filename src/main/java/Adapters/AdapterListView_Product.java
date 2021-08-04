package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Vector;
import Product.Product;
import com.example.andreagraziani.myapplication.R;

/**
 * This class represents an "Adapter" used to display all "Product" objects in a "ListView".
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public class AdapterListView_Product extends BaseAdapter
{
    private Context context;
    private Vector<Product> vector;
    private static LayoutInflater inflater = null;

    @Override
    public int getCount() {return vector.size();}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public Object getItem(int position) {return vector.get(position);}

    /**
     * Constructs a newly allocated "AdapterListView_Product" object.
     * @param arg0 - Represents a "Context" object.
     * @param arg1 - Represents a vector of "Product" objects.
     */
    public AdapterListView_Product(@NonNull Context arg0, @NonNull Vector<Product> arg1)
    {
        this.context = arg0;
        this.vector = arg1;
        inflater = (LayoutInflater) arg0.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        if (vi == null) vi = inflater.inflate(R.layout.custom_list_row_product, null);

        // Get object in the vector
        Product elem = vector.get(position);

        // Initialization widget...
        ((TextView) vi.findViewById(R.id.custom_list_row_product_name)).setText(elem.getStr_name());
        ((TextView) vi.findViewById(R.id.custom_list_row_product_brand)).setText(elem.getStr_brand());
        ((TextView) vi.findViewById(R.id.custom_list_row_product_price)).setText(context.getString(R.string.str_price) + " " + String.valueOf(elem.getD_price()));
        ((ImageView) vi.findViewById(R.id.custom_list_row_product_image)).setImageDrawable(elem.getDrw_image());

        if(elem.getStr_type().equals(context.getString(R.string.str_alcohol)))
        {
            ((TextView) vi.findViewById(R.id.custom_list_row_alcohol_content)).setText(context.getText(R.string.str_alcohol_content) + " " + String.valueOf(elem.getD_alcoholContent()));
        }

        return vi;
    }
}
