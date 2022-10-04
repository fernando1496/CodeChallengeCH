import base.Base;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest extends Base{

    @BeforeClass
    private void beforeClass() {

    }

    @Test()
    private void tempTest()  {
        logger = extent.createTest(testName);
        logger.log(Status.INFO, "Opened site");
        logger.log(Status.PASS, "");
    }
}
