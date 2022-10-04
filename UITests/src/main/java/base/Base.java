package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Base {
    protected DriverBuilder driverBuilder = null;
    protected Properties properties = null;
    protected WebDriver driver = null;
    protected ExtentReports extent;
    protected ExtentTest logger;
    protected ExtentHtmlReporter htmlReporter;
    protected String htmlReportPath = "reports/report.html";
    protected String testName = "";

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
        htmlReporter = new ExtentHtmlReporter(htmlReportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void afterEveryClass() {
        driver.quit();
    }

    @AfterMethod
    public void afterEveryMethod(ITestResult result){
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        extent.flush();
    }

    @BeforeMethod
    public void beforeEveryMethod(Method method){
        testName = method.getName();
    }

}
