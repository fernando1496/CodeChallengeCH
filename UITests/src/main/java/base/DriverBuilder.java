package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverBuilder {
    public WebDriver driverConfig(String browserToRun){

        WebDriver driver;
        switch (browserToRun){
            case "Google Chrome":
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "Mozilla Firefox":
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                driver = null;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
