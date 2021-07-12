package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SenderReceiverInformationScreen extends BasePage {

    public void WhoseToSendStep(){
        enterReceiverAndPurpose();
        clearTextFromBlessing();
    }

    private void enterReceiverAndPurpose(){
        sendKeysToElement(By.id("ember1953"), "בר מזל");
        clickElement(By.className("selected-name"));
        clickElement(By.cssSelector("li[value=\"10\"]"));
    }

    private void clearTextFromBlessing() {
        sendKeysToElement(By.className("parsley-success"), Keys.CONTROL + "a");
        sendKeysToElementWhithKeys(By.className("parsley-success"), Keys.DELETE , "Mazal tov" );
    }



}
