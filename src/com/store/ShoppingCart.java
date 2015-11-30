package com.store;

/**
 * Shopping Cart
 *
 * Singleton Pattern
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
