package Product;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.Vector;

/**
 * This class is used to access to "Product"'s database. This is class is designed using "Singleton" pattern.
 *
 * @version 1.3
 * @author Andrea Graziani
 * @see Product
 * @see ProductImageMap
 * @see ProductDatabaseHelper
 * @see AddProductToDatabase
 */
public class ProductDatabaseSQL
{
    private static ProductDatabaseSQL myInstance = null;
    private ProductDatabaseHelper myProductDatabaseHelper;
    private SQLiteDatabase myDB;

    /**
     * Constructs a newly allocated "ProductDatabaseSQL" object.
     *
     * @param arg0 Represents a "Context" object.
     */
    private ProductDatabaseSQL(Context arg0)
    {
        this.myProductDatabaseHelper = ProductDatabaseHelper.getIstance(arg0);
        this.myDB = myProductDatabaseHelper.getWritableDatabase();
        AddProductToDatabase.insertProductIntoDB(myDB, myProductDatabaseHelper, arg0);
    }

    /**
     * This method is used to get an instance of 'ProductDatabaseSQL' class.
     *
     * @param arg0 Represents a "Context" object.
     * @return A "ProductDatabaseSQL" object
     */
    public static ProductDatabaseSQL getInstance(Context arg0)
    {
        if(myInstance == null) myInstance = new ProductDatabaseSQL(arg0);
        return myInstance;
    }

    /**
     * This method is used to get a vector of object from database.
     *
     * @param arg0 Represents product's type.
     * @param arg1 Represents product's name.
     * @param arg2 Represents a sort option.
     * @param arg3 Represents a sort option.
     * @return A "Vector<Product>" object.
     * @see ProductDatabaseSQL#getVector(String, String, char, boolean)
     */
    public Vector<Product> getVector(String arg0, String arg1, char arg2, boolean arg3)
    {
        return this.myProductDatabaseHelper.getProductVectorByQuery(this.myDB, arg0, arg1, arg2, arg3);
    }
}
