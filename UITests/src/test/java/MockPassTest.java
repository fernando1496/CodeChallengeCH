import base.Base;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static extentReports.ExtentTestManager.getTest;
import static extentReports.ExtentTestManager.startTest;


public class MockPassTest extends Base{

    @Test()
    private void SamplePassTestForReportOne(Method method) {
        startTest(method.getName(), "SamplePassTestForReportOne");

        getTest().log(Status.INFO, "1. Test One Step 1");
        getTest().log(Status.INFO, "2. Test One Step 2");
        getTest().log(Status.INFO, "3. Test One Step 3");
        getTest().log(Status.INFO, "4. Test One Step 4");
        getTest().log(Status.INFO, "5. Test One Step 5");
        Assert.assertEquals(1,1);
    }

    @Test(dependsOnMethods = "SamplePassTestForReportOne")
    private void SamplePassTestForReportTwo(Method method) {
        startTest(method.getName(), "SamplePassTestForReportTwo");
        getTest().log(Status.INFO, "1. Test Two Step 1");
        getTest().log(Status.INFO, "2. Test Two Step 2");
        getTest().log(Status.INFO, "3. Test Two Step 3");
        getTest().log(Status.INFO, "4. Test Two Step 4");
        getTest().log(Status.INFO, "5. Test Two Step 5");
        Assert.assertTrue(true);
    }
}


