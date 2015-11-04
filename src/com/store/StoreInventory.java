package com.store;


public class StoreInventory extends ProductList {
    private static StoreInventory instance = null;
    //Singleton Patter
    public static StoreInventory getInstance() {
        if(instance == null) {
            instance = new StoreInventory();
        }
        return instance;
    }

}
