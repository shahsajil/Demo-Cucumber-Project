package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {

    public WebDriver driver;

    public ActionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDown(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }
}
