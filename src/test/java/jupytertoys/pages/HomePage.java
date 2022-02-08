package jupytertoys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // Class attributes
    private WebDriver driver;
    private By usernameField = By.id("loginUserName");
    private By passwordField = By.id("loginPassword");
    private By loginButton = By.className("btn-primary");
    private By usernameMenuBar = By.id("nav-user");
    private By agreeCheckbox = By.id("agree");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickAgreeCheckbox() {
        driver.findElement(agreeCheckbox).click();
    }

    public HomePage clickHomePage() {
        clickButton("#nav-home");
        return new HomePage(driver);
    }

    public ContactPage clickContactPage() {
        clickButton("#nav-contact a");
        return new ContactPage(driver);
    }

    public ShopPage clickShopPage() {
        clickButton("#nav-shop");
        return new ShopPage(driver);
    }

    public void clickLoginPage() {
        clickButton("#nav-login");
    }

    public CartPage clickCartPage() {
        clickButton("#nav-cart");
        return new CartPage(driver);
    }

    public String getUsernameInMenuBar() {
        var elements = driver.findElements(usernameMenuBar);
        if (elements.size() > 0) {
            return elements.get(0).getText();
        }
        return "";
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    // Creating a method to click a button in the page.
    private void clickButton(String buttonId) {
        driver.findElement(By.cssSelector(buttonId)).click();
    }
}
