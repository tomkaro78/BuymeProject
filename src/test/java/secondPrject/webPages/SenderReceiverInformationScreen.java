package secondPrject.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import secondPrject.base.BasePage;

public class SenderReceiverInformationScreen extends BasePage {


    public void enterReceiverName() {
        clearText(By.id("ember2025"));
        sendKeysToElement(By.id("ember2025"), "בר");


    }

    public void enterPurpose() {
        clickElement(By.className("selected-name"));
        clickElement(By.id("ember2060"));

    }

    public void enterTextForBlessing() {
        sendKeysToElement(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), Keys.CONTROL + "a");
        sendKeysToElementWithKeys(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), Keys.DELETE, "Mazal tovv");
    }

    public void uploadPhoto() {
        sendKeysToElement(By.cssSelector("input[type=file]"), "C:\\Users\\LENOVO\\Downloads\\מעקה (3).jpg");
    }


    public void pressContinue() {
        clickElement(By.cssSelector("button[gtm=המשך]"));
    }


}
