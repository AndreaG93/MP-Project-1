package Product;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.andreagraziani.myapplication.R;

/**
 * This class is used to populate databases.
 */
public class AddProductToDatabase
{
    static public void insertProductIntoDB(@NonNull SQLiteDatabase arg0, @NonNull ProductDatabaseHelper arg1, @NonNull Context context)
    {
        // *****************************************************************************************
        // Add drinks to database.

        // Espresso
        arg1.addProduct(arg0, context.getString(R.string.str_espresso), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.5, 0);
        ProductImageMap.addImage(context.getString(R.string.str_espresso), context.getDrawable(R.drawable.ic_drawable_coffee));

        // Macchiato
        arg1.addProduct(arg0, context.getString(R.string.str_macchiato), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.6, 0);
        ProductImageMap.addImage(context.getString(R.string.str_macchiato), context.getDrawable(R.drawable.ic_drawable_coffee));

        // Decaffeinated coffee
        arg1.addProduct(arg0, context.getString(R.string.str_decaffeinated_coffee), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.4, 0);
        ProductImageMap.addImage(context.getString(R.string.str_decaffeinated_coffee), context.getDrawable(R.drawable.ic_drawable_coffee));

        // Ginseng coffee
        arg1.addProduct(arg0, context.getString(R.string.str_ginseng_coffee), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.75, 0);
        ProductImageMap.addImage(context.getString(R.string.str_ginseng_coffee), context.getDrawable(R.drawable.ic_drawable_coffee));

        // Barley coffee
        arg1.addProduct(arg0, context.getString(R.string.str_barley_coffee), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.5, 0);
        ProductImageMap.addImage(context.getString(R.string.str_barley_coffee), context.getDrawable(R.drawable.ic_drawable_coffee));

        // Cappuccino
        arg1.addProduct(arg0, context.getString(R.string.str_cappuccino), context.getString(R.string.str_graziani_store),  context.getString(R.string.str_drink), 0.5, 0);
        ProductImageMap.addImage(context.getString(R.string.str_cappuccino), context.getDrawable(R.drawable.ic_drawable_coffee));

        // Milk
        arg1.addProduct(arg0, context.getString(R.string.str_milk), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.4, 0);
        ProductImageMap.addImage(context.getString(R.string.str_milk), context.getDrawable(R.drawable.ic_drawable_milk_2));

        // Chocolate
        arg1.addProduct(arg0, context.getString(R.string.str_chocolate), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.6, 0);
        ProductImageMap.addImage(context.getString(R.string.str_chocolate), context.getDrawable(R.drawable.ic_drawable_cappuccino));

        // Tea
        arg1.addProduct(arg0, context.getString(R.string.str_tea), context.getString(R.string.str_graziani_store), context.getString(R.string.str_drink), 0.6,0);
        ProductImageMap.addImage(context.getString(R.string.str_tea), context.getDrawable(R.drawable.ic_drawable_tea));


        // *****************************************************************************************
        // Add sweetener to database.

        // Sugar
        arg1.addProduct(arg0, context.getString(R.string.str_sugar), context.getString(R.string.str_zuccheri_cinti), context.getString(R.string.str_Sweetener), 0.15, 0);
        ProductImageMap.addImage(context.getString(R.string.str_sugar), context.getDrawable(R.drawable.ic_drawable_sugar));

        // Brown sugar
        arg1.addProduct(arg0, context.getString(R.string.str_brown_sugar), context.getString(R.string.str_zuccheri_cinti), context.getString(R.string.str_Sweetener), 0.20, 0);
        ProductImageMap.addImage(context.getString(R.string.str_brown_sugar), context.getDrawable(R.drawable.ic_drawable_sugar));

        // Fructose
        arg1.addProduct(arg0, context.getString(R.string.str_fructose), context.getString(R.string.str_zuccheri_cinti), context.getString(R.string.str_Sweetener), 0.25, 0);
        ProductImageMap.addImage(context.getString(R.string.str_fructose), context.getDrawable(R.drawable.ic_drawable_sugar));

        // *****************************************************************************************
        // Add alcohol to database.

        // Wine
        arg1.addProduct(arg0, context.getString(R.string.str_wine), context.getString(R.string.str_graziani_store), context.getString(R.string.str_alcohol), 3.50, 17);
        ProductImageMap.addImage(context.getString(R.string.str_wine), context.getDrawable(R.drawable.ic_drawable_wine));

        // Beer
        arg1.addProduct(arg0, context.getString(R.string.str_beer), context.getString(R.string.str_graziani_store), context.getString(R.string.str_alcohol), 4.50, 8);
        ProductImageMap.addImage(context.getString(R.string.str_beer), context.getDrawable(R.drawable.ic_drawable_beer));

        // Grappa
        arg1.addProduct(arg0, context.getString(R.string.str_grappa), context.getString(R.string.str_graziani_store), context.getString(R.string.str_alcohol), 5.45, 47);
        ProductImageMap.addImage(context.getString(R.string.str_grappa), context.getDrawable(R.drawable.ic_drawable_brandy));

        // Brandy
        arg1.addProduct(arg0, context.getString(R.string.str_brandy), context.getString(R.string.str_graziani_store), context.getString(R.string.str_alcohol), 6.50, 50);
        ProductImageMap.addImage(context.getString(R.string.str_brandy), context.getDrawable(R.drawable.ic_drawable_brandy));

    }
}
