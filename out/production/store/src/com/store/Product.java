package com.store;

import java.io.Serializable;

/**
 * Product Class
 * @author Thomas Sonderman
 */
public class Product implements Serializable{
    public int sku;
    public String name;
    public String description;
    public double price;
    public double cost;
    public int quantity;
}
