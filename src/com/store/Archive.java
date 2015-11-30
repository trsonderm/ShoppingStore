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
}
/**
 * Archive class that implements Archive Action
 * @author Thomas Sonderman
 */
public class Archive implements ArchiveAction{
    private StoreInventory storeInventory;
    public Product[] recoveredCart;
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
