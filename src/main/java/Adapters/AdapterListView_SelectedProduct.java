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
import SelectedProduct.SelectedProduct;

import com.example.andreagraziani.myapplication.R;

/**
 * This class represents an "Adapter" used to display all selected product in a "ListView".
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public class AdapterListView_SelectedProduct extends BaseAdapter
{
    private static SelectedProduct mySelectedProduct = SelectedProduct.getInstance();
    private Vector<String> vector;
    private LayoutInflater inflater;
    private Context context;

    /**
     * Constructs a newly allocated "AdapterListView_SelectedProduct" object.
     * @param arg0 - Represents a "Context" object.
     * @param arg1 - Represents a vector of "Product" objects.
     */
    public AdapterListView_SelectedProduct(@NonNull Context arg0, @NonNull Vector<String> arg1)
    {
        this.context = arg0;
        this.vector = arg1;
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
        if(view == null) view = inflater.inflate(R.layout.custom_list_row_product, null);

        // Initialization widget
        TextView productName = (TextView) view.findViewById(R.id.custom_list_row_product_name);
        TextView productBrand = (TextView) view.findViewById(R.id.custom_list_row_product_brand);
        TextView productPrice = (TextView) view.findViewById(R.id.custom_list_row_product_price);
        ImageView productImage = (ImageView) view.findViewById(R.id.custom_list_row_product_image);

        productName.setText(mySelectedProduct.get_MainProduct().getStr_name());
        productBrand.setText(mySelectedProduct.get_MainProduct().getStr_brand());
        productPrice.setText(context.getText(R.string.str_price) + " " + String.valueOf(mySelectedProduct.get_MainProduct().getD_price()));
        productImage.setImageDrawable(mySelectedProduct.get_MainProduct().getDrw_image());

        return view;
    }

}
