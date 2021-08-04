package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andreagraziani.myapplication.R;
import java.util.Vector;
import SelectedProduct.SelectedProduct;

/**
 * This class represents an "Adapter" used to display product's option selected by user in a "ListView".
 *
 * @author Andrea Graziani
 * @version 1.0
 */
public class AdapterListView_CustomizationProduct extends BaseAdapter
{
    private static SelectedProduct mySelectedProduct = SelectedProduct.getInstance();
    private Vector<String> vector;
    private LayoutInflater inflater;
    private Context context;

    /**
     * Constructs a newly allocated "AdapterListView_Switcher" object.
     * @param arg0 - Represents a "Context" object.
     * @param arg1 - Represents a vector of "Product" objects.
     */
    public AdapterListView_CustomizationProduct(@NonNull Context arg0, @NonNull Vector<String> arg1)
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
        TextView productAlcoholContent = (TextView) view.findViewById(R.id.custom_list_row_alcohol_content);
        ImageView productImage = (ImageView) view.findViewById(R.id.custom_list_row_product_image);

        if(position == 0)
        {
            if(mySelectedProduct.get_SweetenerProduct() == null)
            {
                // If user use any sweetener
                productImage.setImageDrawable(context.getDrawable(R.drawable.drawable_add));
                productName.setText(context.getText(R.string.str_add_sweetener));
                productBrand.setText(context.getText(R.string.str_add_info));
                productPrice.setText("");
                productAlcoholContent.setText("");
            }
            else {
                productImage.setImageDrawable(mySelectedProduct.get_SweetenerProduct().getDrw_image());
                productName.setText(mySelectedProduct.get_SweetenerProduct().getStr_name());
                productBrand.setText(mySelectedProduct.get_SweetenerProduct().getStr_brand());
                productPrice.setText(context.getText(R.string.str_price) + " " + String.valueOf(mySelectedProduct.get_SweetenerProduct().getD_price()));
                productAlcoholContent.setText(context.getText(R.string.str_sugar_quantity) + " " + String.valueOf(mySelectedProduct.get_SweetenerQuantity()));



            }
        }
        if(position == 1)
        {
            if(mySelectedProduct.get_AlcoholProduct() == null)
            {
                // If user use any alcohol
                productImage.setImageDrawable(context.getDrawable(R.drawable.drawable_add));
                productName.setText(context.getText(R.string.str_add_alcohol));
                productBrand.setText(context.getText(R.string.str_add_info));
                productPrice.setText("");
                productAlcoholContent.setText("");
            }
            else{
                productImage.setImageDrawable(mySelectedProduct.get_AlcoholProduct().getDrw_image());
                productName.setText(mySelectedProduct.get_AlcoholProduct().getStr_name());
                productBrand.setText(mySelectedProduct.get_AlcoholProduct().getStr_brand());
                productPrice.setText(context.getText(R.string.str_price) + " " + String.valueOf(mySelectedProduct.get_AlcoholProduct().getD_price()));
                productAlcoholContent.setText(context.getText(R.string.str_alcohol_content) + " " + String.valueOf(mySelectedProduct.get_AlcoholProduct().getD_alcoholContent()));
            }
        }
        return view;
    }

}
