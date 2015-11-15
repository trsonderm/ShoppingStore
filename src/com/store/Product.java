package com.store;

import java.io.Serializable;

/**
 * Created by WPTRS on 11/4/2015.
 */
public class Product implements Serializable{
    public int sku;
    public String name;
    public String description;
    public double price;
    public double cost;
    public int quantity;
}
