package secondPrject.webPages;

import org.openqa.selenium.By;
import secondPrject.base.BasePage;


public class LoginPage extends BasePage {

    public void register() {
        enterRegisterPage();
        enterCredentials();
    }

    public void loginBuyMe() {
        submitLogin();
    }


    private void enterRegisterPage() {
        clickElement(By.className("seperator-link"));
        clickElement(By.className("text-link"));
    }

    private void enterCredentials() {
        sendKeysToElement(By.className("ember-text-field"), "tom");
        sendKeysToElement(By.cssSelector("input[placeholder = מייל]"), "hgf667@gmail.com");
        sendKeysToElement(By.cssSelector("input[placeholder = סיסמה]"), "tomkKk78905");
        sendKeysToElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]"), "tomkKk78905");
    }

    public void confirmRegister() {
        clickElement(By.className("label"));
    }

    private void submitLogin() {
        clickElement(By.className("seperator-link"));
        sendKeysToElement(By.cssSelector("input[type= email]"), "hgf667@gmail.com");
        sendKeysToElement(By.cssSelector("input[placeholder=סיסמה]"), "tomkKk78905");
        clickElement(By.cssSelector("button[type = submit]"));
    }

}
