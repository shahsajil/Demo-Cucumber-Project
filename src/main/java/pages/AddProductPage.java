package pages;

import Helper.ActionHelper;
import Helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage {
    public WebDriver driver;
    //public ActionHelper actionHelper;

    //public WaitHelper waitHelper;

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
        //waitHelper = new WaitHelper(driver);
    }

    //locators to locate the elements from the page
    public By catalogMenuLocator = By.xpath("//p[normalize-space()='Catalog']");
    public By ProductsMenuLocator = By.xpath("//p[normalize-space()='Products']");
    public By addNewButtonLocator = By.xpath("//a[normalize-space()='Add new']");

    public By productNameLocator = By.xpath("//input[@id='Name']");
    public By skuInfoLocator = By.xpath("//input[@id='Sku']");
    public By productCategoryLocator = By.xpath("//li[normalize-space()='Electronics >> Cell phones']");
    public By productPriceLocator = By.xpath("//input[@id='Price']");
    //public By productSaveButtonLocator = By.xpath("//button[@name='save']");
    public By productSaveButtonLocator = By.cssSelector("button[name='save']");


    // page methods or actions methods.
    public String getPageTitle(){
        return driver.getTitle();
    }
    public void clickCatalogMenu(){
        WebElement catalogMenu = driver.findElement(catalogMenuLocator);
        //waitHelper.WaitForElement(catalogMenu, 30);
        catalogMenu.click();
    }
    public void clickProductsMenu(){
        WebElement productsMenu = driver.findElement(ProductsMenuLocator);
        //waitHelper.WaitForElement(productsMenu, 30);
        productsMenu.click();
    }
    public void setProduct(String name){
        WebElement textProduct = driver.findElement(productNameLocator);
        //waitHelper.WaitForElement(textProduct, 30);
        textProduct.sendKeys(name);
    }
    public void setSku(String sku){
        WebElement textSku = driver.findElement(skuInfoLocator);
        //waitHelper.WaitForElement(textSku, 30);
        textSku.sendKeys(sku);
        //actionHelper.scrollDown(textSku);
    }
    /*public void setCategory(String category){
        WebElement textCategory = driver.findElement(productCategoryLocator);
        textCategory.sendKeys();

    }*/
 /*   public void setPrice(String price){
        WebElement enterPrice = driver.findElement(productPriceLocator);
        enterPrice.clear();
        enterPrice.sendKeys(price);
    }*/
    public void clickSave(){
        WebElement save = driver.findElement(productSaveButtonLocator);
        save.click();
        //waitHelper.WaitForElement(save, 30);

    }
}
