package secondPrject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class buyMeTest {
    String name = "tom";
    String mail = "hgf667@gmail.com";
    String password = "tomkKk78905";
    private static ExtentReports extent;
    private static ExtentTest test;


    private static ChromeDriver driver;
    LoginPage loginPage = new LoginPage();
    HomeScreen homeScreen = new HomeScreen();
    PickBusiness pickBusiness = new PickBusiness();
    SenderReceiverInformationScreen senderReceiverInformationScreen = new SenderReceiverInformationScreen();


    @BeforeClass
    public void runOnce() {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");
        // log results
        test.log(Status.INFO, "@Before class");

       try {
           driver = DriverSingleton.getDriverInstance();

           test.log(Status.PASS, "Driver established successfully");
       } catch (Exception e) {
           e.printStackTrace();
           test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
       }
           driver.get("https://buyme.co.il/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //@Test
    public void introAndRegisration()  {
        try {
            loginPage.register();
            Assert.assertEquals(name, driver.findElement(By.className("ember-text-field")).getText());
            Assert.assertEquals(mail, driver.findElement(By.cssSelector("input[placeholder = מייל]")).getText());
            Assert.assertEquals(password, driver.findElement(By.className("input[placeholder = סיסמה]")).getText());
            Assert.assertEquals(password, driver.findElement(By.className("input[placeholder=\"אימות סיסמה\"]")).getText());
            loginPage.confirmRegister();
            test.log(Status.PASS, "Register completed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Register failed! " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void loginToBuyMe() {
        try {
            loginPage.loginBuyMe();
            test.log(Status.PASS, "Login completed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Login failed! " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void findGift() throws InterruptedException {
       try {
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
           test.log(Status.PASS, "Fined gift successfully");
       } catch (Exception e) {
           e.printStackTrace();
           test.log(Status.FAIL, "Gift didn't found " + e.getMessage());
       }
    }

    @Test (priority = 3)
    public void enterBusinessAndAmount(){
        try {
            pickBusiness.pickBusinessAndMount();
            test.log(Status.PASS, "Business choose successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Can't choose business  " + e.getMessage());
        }
    }

    @Test (priority = 4)
    public void enterReeiverDetails(){
        try {
            senderReceiverInformationScreen.WhoseToSendStep();
            test.log(Status.PASS, "Receiver details entered successfully");

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Receiver details not filled  " + e.getMessage());

        }
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        //driver.quit();
        // build and flush report
        extent.flush();
    }




}






