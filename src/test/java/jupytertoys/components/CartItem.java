package jupytertoys.components;

import org.openqa.selenium.WebElement;

public class CartItem {
    // Class attributes
    private int quantity;
    private String item;
    private double price;
    private double subtotal;
    WebElement remove;

    public CartItem(int quantity, String item, double price, double subtotal, WebElement remove) {
        this.quantity = quantity;
        this.item = item;
        this.price = price;
        this.subtotal = subtotal;
        this.remove = remove;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public WebElement getRemove() {
        return remove;
    }

    public void setRemove(WebElement remove) {
        this.remove = remove;
    }
}
