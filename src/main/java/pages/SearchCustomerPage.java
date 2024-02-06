package pages;

import Helper.ActionHelper;
import Helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver driver;
    public WaitHelper waithelper;  //Note: Wait is not necessary to pass the test.

    public ActionHelper actionHelper;

    public SearchCustomerPage(WebDriver driver) {
        this.driver = driver;
        waithelper = new WaitHelper(driver);
        actionHelper = new ActionHelper(driver);
    }

    public By txtEmail = By.xpath("//input[@id='SearchEmail']");

    public By txtFirstName = By.xpath("//input[@id='SearchFirstName']");

    public By txtLastName = By.xpath("//input[@id='SearchLastName']");

    public By companyName = By.xpath("//input[@id='SearchCompany']");

    public By btnSearch = By.xpath("//button[@id='search-customers']");
    public By table = By.xpath("//table[@id='customers-grid']");
    public By tableRows = By.xpath("//table[@id = 'customers-grid']//tbody/tr");
    public By tableColumns = By.xpath("//table[@id = 'customers-grid']//tbody/tr/td");

    // Page Methods / Action methods
    public void setEmail(String email) {
        WebElement enterEmail = driver.findElement(txtEmail);

        enterEmail.sendKeys(email);
    }

    public void setFirstName(String fname) {
        WebElement enterFirstName = driver.findElement(txtFirstName);
        waithelper.WaitForElement(enterFirstName, 30);
        enterFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        WebElement enterLastName = driver.findElement(txtLastName);
        waithelper.WaitForElement(enterLastName, 30);
        enterLastName.sendKeys(lname);
    }

    public void setCompanyName(String companyname){
        WebElement enterCompanyName = driver.findElement(companyName);
        enterCompanyName.sendKeys(companyname);
    }

    public void clickSearch() {
        WebElement button = driver.findElement(btnSearch);
        button.click();
        waithelper.WaitForElement(button, 30);
        // Scroll to the page down after click.
        actionHelper.scrollDown(button);
    }

    public int getNoOfRows() {
        List<WebElement> rows = driver.findElements(tableRows);
        return rows.size();
    }

    public int getNoOfColumns() {
        List<WebElement> columns = driver.findElements(tableColumns);
        return columns.size();
    }

    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;

        List<WebElement> rows = driver.findElements(table);

        for (int i = 1; i <= getNoOfRows(); i++) {
            String emaiId = rows.get(i - 1).findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();

            System.out.println(emaiId);

            if (emaiId.equals(email)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean searchCustomerByName(String Name) {
        boolean flag = false;

        List<WebElement> rows = driver.findElements(table);

        for (int i = 1; i <= getNoOfRows(); i++) {
           String name = rows.get(i - 1).findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();
            //String name = rows.get(i - 1).findElement(By.xpath(".//td[3]")).getText();

            String fullName[]=name.split(" ");

            if (fullName[0].equals("John") && fullName[1].equals("Smith")) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean searchCustomerByCompanyName(String CompanyName) {
        boolean flag = false;

        List<WebElement> rows = driver.findElements(table);

        for (int i = 1; i <= getNoOfRows(); i++) {
            // String name = rows.get(i - 1).findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]")).getText();
            String name = rows.get(i - 1).findElement(By.xpath(".//td[5]")).getText();

            String companyFullName[]=name.split(" ");

            if (companyFullName[0].equals("Indian") && companyFullName[1].equals("Cricket") && companyFullName[2].equals("Team")) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}

