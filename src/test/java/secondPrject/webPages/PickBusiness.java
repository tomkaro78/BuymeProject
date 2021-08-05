package secondPrject.webPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import secondPrject.base.BasePage;

public class PickBusiness extends BasePage {
    String buymePickBusinessUrl = "https://buyme.co.il/search?budget=5&category=5&region=14";

    public void assertWebsiteUrl(String element) {
        Assert.assertEquals(element, buymePickBusinessUrl);
    }


    public void pickBusinessAndMount() {
        clickElement(By.linkText("מסעדת אמא"));
        sendKeysToElement(By.cssSelector("input[placeholder=\"הכנס סכום\"]"), "100");
        clickElement(By.cssSelector("button[gtm=\"בחירה\"]"));
    }


}
