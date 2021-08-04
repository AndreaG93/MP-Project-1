package SelectedProduct;

import Product.Product;

/**
 * This class is used to store selected products by user. This is class is designed using "Singleton" pattern.
 *
 * @version 1.0
 * @author Andrea Graziani
 */
public class SelectedProduct
{
    private Product mainProduct;
    private Product sweetenerProduct;
    private Product alcoholProduct;
    private int sweetenerQuantity;
    private static SelectedProduct myIstance = null;
    private char sortBy;
    private boolean ascendentOrder;

    /**
     * This method is used to get an instance of "SelectedProduct" class.
     *
     * @return A "SelectedProduct" object
     */
    public static SelectedProduct getInstance()
    {
        if (myIstance == null) myIstance = new SelectedProduct();
        return myIstance;
    }

    /**
     * Constructs a newly allocated "SelectedProduct" object.
     */
    private SelectedProduct()
    {
        this.sweetenerQuantity = 0;
        this.sortBy = 'n';
        this.ascendentOrder = true;
    }

    //**********************************************************************************************
    // Getter and setter method

    public int get_SweetenerQuantity() {return this.sweetenerQuantity;}
    public Product get_AlcoholProduct() {return alcoholProduct;}
    public Product get_MainProduct() {return mainProduct;}
    public Product get_SweetenerProduct() {return sweetenerProduct;}

    public void set_SweetenerQuantity(int sweetenerQuantity) {this.sweetenerQuantity = sweetenerQuantity;}
    public void set_AlcoholProduct(Product alcoholProduct) {this.alcoholProduct = alcoholProduct;}
    public void set_SweetenerProduct(Product sweetenerProduct) {this.sweetenerProduct = sweetenerProduct;}
    public void set_MainProduct(Product mainProduct) {this.mainProduct = mainProduct;}

    public char getSortBy() {return sortBy;}
    public void setSortBy(char sortBy) {this.sortBy = sortBy;}
    public boolean isAscendentOrder() {return ascendentOrder;}
    public void setAscendentOrder(boolean ascendentOrder) {this.ascendentOrder = ascendentOrder;}
}
