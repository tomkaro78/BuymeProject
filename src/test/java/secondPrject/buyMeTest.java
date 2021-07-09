package secondPrject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class buyMeTest {
    String name = "tom";
    String mail = "hgf667@gmail.com";
    String password = "tomkKk78905";

    private static ChromeDriver driver;
    LoginPage loginPage = new LoginPage();
    HomeScreen homeScreen = new HomeScreen();


    @BeforeClass
    public void runOnce() {
        driver = DriverSingleton.getDriverInstance();
        driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();
    }

    //@Test
    public void introAndRegisration()  {
        loginPage.register();
        Assert.assertEquals(name, driver.findElement(By.className("ember-text-field")).getText());
        Assert.assertEquals(mail, driver.findElement(By.cssSelector("input[placeholder = מייל]")).getText());
        Assert.assertEquals(password, driver.findElement(By.className("input[placeholder = סיסמה]")).getText());
        Assert.assertEquals(password, driver.findElement(By.className("input[placeholder=\"אימות סיסמה\"]")).getText());
        loginPage.confirmRegister();
    }

    @Test(priority = 1)
    public void loginToBuyMe() {
        loginPage.loginBuyMe();
    }

    //@Test(priority = 2)
    public void findGift() {
        homeScreen.choosePrice();
        List<WebElement> priceElement = driver.findElements(By.className("active-result"));
        for (int i = 0; i < priceElement.size(); i++) {
            try {
                priceElement.get(5).click();
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
                continue;
            }
        }
        homeScreen.chooseArea();
        List<WebElement> areaElement = driver.findElements(By.className("active-result"));
        for (int i = 0; i < areaElement.size(); i++) {
            try {
                areaElement.get(5).click();
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
                continue;
            }
        }
        homeScreen.chooseCategory();
        List<WebElement> categoryElement = driver.findElements(By.className("active-result"));
        for (int i = 0; i < categoryElement.size(); i++) {
            try {
                categoryElement.get(5).click();
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
                continue;
            }
        }

        homeScreen.search();

    }


}






