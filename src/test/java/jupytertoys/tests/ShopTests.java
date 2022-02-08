package jupytertoys.tests;

import jupytertoys.components.Product;
import jupytertoys.pages.ShopPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ShopTests extends BaseTests {
    @Test
    public void testCase06() {
        ShopPage shopPage = homePage.clickShopPage();
        Product product = shopPage.getProduct(p -> p.getTitle().equals("Smiley Bear"));
        assertNotEquals(product, null);
        assertEquals(product.getPrice(), 13.99,
                "Invalid Smiley Bear price.");
    }

    @Test
    public void testCase07() {
        ShopPage shopPage = homePage.clickShopPage();
        Product product = shopPage.getProduct(p -> p.getPrice() == 9.99);
        assertNotEquals(product, null);
        int before = shopPage.getNumberOfItemsInCart();
        product.buyProduct();
        assertEquals(shopPage.getNumberOfItemsInCart(), before + 1,
                "Incorrect number of items in cart.");
    }

    @Test
    public void testCase09() {
        ShopPage shopPage = homePage.clickShopPage();
        Product product = shopPage.getProduct(p -> p.getRating() == 5);
        assertNotEquals(product, null);
        int before = shopPage.getNumberOfItemsInCart();
        product.buyProduct();
        assertEquals(shopPage.getNumberOfItemsInCart(), before + 1,
                "Incorrect number of items in cart.");
    }
}
