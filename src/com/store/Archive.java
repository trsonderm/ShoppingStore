package com.store;

/**
 * Created by WPTRS on 11/4/2015.
 */
interface ArchiveAction {
    public void saveData();
    public void loadData();
}
public class Archive implements ArchiveAction{
    public void saveData()
    {
        ShoppingCart tempCart = ShoppingCart.getCart();

    };
    public void loadData(){
        ShoppingCart tempCart = ShoppingCart.getCart();
    };

}
