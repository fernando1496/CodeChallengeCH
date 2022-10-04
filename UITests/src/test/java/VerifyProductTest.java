import base.Base;
import com.aventstack.extentreports.Status;
import commonCommands.CommonCommands;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CategoryPanel;
import pageObjects.HeaderPanel;
import pageObjects.ProductDetailsPage;
import pageObjects.ResultsPage;
import java.lang.reflect.Method;
import static extentReports.ExtentTestManager.getTest;
import static extentReports.ExtentTestManager.startTest;


public class VerifyProductTest extends Base{
    HeaderPanel headerPanel;
    CommonCommands commonCommands;
    CategoryPanel categoryPanel;
    ResultsPage resultsPage;
    ProductDetailsPage productDetailsPage;

    @BeforeClass
    private void beforeClass() {
        headerPanel = new HeaderPanel(driver);
        commonCommands = new CommonCommands(driver);
        categoryPanel = new CategoryPanel(driver);
        resultsPage = new ResultsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test()
    private void SampleTestForChallenge(Method method) throws InterruptedException {
        startTest(method.getName(), "Verify second product of amazon.");

        getTest().log(Status.INFO , "1. Click 'All' in top menu.");
        headerPanel.navigateToInHeaderPanel("All");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "2. Scroll down to 'Show by category' element.");
        commonCommands.scrollDownToElementWithText("shop by category");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "3. Click on 'TV, Appliances, Electronics' element.");
        commonCommands.clickElementByText("TV, Appliances, Electronics");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "4. Click on 'Televisions' element.");
        commonCommands.clickElementByText("Televisions");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "5. Scroll down to 'Brands' element.");
        commonCommands.scrollDownToElementWithText("Brands");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "6. Click on 'Samsung' element.");
        categoryPanel.navigateToInCategoryPanel("Samsung");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "7. Sort the result list.");
        resultsPage.sortBy("Price: Low to High");
        Thread.sleep(1000);

        getTest().log(Status.INFO, "8. Sort the result list.");
        resultsPage.selectItemByPosition(2);
        Thread.sleep(1000);

        getTest().log(Status.INFO, "9. Switch to the other tab");
        commonCommands.switchToTab(1);
        Thread.sleep(1000);

        getTest().log(Status.INFO, "10. Verify visibility of label 'About this item'.");
        boolean isLabelVisible = productDetailsPage.isElementPresentInPageByText("About this item");
        Assert.assertTrue(isLabelVisible);
        Thread.sleep(1000);
    }
}


