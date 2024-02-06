package stepdefinitions;

import Helper.WaitHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AddCustomerPage;
import pages.AddProductPage;
import pages.LoginPage;
import pages.SearchCustomerPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginPageStepDef extends BaseClass {

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver); //instantiate LoginPage
        addCustomer = new AddCustomerPage(driver); // instantiate AddCustomerPage
        searchCustomer = new SearchCustomerPage(driver); //instantiate SearchCustomerPage
        addProduct = new AddProductPage(driver); //instantiate AddProductPage
    }

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
    // The WebDriver and page objects have already been initialized in the setup() method.
        }

    @When("User open URL {string}")
    public void user_open_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("click on Login")
    public void click_on_login(){
        loginPage.clickLoginButton();
        //Thread.sleep(3000);
    }

    @Then("Page Title Should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.fail("Login was unsuccessful message found");
            //Assert.fail();
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
        //Thread.sleep(3000);
    }

    //Thread.sleep(3000); // You may consider removing this line unless there's a specific reason for the sleep.

    @When("User click on Log out link")
    public void user_click_on_log_out_link(){
        loginPage.clickLogOutButton();
        //Thread.sleep(2000);
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    //Customer feature step definitions
    //Adding new customer

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {

        Assert.assertEquals("Dashboard / nopCommerce administration", addCustomer.getPageTitle());
    }
    @When("User click on customers Menu")
    public void user_click_on_customers_menu(){
        addCustomer.clickOnCustomersMenu();
        //Thread.sleep(5000);
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item(){
        addCustomer.clickOnCustomersMenuItem();
        //Thread.sleep(5000);
    }
    @When("click on Add new button")
    public void click_on_add_new_button(){
        addCustomer.clickOnAddNew();
        //Thread.sleep(5000);
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomer.getPageTitle());
    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomstring() + "@gmail.com";
        addCustomer.setEmail(email);
        addCustomer.setPassword("test123");
        // Registered - default
        // The customer cannot be in both 'Guests' and 'Registered' customer roles
        // Add the customer to 'Guests' or 'Registered' customer role
        addCustomer.setCustomerRoles("Guests");
        //Thread.sleep(4000);

        addCustomer.setManagerOfVendor("Vendor 2");
        addCustomer.setGender("Male");
        addCustomer.setFirstName("Sajil");
        addCustomer.setLastName("Shah");
        addCustomer.setDob("12/10/1989");   //MM/DD/YYYY
        addCustomer.setCompanyName("Quality Engineer");
        addCustomer.setAdminComment("Automation Testing Demo");
    }
    @When("click on save button")
    public void click_on_save_button(){
        addCustomer.clickOnSave();
        //Thread.sleep(4000);
    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
    }

    //Searching customer through Email ID

    @When("Enter customer Email")
    public void enter_customer_email() {

        searchCustomer.setEmail("admin@yourStore.com");
    }
    @When("Click on search button")
    public void click_on_search_button() {
        searchCustomer.clickSearch();

    }
    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status = searchCustomer.searchCustomerByEmail("admin@yourStore.com");
       Assert.assertTrue(status);
    }

    // Searching Customer by First and Last Name
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        searchCustomer = new SearchCustomerPage(driver);
        searchCustomer.setFirstName("John");
    }
    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        searchCustomer.setLastName("Smith");
    }

    @Then("User should found Name in the Search table")
    public void user_should_found_name_in_the_search_table() {
        boolean status = searchCustomer.searchCustomerByName("John Smith");
        Assert.assertTrue(status);
    }

    // Searching Customer By Company Name
    @When("Enter Company Name")
    public void enter_company_name() {
        searchCustomer = new SearchCustomerPage(driver);
        searchCustomer.setCompanyName("Indian Cricket Team");
    }

    @Then("User should found Company Name in the Search table")
    public void user_should_found_company_name_in_the_search_table() {
        boolean status = searchCustomer.searchCustomerByCompanyName("Indian Cricket Team");
        Assert.assertTrue(status);
    }

    //Add a new Product
    @When("User click on Catalog Menu")
    public void user_click_on_catalog_menu() {

        addProduct.clickCatalogMenu();
    }
    @When("click on Products Menu Item")
    public void click_on_products_menu_item() {
        addProduct.clickProductsMenu();
    }
    @Then("User can view Add new product page")
    public void user_can_view_add_new_product_page() {
       Assert.assertEquals("Add a new product / nopCommerce administration", addProduct.getPageTitle());
    }
    @When("User enter product info")
    public void user_enter_product_info() {
        addProduct.setProduct("Apple Iphone 15");
        addProduct.setSku("Apple_Iphone15");
      /*scrollDown();
        addProduct.setPrice("1099");*/
    }
    @When("click on product save button")
    public void click_on_product_save_button() {
        addProduct.clickSave();
        //Thread.sleep(10000);
    }
    @Then("User can view product confirmation message {string}")
    public void user_can_view_product_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new product has been added successfully."));
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust the timeout as needed
        WebElement confirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissable']")));
        Assert.assertTrue(confirmationMessage.getText().contains("The new product has been added successfully."));*/
    }

    // Adding Products using Data Driven
    @When("User enter Product Name info as {string} and SKU info as {string};")
    public void user_enter_product_name_info_as_and_sku_info_as(String product, String sku) {
      addProduct.setProduct(product);
      addProduct.setSku(sku);
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}