package com.store;

import java.io.*;
import java.util.List;

/**
 * Created by WPTRS on 11/4/2015.
 */
interface ArchiveAction {
    public void saveData();
    public void loadData();
}
public class Archive implements ArchiveAction{
    private StoreInventory storeInventory;
    public Product[] recoveredCart;
    public Archive()
    {
        this.storeInventory = StoreInventory.getInstance();

    }

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
            for(Product o: recoveredCart) {


                storeInventory.addItem(o,o.quantity);

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
