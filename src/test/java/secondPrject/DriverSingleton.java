package secondPrject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static ChromeDriver driver;

    public static ChromeDriver getDriverInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\IdeaProjects\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }
}
