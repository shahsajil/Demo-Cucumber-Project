package stepdefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.AddCustomerPage;
import pages.AddProductPage;
import pages.LoginPage;
import pages.SearchCustomerPage;

public class BaseClass {
    public WebDriver driver; //
    public LoginPage loginPage; //to access all the method from page
    public AddCustomerPage addCustomer;
    public SearchCustomerPage searchCustomer;
    public AddProductPage addProduct;

    //Created for generating random string for creating unique email
    public static String randomstring() {
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }

    public void scrollDown() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 500);"); // Adjust the '500' value as needed
    }
}


