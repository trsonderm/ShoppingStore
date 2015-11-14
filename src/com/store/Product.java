package com.store;

import java.io.Serializable;

/**
 * Created by WPTRS on 11/4/2015.
 */
public class Product implements Serializable{
    int sku;
    String name;
    String description;
    double price;
    double cost;
    int quantity;
}
