package jupytertoys.pages;

import jupytertoys.components.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {

    // Class attributes
    private WebDriver driver;
    private By forenameField = By.id("forename");
    private By surnameField = By.id("surname");
    private By emailField = By.id("email");
    private By telephoneField = By.id("telephone");
    private By messageField = By.id("message");
    private By backButton = By.className("btn");
    private By usernameMenuBar = By.id("nav-user");
    private By usernameField = By.id("loginUserName");
    private By passwordField = By.id("loginPassword");
    private By agreeCheckbox = By.id("agree");

    public ContactPage(WebDriver driver){
        this.driver = driver;
    }

    public void populateFieldsFromContactData(ContactData contactData) {
        setForename(contactData.getForename());
        setSurname(contactData.getSurname());
        setEmail(contactData.getEmail());
        setTelephone(contactData.getTelephone());
        setMessage(contactData.getMessage());
    }

    public void setForename(String forename){
        driver.findElement(forenameField).sendKeys(forename);
    }

    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
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

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setTelephone(String telephone){
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void setMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmitButton(){
        WebElement submitButton = driver.findElement(By.id("contact-submit-btn"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", submitButton);
    }

    public String getErrorText(By locator) {
        var elements = driver.findElements(locator);
        if (elements.size() == 0) {
            return "";
        }
        return elements.get(0).getText();
    }

    public void clickBackButton(){
        driver.findElement(backButton).click();
    }

    public void clickLoginPage() {
        clickButton("#nav-login");
    }

    public void clickLogoutMenu() {
        clickButton("#nav-logout");
    }

    public void clickLoginButton(){
        driver.findElements(By.className("btn-primary")).get(1).click();
    }

    public void clickLogoutButton() {
        driver.findElement(By.className("btn-success")).click();
    }

    public String getUsernameInMenuBar() {
        var elements = driver.findElements(usernameMenuBar);
        if (elements.size() > 0) {
            return elements.get(0).getText();
        }
        return "";
    }

    // Creating a method to click a button in the page.
    private void clickButton(String buttonId) {
        driver.findElement(By.cssSelector(buttonId)).click();
    }
}
