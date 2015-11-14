package com.store;

/**
 * Created by WPTRS on 11/4/2015.
 */

public class ShoppingCart extends ProductList{
    private static ShoppingCart shoppingCart = null;
    //Singleton Pattern

    //load from interface for serialization here
    public static ShoppingCart getCart() {
        if(shoppingCart == null) {
            shoppingCart = new ShoppingCart();

        }
        return shoppingCart;
    }
}
