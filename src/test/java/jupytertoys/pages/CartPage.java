package jupytertoys.pages;

import jupytertoys.components.CartItem;
import jupytertoys.components.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CartPage {

    // Class attributes
    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public CartItem getCartItem(Function<CartItem, Boolean> comparison) {
        for (CartItem cartItem : getCartItems()) {
            if (comparison.apply(cartItem)) {
                return cartItem;
            }
        }

        return null;
    }

    public int getIndexOfHeaderWithHeading(String heading) {
        for (int i = 0; i < driver.findElements(By.tagName("th")).size(); i++) {
            if (driver.findElements(By.tagName("th")).get(i).getText().equals(heading)) {
                return i;
            }
        }
        return -1;
    }

    public List<CartItem> getCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        List<WebElement> items = driver.findElements(By.className("cart-item"));
        for (WebElement item : items) {
            cartItems.add(new CartItem(Integer.parseInt(
                    item.findElement(By.className("input-mini")).getAttribute("value")),
                    item.findElements(By.tagName("td")).get(getIndexOfHeaderWithHeading("Item")).getText(),
                    Double.parseDouble(item.findElements(By.tagName("td")).get(getIndexOfHeaderWithHeading("Price")).getText().substring(1)),
                    Double.parseDouble(item.findElements(By.tagName("td")).get(getIndexOfHeaderWithHeading("Subtotal")).getText().substring(1)),
                    item.findElement(By.className("btn-mini"))));
        }
        return cartItems;
    }

    public double getActualTotal() {
        return Double.parseDouble(driver.findElements
                (By.tagName("td")).get(driver.findElements
                (By.tagName("td")).size() - 2).getText().split(" ")[1]);
    }

    public double getCalculatedTotal() {
        double total = 0; // initial value
        for (CartItem cartItem : getCartItems()) {
            total += cartItem.getSubtotal();
        }
        return total;
    }
}
