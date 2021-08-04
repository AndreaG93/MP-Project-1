package Events;

import android.content.Context;
import android.view.View;

import Dialog.DialogBuilder;

/**
 * Created by Andrea Graziani on 03/12/2016.
 */

public class closing implements View.OnClickListener
{
    private Context context;

    public closing(Context arg0)
    {
        this.context = arg0;
    }

    @Override
    public void onClick(View view)
    {
        DialogBuilder.closingDialog(this.context).show();
    }


}
