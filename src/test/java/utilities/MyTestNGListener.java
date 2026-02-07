package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyTestNGListener extends Base implements ITestListener {

    WebDriver driver;
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        test.info("test started");
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        // not implemented
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/Extent/Screenshot"+result.getName();
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }




    /**
     * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
     * tag and calling all their Configuration methods.
     *
     * @param context The test context
     */
    public void onStart(ITestContext context) {
        // not implemented
    }


    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
