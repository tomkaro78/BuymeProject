package secondPrject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import secondPrject.tests.buyMeTest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriverInstance()  {
        String type = null;
        try {
            type = getData("browserType");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(driver == null){
           if(type.equals("Chrome")){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\IdeaProjects\\chromedriver.exe");
//    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.addArguments("--headless");
               driver = new ChromeDriver();
            }else if(type.equals("FF")){
               System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
               driver = new FirefoxDriver();
           }
        }

        return (ChromeDriver) driver;
    }

    private static String getData (String keyName) throws Exception{
        ClassLoader classLoader = buyMeTest.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
