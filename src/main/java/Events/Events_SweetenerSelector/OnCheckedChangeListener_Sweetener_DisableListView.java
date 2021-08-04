package Events.Events_SweetenerSelector;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

import SelectedProduct.SelectedProduct;

/**
 * This class is used when user don't want alcohol and disable list view if user don't want alcohol or sugar.
 * @version 1.0
 * @author Andrea Graziani
 */
public class OnCheckedChangeListener_Sweetener_DisableListView implements CompoundButton.OnCheckedChangeListener
{
    private ListView target;
    private RelativeLayout target2;

    public OnCheckedChangeListener_Sweetener_DisableListView(ListView arg0, RelativeLayout arg1)
    {
        this.target = arg0;
        this.target2 = arg1;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked)
    {
        if(checked)
        {
            target.setEnabled(false);
            target.setVisibility(View.GONE);
            target2.setVisibility(View.GONE);
            SelectedProduct.getInstance().set_SweetenerProduct(null);
            SelectedProduct.getInstance().set_SweetenerQuantity(0);
        }
        else {
            target.setEnabled(true);
            target.setVisibility(View.VISIBLE);
            target2.setVisibility(View.VISIBLE);
            SelectedProduct.getInstance().set_SweetenerQuantity(3);
        }
    }
}
