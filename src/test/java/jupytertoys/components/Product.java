package jupytertoys.components;

import org.openqa.selenium.WebElement;

public class Product {
    // Class attributes
    private String title;
    private double price;
    private int rating;
    WebElement buy;

    public Product(String title, double price, int rating, WebElement buy) {
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.buy = buy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public WebElement getBuy() {
        return buy;
    }

    public void setBuy(WebElement buy) {
        this.buy = buy;
    }

    public void buyProduct() {
        buy.click();
    }

    public void buyProduct(int times) {
        for (int i = 0; i < times; i++) {
            buy.click();
        }
    }
}
