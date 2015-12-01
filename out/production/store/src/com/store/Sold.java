package com.store;

/**
 * Sold Class of ProductList
 *
 * Singleton Pattern
 */
public class Sold extends ProductList{
    private static Sold instance = null;
    
    public static Sold getInstance() {
        if(instance == null) {
            instance = new Sold();
        }
        return instance;
    }
}
