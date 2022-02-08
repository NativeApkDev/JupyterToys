package jupytertoys.tests;

import jupytertoys.components.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jupytertoys.pages.ContactPage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ContactTests extends BaseTests {
    @Test
    public void testCase01() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setEmail("thisisnotavalidemail");
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.id("email-err")), "Please enter a valid email",
                "Email error is supposed to occur!");
    }

    @Test
    public void testCase02() {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.id("forename-err")), "Forename is required",
                "Forename error is supposed to occur!");
        assertEquals(contactPage.getErrorText(By.id("email-err")), "Email is required",
                "Email error is supposed to occur!");
        assertEquals(contactPage.getErrorText(By.id("message-err")), "Message is required",
                "Message error is supposed to occur!");
        contactPage.populateFieldsFromContactData(new ContactData("ex", "",
                "example@gmail.com", "", "I am new!"));
        assertEquals(contactPage.getErrorText(By.id("forename-err")), "",
                "Forename error should not exist!");
        assertEquals(contactPage.getErrorText(By.id("email-err")), "",
                "Email error should not exist!");
        assertEquals(contactPage.getErrorText(By.id("message-err")), "",
                "Message error should not exist!");
    }

    @Test (dataProvider = "contactFieldsData")
    public void testCase03(String forename, String surname, String email, String telephone,
                           String message) {
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.populateFieldsFromContactData(new ContactData(forename, surname, email,
                telephone, message));
        contactPage.clickSubmitButton();
        assertEquals(contactPage.getErrorText(By.className("alert-success")),
                "Thanks " + forename + ", we appreciate your feedback.",
                "Alert text should have appeared!");
    }

    @DataProvider
    public Object[][] contactFieldsData() {
        try {
            Object[][] data = new Object[5][5];
            BufferedReader bufferedReader = new BufferedReader(new FileReader
                    ("src/test/java/jupytertoys/tests/contact_fields_data.csv"));
            String line;
            int index = 0;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                Object[] lineData = line.split(",");
                data[index] = lineData;
                index++;
            }
            return data;
        }
        catch (IOException ex) {
            return new Object[5][5];
        }
    }
}
