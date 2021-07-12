package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

    List<WebElement> getWebElements(By locator) {
        return DriverSingleton.getDriverInstance().findElements(locator);
    }

    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public void sendKeysToElementWhithKeys(By locator, Keys key, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public void searchForElement (By locator) {
        getWebElement(locator).getText();
    }

    public void clickElementFromList(By locator){
        getWebElements(locator);
    }

    public void clearText(By locator){
        getWebElements(locator).clear();
    }




}
