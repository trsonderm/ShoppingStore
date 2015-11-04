package com.store;

public class Sold extends ProductList{
    private static Sold instance = null;
    
    public static Sold getInstance() {
        if(instance == null) {
            instance = new Sold();
        }
        return instance;
    }
}
