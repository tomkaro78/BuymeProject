package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SenderReceiverInformationScreen extends BasePage {



    public void enterReceiverName()  {
        clearText(By.id("ember1953"));
        sendKeysToElement(By.id("ember1953"), "בר מזל");


    }

    public void enterPurpose()  {
        clickElement(By.className("selected-name"));
        clickElement(By.id("ember2060"));

    }

    public void enterTextForBlessing()  {
        sendKeysToElement(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), Keys.CONTROL + "a");
        sendKeysToElementWithKeys(By.cssSelector("textarea[data-parsley-group=voucher-greeting]"), Keys.DELETE , "Mazal tovv" );
    }

    public void uploadPhoto()  {
        sendKeysToElement(By.cssSelector("input[type=file]"), "C:\\Users\\LENOVO\\Downloads\\מעקה (3).jpg" );
    }


    public void pressContinue()  {
        clickElement(By.cssSelector("button[gtm=המשך]"));
        //waitUntilElementIsClickableAndClick(By.cssSelector("button[gtm=המשך]"));
    }







}
