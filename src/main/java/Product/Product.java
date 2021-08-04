package Product;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * This class represents a generic product.
 *
 * @author Andrea Grazianj
 * @version 1.3
 */
public class Product
{
    private String str_name;
    private String str_brand;
    private String str_type;
    private Drawable drw_image;
    private double d_price;
    private double d_alcoholContent;

    /**
     * Constructs a newly allocated "Product" object.
     *
     * @param arg0 Represents product's name.
     * @param arg1 Represents product's brand.
     * @param arg2 Represents product's type
     * @param arg3 This is a representative image of product.
     * @param arg4 Represents product's price
     * @param arg5 Represents product's alcohol content.
     */
    public Product(@NonNull String arg0, @NonNull String arg1, @NonNull String arg2, Drawable arg3, double arg4, double arg5) {
        this.str_name = arg0;
        this.str_brand = arg1;
        this.str_type = arg2;
        this.drw_image = arg3;
        this.d_price = arg4;
        this.d_alcoholContent = arg5;
    }

    // Getter methods

    public String getStr_name() {
        return str_name;
    }

    public String getStr_brand() {
        return str_brand;
    }

    public String getStr_type() {
        return str_type;
    }

    public Drawable getDrw_image() {
        return drw_image;
    }

    public double getD_price() {
        return d_price;
    }

    public double getD_alcoholContent() {
        return d_alcoholContent;
    }
}
