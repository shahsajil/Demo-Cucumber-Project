package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    //Constructors
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // locators to capture the elements from the page
    public By emailLocator = By.xpath("//input[@id='Email']");
    public By passwordLocator = By.xpath("//input[@id='Password']");
    public By logInButtonLocator = By.xpath("//button[@type='submit']");
    public By logOutButtonLocator = By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");

    //page methods or actions methods
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailLocator);
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordLocator);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(logInButtonLocator);
        loginButton.click();
    }
    public void clickLogOutButton(){
        WebElement logoutButton = driver.findElement(logOutButtonLocator);
        logoutButton.click();
    }
}
