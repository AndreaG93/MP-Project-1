package Product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import java.util.Locale;
import java.util.Vector;

/**
 * This class is used to design "Product"'s database. This is class is designed using "Singleton" pattern.
 *
 * @version 1.3
 * @author Andrea Graziani
 * @see Product
 * @see ProductImageMap
 */
public class ProductDatabaseHelper extends SQLiteOpenHelper
{
    private static ProductDatabaseHelper myInstance = null;
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "PRODUCTS";
    private static final String COLUMN_PRODUCT_NAME = "NAME";
    private static final String COLUMN_PRODUCT_BRAND = "BRAND";
    private static final String COLUMN_PRODUCT_TYPE = "TYPE";
    private static final String COLUMN_PRODUCT_PRICE = "PRICE";
    private static final String COLUMN_PRODUCT_ALCOHOL_CONTENT = "ALCOHOL_CONTENT";

    /**
     * This method is used to get an instance of 'ProductDatabaseHelper' class.
     *
     * @param arg0 Represents a "Context" object.
     * @return A "ProductDatabaseHelper" object
     */
    public static ProductDatabaseHelper getIstance(Context arg0)
    {
        if(myInstance == null) myInstance = new ProductDatabaseHelper(arg0);
        return myInstance;
    }

    /**
     * Constructs a newly allocated "ProductDatabaseHelper".
     *
     * @param arg0 - Represents context.
     * @see #getProductDatabaseName()
     */
    private ProductDatabaseHelper(@NonNull Context arg0)
    {
        super(arg0, getProductDatabaseName(), null, DATABASE_VERSION);
    }

    /**
     * Get database's filename according to locale.
     *
     * @return Filename of database.
     */
    private static String getProductDatabaseName()
    {
        if (Locale.ITALY == Locale.getDefault()) return "ITA_PRODUCT_DB.db";
        else return "EN_PRODUCT_DB.db";
    }

    /**
     * This method is called when the database is created for the first time.
     *
     * @param arg0 - Represents a "SQLiteDatabase" object.
     */
    @Override
    public void onCreate(SQLiteDatabase arg0)
    {
        String CREATE_DRINK_TABLE = "CREATE TABLE "+ TABLE_NAME +
                " ( " +
                COLUMN_PRODUCT_NAME            + " VARCHAR(30)      NOT NULL, " +
                COLUMN_PRODUCT_BRAND           + " VARCHAR(30)      NOT NULL, " +
                COLUMN_PRODUCT_TYPE            + " VARCHAR(30)      NOT NULL, " +
                COLUMN_PRODUCT_PRICE           + " DOUBLE PRECISION NOT NULL, " +
                COLUMN_PRODUCT_ALCOHOL_CONTENT + " DOUBLE PRECISION NOT NULL  " +
                " ) ";
        arg0.execSQL(CREATE_DRINK_TABLE);
    }

    /**
     * Called in the event that the application code contains a more recent database version number reference.
     *
     * @param arg0 - Represents a "SQLiteDatabase" object.
     * @param oldVersion - Represent old version of database.
     * @param newVersion - Represent new version of database.
     */
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
        arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(arg0);
    }

    /**
     * This method is used to add a new record to database.
     *
     * @param arg0 Represents a "SQLiteDatabase" object.
     * @param arg1 Represents product's name.
     * @param arg2 Represents product's brand.
     * @param arg3 Represents product's type.
     * @param arg4 Represents product's price.
     * @param arg5 Represents product's alcohol content.
     */
    public void addProduct(SQLiteDatabase arg0, String arg1, String arg2, String arg3, double arg4, double arg5)
    {
        arg0.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, arg1);
        values.put(COLUMN_PRODUCT_BRAND, arg2);
        values.put(COLUMN_PRODUCT_TYPE, arg3);
        values.put(COLUMN_PRODUCT_PRICE, arg4);
        values.put(COLUMN_PRODUCT_ALCOHOL_CONTENT, arg5);

        arg0.insert(TABLE_NAME, null, values);
    }

    /**
     * This method return all "Product" object from a specified "Cursor" object.
     *
     * @param arg0 Represents a "Cursor" object.
     * @return A "Vector<Product>" object.
     * @see ProductImageMap
     */
    private static Vector<Product> getProductVectorFromDB(Cursor arg0)
    {
        Vector<Product> myVector = new Vector<Product>();

        // Places the "read position" on the first entry in the results
        arg0.moveToFirst();

        for(int i = 0; i < arg0.getCount(); i++)
        {
            Product elem = new Product(
                    arg0.getString(0),
                    arg0.getString(1),
                    arg0.getString(2),
                    ProductImageMap.getImage(arg0.getString(0)),
                    arg0.getDouble(3),
                    arg0.getDouble(4)
                    );
            myVector.add(elem);
            arg0.moveToNext();
        }
        return myVector;
    }

    /**
     * This method is used to perform a query to database.
     *
     * @param arg0 Represents an "SQLiteDatabase" object.
     * @param productType Represents product's type.
     * @param productName Represents product's name.
     * @param sortBy Represents a sort option.
     * @param ascendentOrder Represents a sort option.
     * @return A "Vector<Product>" object.
     */
    public Vector<Product> getProductVectorByQuery(SQLiteDatabase arg0, String productType, String productName, char sortBy, boolean ascendentOrder)
    {
        String SQL_ORDER_BY = " ORDER BY ";
        String SQL_ASC_DESC = "";

        // Select all specified type of product
        String SQL_TYPE = " SELECT *" +
                " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_PRODUCT_TYPE + " = "  + "'"+ productType +"'";

        // Select all specified type of product
        String SQL_NAME = " SELECT *" +
                " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_PRODUCT_NAME + " LIKE "  + "'"+ productName +"'";


        // Select order
        if(ascendentOrder) {SQL_ASC_DESC = " ASC ";}
        else SQL_ASC_DESC = " DESC ";

        if(sortBy == 'n') {SQL_ORDER_BY += COLUMN_PRODUCT_NAME;}
        if(sortBy == 'p') {SQL_ORDER_BY += COLUMN_PRODUCT_PRICE;}
        if(sortBy == 'a') {SQL_ORDER_BY += COLUMN_PRODUCT_ALCOHOL_CONTENT;}

        // Do query
        String query = SQL_TYPE + " INTERSECT " + SQL_NAME + SQL_ORDER_BY + SQL_ASC_DESC;

        return getProductVectorFromDB(arg0.rawQuery(query, null));
    }


}
