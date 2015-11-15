package Tests;
import com.store.Product;
import com.store.ShoppingCart;
import com.store.Sold;
import com.store.StoreInventory;
import junit.framework.*;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
/**
 * Tests for the inventory portion
 */
public class UnitTests extends TestCase {
    private StoreInventory inventory;
    private ShoppingCart cart;




    @Test
    public void testAddProduct() {
        inventory = StoreInventory.getInstance();
        cart = ShoppingCart.getCart();
        Product test = new Product();
        test.sku = 0;
        test.cost = 5;
        test.name = "Chili";
        test.price = 6;
        test.description = "blah";
        inventory.addItem(test, 3);
        assertEquals(inventory.getProductID(0), test.sku);
    }
    @Test
    public void testGetNewProductId() {
        inventory = StoreInventory.getInstance();
        cart = ShoppingCart.getCart();
        Product test = new Product();
        test.sku = 1;
        test.cost = 5;
        test.name = "Beans";
        test.price = 6;
        test.description = "blah";
        inventory.addItem(test, 3);
        assertEquals(inventory.getCount(), 6);
    }
    @Test
    public void testGetQuantity() {
        inventory = StoreInventory.getInstance();
        cart = ShoppingCart.getCart();
        Product test = new Product();
        test.sku = 2;
        test.cost = 2;
        test.name = "Rice";
        test.price = 3;
        test.description = "blah";
        inventory.addItem(test, 22);
        assertEquals(inventory.getQuantity(2), 22);
    }
    @Test
    public void testRemove() {
        inventory = StoreInventory.getInstance();
        cart = ShoppingCart.getCart();
        Product test = new Product();
        test.sku = 3;
        test.cost = 2;
        test.name = "Plantains";
        test.price = 3;
        test.description = "blah blah";
        Integer count = inventory.getCount();
        inventory.addItem(test, 4);
        inventory.removeItem(3);
        assertEquals(inventory.getCount(), (int)count);
    }


}
