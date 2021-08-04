package Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.example.andreagraziani.myapplication.R;
import SelectedProduct.SelectedProduct;

/**
 * This class is used to build dialogs.
 *
 *  @author Andrea Graziani
 *  @version 0.8
 */
public class DialogBuilder
{
    /**
     * Constructs a "Order by" dialog.
     *
     * @param arg0 "Context" object.
     * @param arg1 "Activity1" object.
     * @return A "Dialog" object.
     */
    public static Dialog orderByDialog(Context arg0, DialogInterface.OnClickListener arg1)
    {
        // Constructs a new allocated "Builder" object
        AlertDialog.Builder builder = new AlertDialog.Builder(arg0);
        builder.setTitle(R.string.str_dialog_order_by);
        builder.setIcon(R.drawable.ic_cloud_black_24dp);
        builder.setCancelable(false);

        CharSequence[] items = {arg0.getString(R.string.str_dialog_asc_choice), arg0.getString(R.string.str_dialog_des_choice)};

        int x;
        if(SelectedProduct.getInstance().isAscendentOrder()) x = 0;
        else x = 1;

        builder.setSingleChoiceItems(items, x, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SelectedProduct userChoice = SelectedProduct.getInstance();

                if (i == 0)
                {
                    userChoice.setAscendentOrder(true);
                }
                if (i == 1)
                {
                    userChoice.setAscendentOrder(false);
                }
            }
        });

        // Setting ok button...
        builder.setPositiveButton(arg0.getString(R.string.str_ok), arg1);
        return builder.create();
    }

    /**
     * Constructs a "Sort by" dialog.
     *
     * @param arg0 "Context" object.
     * @param arg1 "Activity1" object.
     * @return A "Dialog" object.
     */
    public static Dialog sortByDialog(Context arg0, DialogInterface.OnClickListener arg1)
    {
        // Constructs a new allocated "Builder" object
        AlertDialog.Builder builder = new AlertDialog.Builder(arg0);
        builder.setTitle(R.string.str_dialog_sort_by);
        builder.setIcon(R.drawable.ic_cloud_black_24dp);
        builder.setCancelable(false);

        CharSequence[] items = {arg0.getString(R.string.str_dialog_name_choice), arg0.getString(R.string.str_dialog_price_choice)};

        int x;

        if(SelectedProduct.getInstance().getSortBy() == 'n') x = 0;
        else x = 1;

        builder.setSingleChoiceItems(items, x, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SelectedProduct userChoice = SelectedProduct.getInstance();

                if (i == 0)
                {
                    userChoice.setSortBy('n');
                }
                if (i == 1)
                {
                    userChoice.setSortBy('p');
                }
            }
        });

        // Setting ok button...
        builder.setPositiveButton(arg0.getString(R.string.str_ok), arg1);
        return builder.create();
    }

    /**
     * Constructs a "Closing" dialog. ?????
     *
     * @param arg0 "Context" object.
     * @return A "Dialog" object.
     */
    public static Dialog closingDialog(Context arg0)
    {
        // Constructs a new allocated "Builder" object
        AlertDialog.Builder builder = new AlertDialog.Builder(arg0);
        builder.setTitle(R.string.str_dialog_sort_by);
        builder.setCancelable(false);

        SelectedProduct mySelectedProducts = SelectedProduct.getInstance();

        String elem1 = mySelectedProducts.get_MainProduct().getStr_name();
        String elem2 = "";
        String elem3 = "";

        if(mySelectedProducts.get_SweetenerProduct() != null) elem2 = mySelectedProducts.get_SweetenerProduct().getStr_name();
        if(mySelectedProducts.get_AlcoholProduct() != null)  elem3 = mySelectedProducts.get_AlcoholProduct().getStr_name();

        builder.setMessage(arg0.getString(R.string.str_choice_you_chose) + "\n" + elem1 + "\n" + elem2 + "\n" + elem3 + "\n" + arg0.getString(R.string.Thank_you));

        builder.setPositiveButton(arg0.getString(R.string.EXIT), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        return builder.create();
    }




}
