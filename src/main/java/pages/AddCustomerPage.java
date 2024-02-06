package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    public WebDriver driver;

    //Constructors
    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }
     // locators to locate the elements from the page
    public By customersMenuLocator = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    public By customersMenuItemsLocator = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
    public By addNewButtonLocator = By.xpath("//a[normalize-space()='Add new']");
    public By textEmailLocator = By.xpath("//input[@id='Email']");
    public By textPasswordLocator = By.xpath("//input[@id='Password']");
    public By firstNameLocator = By.xpath("//input[@id='FirstName']");
    public By lastNameLocator = By.xpath("//input[@id='LastName']");
    public By maleGenderLocator = By.xpath("//input[@id='Gender_Male']");
    public By femaleGenderLocator = By.xpath("//input[@id='Gender_Female']");
    public By dataOfBirthLocator = By.xpath("//input[@id='DateOfBirth']");
    public By companyNameLocator = By.xpath("//input[@id='Company']");
    public By taxExemptLocator = By.xpath("//input[@id='IsTaxExempt']");
    public By newsletterLocator = By.xpath("//div[@class='input-group-append']//div[@role='listbox']");
    public By customersRolesLocator = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    public By administratorsLocator = By.xpath("//li[contains(text(),'Administrators')]");
    public By registeredLocator = By.xpath("//li[contains(text(),'Registered')]");
    public By guestsLocator = By.xpath("//li[contains(text(),'Guests')]");
    public By vendorLocator = By.xpath("//li[contains(text(),'vendors')]");
    public By managerOfVendorLocator = By.xpath("//select[@id='VendorId']");
    public By adminCommentLocator = By.xpath("//textarea[@id='AdminComment']");
    public By saveButtonLocator = By.xpath("//button[@name='save']");

    // page methods or actions methods.

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickOnCustomersMenu(){
        WebElement customersMenu = driver.findElement(customersMenuLocator);
        customersMenu.click();
    }

    public void clickOnCustomersMenuItem(){
        WebElement customersMenuItem = driver.findElement(customersMenuItemsLocator);
        customersMenuItem.click();
    }

    public void clickOnAddNew(){
        WebElement addNew = driver.findElement(addNewButtonLocator);
        addNew.click();
    }

    public void setEmail(String email){
        WebElement textEmail = driver.findElement(textEmailLocator);
        textEmail.sendKeys(email);
    }

    public void setPassword(String password){
        WebElement txtPassword = driver.findElement(textPasswordLocator);
        txtPassword.sendKeys(password);
    }

    public void setCustomerRoles(String role) throws InterruptedException {
        if(!role.equals("Vendors"))   //If role is vendors should not delete Register as per req.
        {
            WebElement notVendors = driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]"));
            notVendors.click();
        }
        WebElement customerRoles = driver.findElement(customersRolesLocator);
        customerRoles.click();

        WebElement listitem;

        Thread.sleep(3000);

        if(role.equals("Administrators")){
            listitem = driver.findElement(administratorsLocator);
        }
        else if(role.equals("Guests")){
            listitem = driver.findElement(guestsLocator);
        }
       else if(role.equals("Registered")){
           listitem = driver.findElement(registeredLocator);
       }
       else if(role.equals("Vendors")){
           listitem = driver.findElement(vendorLocator);
       }
       else {
           listitem = driver.findElement(guestsLocator);
        }

       //listitem.click();
       //Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", listitem);
    }

    public void setManagerOfVendor(String value){
    Select dropdown = new Select(driver.findElement(managerOfVendorLocator));
    dropdown.selectByVisibleText(value);
    }

    public void setGender(String gender){
        if(gender.equals("Male")){
            WebElement maleGender = driver.findElement(maleGenderLocator);
            maleGender.click();
        }
        else if(gender.equals("Female")){
            WebElement femaleGender = driver.findElement(femaleGenderLocator);
            femaleGender.click();
        }
        else{
            driver.findElement(maleGenderLocator).click();
        }
    }

    public void setFirstName(String fname){
        WebElement firstName = driver.findElement(firstNameLocator);
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname){
        WebElement lastName = driver.findElement(lastNameLocator);
        lastName.sendKeys(lname);
    }

    public void setDob(String dob){
        WebElement birthDate = driver.findElement(dataOfBirthLocator);
        birthDate.sendKeys(dob);
    }

    public void setCompanyName(String comname){
        WebElement companyName = driver.findElement(companyNameLocator);
        companyName.sendKeys(comname);
    }

    public void setAdminComment(String comment){
        WebElement adminComment = driver.findElement(adminCommentLocator);
        adminComment.sendKeys(comment);
    }

    public void clickOnSave(){
        WebElement clickSave = driver.findElement(saveButtonLocator);
        clickSave.click();
    }

}
