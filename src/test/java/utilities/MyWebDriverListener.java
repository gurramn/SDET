package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyWebDriverListener extends Base implements WebDriverListener {



    public void beforeFindElement(WebDriver driver, By locator) {
        test.info("Before find element"+locator.toString());
        System.out.println("Before find element");
    }

    /**
     * This method will be called after {@link WebDriver#findElement(By)} is called.
     *
     * @param driver - decorated WebDriver instance
     * @param locator - locator used to find the element
     * @param result - found WebElement
     */
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        test.info("After find element");
    }
    public void beforeClick(WebElement element) {
        test.info("Before click");

    }



    /**
     * This action will be performed each time after {@link WebElement#click()} is called.
     *
     * @param element - decorated WebElement instance
     */
    public void afterClick(WebElement element) {
        test.info("After click");
    }


}
