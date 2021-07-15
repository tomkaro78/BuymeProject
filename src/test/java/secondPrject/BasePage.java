package secondPrject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static WebDriver driver;
    private static WebDriverWait wait;


    WebElement getWebElement(By locator)   {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

   WebElement getWebElements(By locator, int index) {
        return DriverSingleton.getDriverInstance().findElements(locator).get(index);
    }

    public void clickElementFromlist(By locator, int index){
        getWebElements(locator, index).click();
    }

    public void waitUntilElementIsClickableAndClick(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text)  {

            getWebElement(locator).sendKeys(text);
    }

    public void sendKeysToElementWithKeys(By locator, Keys key, String text)  {

            getWebElement(locator).sendKeys(text);
    }


    public void clearText(By locator)  {
        getWebElement(locator).clear();
    }





}
