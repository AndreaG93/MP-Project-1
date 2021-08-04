package Events;

import android.content.DialogInterface;

import com.example.andreagraziani.myapplication.Activity_ProductSelector;

import SelectedProduct.SelectedProduct;

/**
 * Created by Andrea Graziani on 03/12/2016.
 */

public class OnclickListener_UpdateSelectorProduct implements DialogInterface.OnClickListener
{
    private Activity_ProductSelector myActivity;

    /**
     * Constructs a newly allocated "Event_OnClickListenerOrderByDialog"
     * @param arg0 - Represents the "Activity1" object.
     */
    public OnclickListener_UpdateSelectorProduct(Activity_ProductSelector arg0)
    {
        this.myActivity = arg0;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i)
    {
        myActivity.init();
        dialogInterface.dismiss();
    }
}
