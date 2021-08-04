package Events.Events_AlcoholSelector;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;

import SelectedProduct.SelectedProduct;

/**
 * This class is used when user don't want alcohol and disable list view if user don't want alcohol or sugar.
 * @version 1.0
 * @author Andrea Graziani
 */
public class OnCheckedChangeListener_Alcohol_DisableListView implements CompoundButton.OnCheckedChangeListener
{
    private ListView target;

    public OnCheckedChangeListener_Alcohol_DisableListView(ListView arg0) {this.target = arg0;}

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked)
    {
        if(checked)
        {
            target.setEnabled(false);
            target.setVisibility(View.GONE);
            SelectedProduct.getInstance().set_AlcoholProduct(null);
        }
        else {
            target.setEnabled(true);
            target.setVisibility(View.VISIBLE);
        }
    }
}
