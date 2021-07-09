package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends BasePage {

    public void choosePrice() {
        clickElement(By.className("chosen-single"));

    }

    public void chooseArea() {
        clickElement(By.linkText("אזור"));

    }

    public void chooseCategory() {
        clickElement(By.linkText("קטגוריה"));


    }

    public void search() {
        clickElement(By.id("ember1038"));
    }
}





