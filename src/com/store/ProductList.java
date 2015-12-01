package com.store;

/**
 * Created by WPTRS on 11/4/2015.
 */


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ProductList Class controls adding removing
 * @author Thomas Sonderman
 */
public class ProductList {
    private ArrayList<Map<String, Object>> products;
    public ArrayList<Map<String, Object>> productsToLoad;

    int currentIteratorID;

    protected ProductList() {

        products = new ArrayList<>();
        resetIterator();
    }

    public void resetItems() {
        products.removeAll(products);
    }
    /**
     * method that get a new ID for product
     * @return int
     */
    private int getNewProductID() {
        int newItemID = -1;
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> tempItemsItem = products.get(i);
            Product tempProduct = (Product)tempItemsItem.get("item");
            if (tempProduct.sku > newItemID)
                newItemID = tempProduct.sku;
        }
        newItemID++;
        return newItemID;
    }
    /**
     * method that adds a product
     * @param productToAdd, quantityToAdd
     *
     */
    public void addProduct(Product productToAdd, int quantityToAdd) {
      if (productToAdd.sku == -1)
      {
        int newID = getNewProductID();
          productToAdd.sku = newID;
      }
        Map<String, Object> newItem = new HashMap<>();
        newItem.put("ID", productToAdd.sku);
        newItem.put("item", productToAdd);
        newItem.put("quantity", quantityToAdd);
        products.add(newItem);
        //Item added
    }
    /**
     * method that removes a product
     * @param productID
     * @PreCondition Product exists
     */
    public void removeProduct(int productID) {
        int index = getIndexForProduct(productID);
        products.remove(index);
    }
    /**
     * method that returns number of products
     * @return number of products
     */
    public int getCount() {
        int count = 0;
        for (int i = 0; i < products.size(); i ++) {
            Map<String, Object> tempItemsItem = products.get(i);
            Product tempItem = (Product)tempItemsItem.get("item");
            int quantity = (int)tempItemsItem.get("quantity");
            count += quantity;
        }
        return count;
    }
    /**
     * method that returns number of products
     * @param productID
     * @return number of products
     */
    public int retrieveQuantity(int productID) {
        int quantity = 0;
        for (int i = 0; i < products.size(); i ++) {
            Map<String, Object> tempItemsItem = products.get(i);
            Product tempProduct = (Product)tempItemsItem.get("item");
            int tempProductID = (int)tempProduct.sku;
            if (tempProductID == productID) {
                quantity = (int)tempItemsItem.get("quantity");
                i = products.size();
            }
        }
        return quantity;
    }
    /**
     * method that returns index of products
     * @param productIDtoFind
     * @return index by int
     */
    private int getIndexForProduct(int productIDtoFind) {
        int indexToReturn = -1;
        for (int i = 0; i < products.size(); i ++) {
            Map<String, Object> tempCartProduct = products.get(i);
            Product tempProduct = (Product)tempCartProduct.get("item");
            int productID = (int)tempProduct.sku;
            if (productIDtoFind == productID) {
                indexToReturn = i;
                i = products.size();
            }
        }
        return indexToReturn;
    }
    /**
     * method that decrements for new product
     * @param pId, quantityToDecrememntBy
     * @PreCondition Product exists to decrement
     */
    public void decrement(int pId, int quantityToDecrementBy) {
        int index = getIndexForProduct(pId);
        if (index > -1) {
            Map<String, Object> tempCartProduct = products.get(index);
            Product tempItem = (Product)tempCartProduct.get("item");
            int quantity = (int)tempCartProduct.get("quantity");
            if (quantity - quantityToDecrementBy <= 0) {
                quantity = 0;
                tempCartProduct.put("quantity", quantity);
                products.set(index, tempCartProduct);
            }
            else {
                tempItem.quantity -= quantityToDecrementBy;
                quantity -= quantityToDecrementBy;
                tempCartProduct.put("quantity", quantity);
                products.set(index, tempCartProduct);
            }
        }
    }
    /**
     * method that increments for new product
     * @param pId, quantityToIncrememntBy
     * @PreCondition Product exists to increment
     */
    public void increment(int pId, int quantityToIncrementBy) {
        int index = getIndexForProduct(pId);
        if (index > -1) {
            Map<String, Object> tempCartItem = products.get(index);
            int quantity = (int)tempCartItem.get("quantity");
            quantity += quantityToIncrementBy;
            tempCartItem.put("quantity", quantity);
            products.set(index, tempCartItem);
        }
    }
    /**
     * method that returns product by passed in ID
     * @param pID
     * @return product object
     */
    public Product getProductByID (int pID) {
        Product itemToReturn = new Product();
        for (int i = 0; i < products.size(); i ++) {
            Map<String, Object> inventoryItem = products.get(i);
            Product tempProduct = (Product)inventoryItem.get("item");
            int tpID = (int)tempProduct.sku;
            if (tpID == pID) {
                itemToReturn = tempProduct;
                i = products.size();
            }
        }
     
        return itemToReturn;
    }
    /**
     * method that takes in int for index and return product ID at that address
     * @param aIndex
     * @return pID
     */
    public int getProductID (int aIndex) {
        int pID = 0;
        Map<String, Object> tempProductsproduct = products.get(aIndex);
        Product tempProduct = (Product)tempProductsproduct.get("item");
        pID = (int)tempProduct.sku;
        return pID;
    }
    /**
     * method that returns list of products
     * @return object array of listings
     */
    public Object[][] getListing() {
        Object[][] arrayToReturn = new Object[products.size()][5];

        int currentRow = 0;

        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> tempCartItem = products.get(i);
            Product tempProduct = (Product)tempCartItem.get("item");
            int quantity = (int)tempCartItem.get("quantity");

            int itemID = tempProduct.sku;
            String title = tempProduct.name;
            double price = tempProduct.price;
            double subtotal = price * quantity;

            DecimalFormat df2 = new DecimalFormat( "#.00" );
            String[] row = new String[5];
            row[0] = ((Integer)itemID).toString();
            row[1] = title;
            row[2] = "$" + df2.format(price);
            row[3] = ((Integer)quantity).toString();
            row[4] = "$" + df2.format(subtotal);
            arrayToReturn[currentRow] = row;
            currentRow++;
        }
        return arrayToReturn;
    }
    /**
     * method that returns all products
     * @return array of products
     */
    public Product[] getProductListing() {
        Product[] arrayToReturn = new Product[products.size()];
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> tempCartProduct = products.get(i);
            Product tempItem = (Product)tempCartProduct.get("item");
            int quantity = (int)tempCartProduct.get("quantity");
           arrayToReturn[i] = tempItem;
        }
        return arrayToReturn;
    }
    /**
     * method for debug prints listing
     * @param aTempArray
     */
    public void setListing(Object[][] aTempArray) {
       for(Object o: aTempArray)
       {
           System.out.println(o);
       }
    }
    /**
     * method that returns total cost of shopping cart
     * @return Total Cost
     */
    public double getCostTotal() {
        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> tempCartProduct = products.get(i);
            Product tempItem = (Product)tempCartProduct.get("item");

            int quantity = (int)tempCartProduct.get("quantity");
            double cost = tempItem.cost;
            double subtotal = cost * quantity;

            total += subtotal;
        }
        return total;
    }
    /**
     * method that gets price total
     * @return total price
     */
    public double getPriceTotal() {
        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            Map<String, Object> tempCartItem = products.get(i);
            Product tempProduct = (Product)tempCartItem.get("item");

            int quantity = (int)tempCartItem.get("quantity");
            double price = tempProduct.price;
            double subtotal = price * quantity;

            total += subtotal;
        }
        return total;
    }
    /**
     * method that returns whether next product exists
     * @return true or false
     */
    public boolean hasNext() {
        boolean hasNext = false;
        if (currentIteratorID < products.size() - 1)
            hasNext = true;
        return hasNext;
    }
    /**
     * method that determines whether previous product exists
     * @return true or false
     */
    public boolean hasPrevious() {
        boolean hasPrevious = false;
        if (currentIteratorID > 0)
            hasPrevious = true;
        return hasPrevious;
    }
    /**
     * method to grab next item with iterator
     */
    public Map<String, Object> getNext() {
        Map<String, Object> item = new HashMap();
        if (hasNext()) {
            currentIteratorID++;
            item = products.get(currentIteratorID);
        }
        return item;
    }
    /**
     * method to grab previous item in lis
     */
    public Map<String, Object> getPrevious() {
        Map<String, Object> item = new HashMap();
        if (hasPrevious()) {
            currentIteratorID--;
            item = products.get(currentIteratorID);
        }
        return item;
    }
    /**
     * method that returns count of iterator
     * @return number of iterator
     */
    public int getIteratorCount() {
        return products.size();
    }

    public void resetIterator() {
        currentIteratorID = -1;
    }
}
