package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    protected DriverBuilder driverBuilder = null;
    protected Properties properties = null;
    protected WebDriver driver = null;

    @BeforeClass
    public void beforeEveryClass() throws IOException {
        driverBuilder = new DriverBuilder();
        properties = new Properties();
        FileInputStream fileInput = new FileInputStream("properties/Data.properties");
        properties.load(fileInput);
        String baseUrl = properties.getProperty("browser");
        String browser = properties.getProperty("baseUrl");
        driver = driverBuilder.driverConfig(baseUrl);
        driver.get(browser);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void afterEveryClass() {
        driver.quit();
    }
}
