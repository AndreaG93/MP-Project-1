package Events.Events_SweetenerSelector;

import android.view.View;
import android.widget.RadioButton;

import com.example.andreagraziani.myapplication.Activity_SweetenerSelector;

import SelectedProduct.SelectedProduct;

/**
 * Created by Andrea Graziani on 02/12/2016.
 */

public class OnClickListener_ModifySugarQuantity implements RadioButton.OnClickListener
{
    private Activity_SweetenerSelector var1;
    private RadioButton var2[];

    public OnClickListener_ModifySugarQuantity (Activity_SweetenerSelector arg0, RadioButton[] arg1 ) {
        this.var1 = arg0;
        this.var2 = arg1;
    }

    @Override
    public void onClick(View view)
    {
        SelectedProduct x = SelectedProduct.getInstance();

        if(view == var2[0]) x.set_SweetenerQuantity(1);
        if(view == var2[1]) x.set_SweetenerQuantity(2);
        if(view == var2[2]) x.set_SweetenerQuantity(3);
        if(view == var2[3]) x.set_SweetenerQuantity(4);
        if(view == var2[4]) x.set_SweetenerQuantity(5);

        var1.SugarEvent();
    }

}