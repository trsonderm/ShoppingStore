package com.store;

/**
 * Created by WPTRS on 11/4/2015.
 */


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ProductList {
    private ArrayList<Map<String, Object>> items;
    public ArrayList<Map<String, Object>> productsToLoad;

    int currentIteratorID;

    protected ProductList() {

        items = new ArrayList<>();
        resetIterator();
    }

    public void resetItems() {
        items.removeAll(items);
    }

    private int getNewProductID() {
        int newItemID = -1;
        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> tempItemsItem = items.get(i);
            Product tempProduct = (Product)tempItemsItem.get("item");
            if (tempProduct.sku > newItemID)
                newItemID = tempProduct.sku;
        }
        newItemID++;
        return newItemID;
    }

    public void addItem(Product itemToAdd, int quantityToAdd) {
      if (itemToAdd.sku == -1)
      {
        int newID = getNewProductID();
        itemToAdd.sku = newID;
      }
        Map<String, Object> newItem = new HashMap<>();
        newItem.put("ID", itemToAdd.sku);
        newItem.put("item", itemToAdd);
        newItem.put("quantity", quantityToAdd);
        items.add(newItem);
        //Item added
    }

    public void removeItem(int itemID) {
        int index = getIndexForProduct(itemID);
        items.remove(index);
    }

    public int getCount() {
        int count = 0;
        for (int i = 0; i < items.size(); i ++) {
            Map<String, Object> tempItemsItem = items.get(i);
            Product tempItem = (Product)tempItemsItem.get("item");
            int quantity = (int)tempItemsItem.get("quantity");
            count += quantity;
        }
        return count;
    }

    public int getQuantity(int itemIDtoFind) {
        int quantity = 0;
        for (int i = 0; i < items.size(); i ++) {
            Map<String, Object> tempItemsItem = items.get(i);
            Product tempItem = (Product)tempItemsItem.get("item");
            int tempItemID = (int)tempItem.sku;
            if (tempItemID == itemIDtoFind) {
                quantity = (int)tempItemsItem.get("quantity");
                i = items.size();
            }
        }
        return quantity;
    }

    private int getIndexForProduct(int productIDtoFind) {
        int indexToReturn = -1;
        for (int i = 0; i < items.size(); i ++) {
            Map<String, Object> tempCartProduct = items.get(i);
            Product tempProduct = (Product)tempCartProduct.get("item");
            int productID = (int)tempProduct.sku;
            if (productIDtoFind == productID) {
                indexToReturn = i;
                i = items.size();
            }
        }
        return indexToReturn;
    }

    public void decrement(int itemIDtoDecrement, int quantityToDecrementBy) {
        int index = getIndexForProduct(itemIDtoDecrement);
        if (index > -1) {
            Map<String, Object> tempCartItem = items.get(index);
            Product tempItem = (Product)tempCartItem.get("item");
            int quantity = (int)tempCartItem.get("quantity");
            if (quantity - quantityToDecrementBy <= 0) {
                quantity = 0;
                tempCartItem.put("quantity", quantity);
                items.set(index, tempCartItem);
            }
            else {
                quantity -= quantityToDecrementBy;
                tempCartItem.put("quantity", quantity);
                items.set(index, tempCartItem);
            }
        }
    }

    public void increment(int itemIDtoIncrement, int quantityToIncrementBy) {
        int index = getIndexForProduct(itemIDtoIncrement);
        if (index > -1) {
            Map<String, Object> tempCartItem = items.get(index);
            int quantity = (int)tempCartItem.get("quantity");
            quantity += quantityToIncrementBy;
            tempCartItem.put("quantity", quantity);
            items.set(index, tempCartItem);
        }
    }

    public Product getProductByID (int itemID) {
        Product itemToReturn = new Product();
        for (int i = 0; i < items.size(); i ++) {
            Map<String, Object> inventoryItem = items.get(i);
            Product tempItem = (Product)inventoryItem.get("item");
            int tempItemID = (int)tempItem.sku;
            if (tempItemID == itemID) {
                itemToReturn = tempItem;
                i = items.size();
            }
        }
     
        return itemToReturn;
    }

    public int getProductID (int index) {
        int itemID = 0;
        Map<String, Object> tempItemsItem = items.get(index);
        Product tempItem = (Product)tempItemsItem.get("item");
        itemID = (int)tempItem.sku;
        return itemID;
    }

    public Object[][] getListing() {
        Object[][] arrayToReturn = new Object[items.size()][5];

        int currentRow = 0;
        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> tempCartItem = items.get(i);
            Product tempItem = (Product)tempCartItem.get("item");
            int quantity = (int)tempCartItem.get("quantity");

            int itemID = tempItem.sku;
            String title = tempItem.name;
            double price = tempItem.price;
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

    public Product[] getProductListing() {
        Product[] arrayToReturn = new Product[items.size()];
        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> tempCartItem = items.get(i);
            Product tempItem = (Product)tempCartItem.get("item");
            int quantity = (int)tempCartItem.get("quantity");
            //Product tempProduct = new Product();
           arrayToReturn[i] = tempItem;
        }
        return arrayToReturn;
    }

    public void setListing(Object[][] aTempArray) {
       for(Object o: aTempArray)
       {
           System.out.println(o);
       }
    }

    public double getCostTotal() {
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> tempCartItem = items.get(i);
            Product tempItem = (Product)tempCartItem.get("item");

            int quantity = (int)tempCartItem.get("quantity");
            double cost = tempItem.cost;
            double subtotal = cost * quantity;

            total += subtotal;
        }
        return total;
    }

    public double getPriceTotal() {
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            Map<String, Object> tempCartItem = items.get(i);
            Product tempItem = (Product)tempCartItem.get("item");

            int quantity = (int)tempCartItem.get("quantity");
            double price = tempItem.price;
            double subtotal = price * quantity;

            total += subtotal;
        }
        return total;
    }

    public boolean hasNext() {
        boolean hasNext = false;
        if (currentIteratorID < items.size() - 1)
            hasNext = true;
        return hasNext;
    }

    public boolean hasPrevious() {
        boolean hasPrevious = false;
        if (currentIteratorID > 0)
            hasPrevious = true;
        return hasPrevious;
    }

    public Map<String, Object> getNext() {
        Map<String, Object> item = new HashMap();
        if (hasNext()) {
            currentIteratorID++;
            item = items.get(currentIteratorID);
        }
        return item;
    }

    public Map<String, Object> getPrevious() {
        Map<String, Object> item = new HashMap();
        if (hasPrevious()) {
            currentIteratorID--;
            item = items.get(currentIteratorID);
        }
        return item;
    }

    public int getIteratorCount() {
        return items.size();
    }

    public void resetIterator() {
        currentIteratorID = -1;
    }
}
