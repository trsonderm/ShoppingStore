package com.store;

import java.io.*;
import java.util.List;

/**
 * Archive Interface to be called on buyer seller pages
 * @author Thomas Sonderman
 */
interface ArchiveAction {
    public void saveData();
    public void loadData();
    public void saveFinancials();
    public void loadFinancials();
}
/**
 * Archive class that implements Archive Action
 * @author Thomas Sonderman
 */
public class Archive implements ArchiveAction{
    private StoreInventory storeInventory;
    public Product[] recoveredCart;
    public double revenueRecovered;
    public double profitRecovered;
    public double costRecovered;
    public Archive()
    {
        this.storeInventory = StoreInventory.getInstance();

    }
    /**
     * saves data into the storeInventory object
     * @author Thomas Sonderman
     */

    @Override
    public void saveData()
    {

        Product[] sInventory = storeInventory.getProductListing();
        try{

            FileOutputStream fout = new FileOutputStream("cart.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(sInventory);
            oos.close();
            System.out.println("Done");

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void saveFinancials()
    {
        double revenueToSave = storeInventory.revenue;
        double profitToSave = storeInventory.profit;
        double costToSave = storeInventory.cost;
        try{

            FileOutputStream fout = new FileOutputStream("revenue.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(revenueToSave);
            oos.writeObject(profitToSave);
            oos.writeObject(costToSave);
            oos.close();
            System.out.println("Done");

        }catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    @Override
    public void loadFinancials()
    {
        ShoppingCart tempCart = ShoppingCart.getCart();

        try(
                InputStream file = new FileInputStream("revenue.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
        ){
            //deserialize the List
            revenueRecovered = (double)input.readObject();
            profitRecovered = (double)input.readObject();
            costRecovered = (double)input.readObject();
            //display its data

            storeInventory.revenue = revenueRecovered;
            storeInventory.profit = profitRecovered;
            storeInventory.cost = costRecovered;
        }
        catch(ClassNotFoundException ex){
            System.out.println("Cannot perform input. Class not found."+ ex);
        }
        catch(IOException ex){
            System.out.println("Cannot perform input."+ex);
        }


    }

    /**
     * loads saved data into the storeInventory object
     * @author Thomas Sonderman
     */
    @Override
    public void loadData(){
        ShoppingCart tempCart = ShoppingCart.getCart();

        try(
                InputStream file = new FileInputStream("cart.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
        ){
            //deserialize the List
            recoveredCart = (Product[])input.readObject();
            //display its data
            int skuCounter = 0;
            for(Product o: recoveredCart) {

                o.sku = skuCounter;
                storeInventory.addProduct(o,o.quantity);
                skuCounter++;
            }
        }
        catch(ClassNotFoundException ex){
            System.out.println("Cannot perform input. Class not found."+ ex);
        }
        catch(IOException ex){
            System.out.println("Cannot perform input."+ex);
        }
    };

}
