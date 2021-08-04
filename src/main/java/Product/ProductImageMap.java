package Product;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to store drawable object.
 * @author Andrea Graziani
 * @version 1.0
 */
public class ProductImageMap
{
    private static Map<String, Drawable> productImageMap = null;

    /**
     * Add a "Drawable" object into "productImageMap".
     * @param arg0 Represent a key.
     * @param arg1 Represent a "Drawable" object.
     */
    public static void addImage(@NonNull String arg0, @NonNull Drawable arg1)
    {
        if (productImageMap == null) productImageMap = new HashMap<String, Drawable>();
        productImageMap.put(arg0, arg1);
    }

    /**
     * Get a "Drawable" object from "productImageMap".
     * @param arg0 Represent a key.
     * @return A "Drawable" object.
     */
    public static Drawable getImage(@NonNull String arg0)
    {
        return productImageMap.get(arg0);
    }
}
