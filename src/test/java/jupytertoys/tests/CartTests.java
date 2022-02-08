package jupytertoys.tests;

import jupytertoys.components.Product;
import jupytertoys.pages.CartPage;
import jupytertoys.pages.ShopPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class CartTests extends BaseTests {
    @Test
    public void testCase10() {
        ShopPage shopPage = homePage.clickShopPage();
        Product stuffedFrog = shopPage.getProduct(p -> p.getTitle().equals("Stuffed Frog"));
        assertNotNull(stuffedFrog, "Stuffed Frog not found on Shop Page!");
        Product fluffyBunny = shopPage.getProduct(p -> p.getTitle().equals("Fluffy Bunny"));
        assertNotNull(fluffyBunny, "Fluffy Bunny not found on Shop Page!");
        Product valentineBear = shopPage.getProduct(p -> p.getTitle().equals("Valentine Bear"));
        assertNotNull(valentineBear, "Valentine Bear not found on Shop Page!");
        stuffedFrog.buyProduct(2);
        fluffyBunny.buyProduct(5);
        valentineBear.buyProduct(3);
        CartPage cartPage = shopPage.clickCartPage();
        assertNotNull(cartPage.getCartItem(i -> i.getItem().equals("Stuffed Frog")),
                "Stuffed Frog not found in Cart!");
        assertNotNull(cartPage.getCartItem(i -> i.getItem().equals("Fluffy Bunny")),
                "Fluffy Bunny not found in Cart!");
        assertNotNull(cartPage.getCartItem(i -> i.getItem().equals("Valentine Bear")),
                "Valentine Bear not found in Cart!");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Stuffed Frog")).getQuantity(),
                2, "Invalid Stuffed Frog quantity.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Fluffy Bunny")).getQuantity(),
                5, "Invalid Fluffy Bunny quantity.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Valentine Bear")).getQuantity(),
                3, "Invalid Valentine Bear quantity.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Stuffed Frog")).getPrice(),
                10.99, "Invalid Stuffed Frog price.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Fluffy Bunny")).getPrice(),
                8.99, "Invalid Fluffy Bunny price.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Valentine Bear")).getPrice(),
                13.99, "Invalid Valentine Bear price.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Stuffed Frog")).getPrice() *
                        cartPage.getCartItem(i -> i.getItem().equals("Stuffed Frog")).getQuantity(),
                cartPage.getCartItem(i -> i.getItem().equals("Stuffed Frog")).getSubtotal(),
                "Invalid Stuffed Frog subtotal.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Fluffy Bunny")).getPrice() *
                        cartPage.getCartItem(i -> i.getItem().equals("Fluffy Bunny")).getQuantity(),
                cartPage.getCartItem(i -> i.getItem().equals("Fluffy Bunny")).getSubtotal(),
                "Invalid Fluffy Bunny subtotal.");
        assertEquals(cartPage.getCartItem(i -> i.getItem().equals("Valentine Bear")).getPrice() *
                        cartPage.getCartItem(i -> i.getItem().equals("Valentine Bear")).getQuantity(),
                cartPage.getCartItem(i -> i.getItem().equals("Valentine Bear")).getSubtotal(),
                "Invalid Valentine Bear subtotal.");
        assertEquals(cartPage.getCalculatedTotal(), cartPage.getActualTotal(),
                "Invalid calculated total price.");
    }
}
