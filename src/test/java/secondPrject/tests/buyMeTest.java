package secondPrject.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import secondPrject.base.DriverSingleton;
import secondPrject.webPages.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class buyMeTest {
    String name = "tom";
    String mail = "hgf667@gmail.com";
    String password = "tomkKk78905";
    private static ExtentReports extent;
    private static ExtentTest test;
    private static WebDriver driver;
    private static WebDriverWait wait;


    LoginPage loginPage = new LoginPage();
    HomeScreen homeScreen = new HomeScreen();
    PickBusiness pickBusiness = new PickBusiness();
    SenderReceiverInformationScreen senderReceiverInformationScreen = new SenderReceiverInformationScreen();
    HowToSendPage howToSendPage = new HowToSendPage();


    @BeforeClass
    public void runOnce() {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");  //Establish report location
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

    //@Test // Registration process
    public void introAndRegistration() {
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
            test.log(Status.FAIL, "Register failed! " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 1) // Login process
    public void loginToBuyMe() {
        try {
            loginPage.loginBuyMe();
            test.log(Status.PASS, "Login completed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Login failed! " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 2) // Search for gift filters
    public void findGift() {
        try {
            homeScreen.choosePrice();
            homeScreen.chooseArea();
            homeScreen.chooseCategory();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,100)"); // Scroll down For Element

            homeScreen.search();
            test.log(Status.PASS, "Fined gift successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Gift didn't found " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 3)  //Choose business and amount
    public void enterBusinessAndAmount() {
        try {
            String url = "https://buyme.co.il/search?budget=5&category=5&region=14";
            String webUrl = driver.getCurrentUrl();
            Assert.assertEquals(webUrl, url);
            pickBusiness.pickBusinessAndMount();
            test.log(Status.PASS, "Business choose successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Can't choose business  " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 4)
    public void enterReceiverDetails() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            String receiverName = "בר מזל";
            senderReceiverInformationScreen.enterReceiverName();
            senderReceiverInformationScreen.enterPurpose();
            senderReceiverInformationScreen.enterTextForBlessing();
            driver.findElement(By.id("ember2025")).getText();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            senderReceiverInformationScreen.uploadPhoto();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[gtm=המשך]")));
            senderReceiverInformationScreen.pressContinue();
            test.log(Status.PASS, "Receiver details entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Receiver details not filled  " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());
        }
    }

    @Test(priority = 5)
    public void enterHowToSend() {
        try {
            String senderName = "tomkaro78@gmail.com";

            howToSendPage.sendByMail();
            howToSendPage.enterSenderName();
            howToSendPage.paymentSubmit();
            String senderNameElement = driver.findElement(By.cssSelector("input[placeholder=\"שם שולח המתנה\"]")).getText();
            Assert.assertEquals(senderNameElement, senderName);
            test.log(Status.PASS, "Choose how to send successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Must choose how to send  " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("NoElementScreenshot")).build());

        }
    }


    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        //driver.quit();
        // build and flush report
        extent.flush();
    }


    //Takes screenshot
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }


}






