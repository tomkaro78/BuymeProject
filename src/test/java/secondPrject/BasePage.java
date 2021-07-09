package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public void searchForElement (By locator) {
        getWebElement(locator).getText();
    }

}
