package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends BasePage {

    public void choosePrice()  {
        clickElement(By.className("chosen-single"));
        getWebElements(By.className("active-result"), 5).click();

    }

    public void chooseArea() {
        clickElement(By.linkText("אזור"));
        getWebElements(By.className("active-result"), 5).click();

    }

    public void chooseCategory()  {
        clickElement(By.linkText("קטגוריה"));
        getWebElements(By.className("active-result"), 5).click();

    }

    public void search()  {
        clickElement(By.id("ember1038"));

    }
}





