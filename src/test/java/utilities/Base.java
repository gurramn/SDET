package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Base {
    public ConfigDataProvider config;
    public ConfigExcelDataProvider excelData;

    ExtentReports reports;
    ExtentSparkReporter reporter;
    static ExtentTest test;
    public Base() {
        reporter = new ExtentSparkReporter("./Reports/ExtentReports.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    @BeforeSuite
    public void setDataProvider() {
        config = new ConfigDataProvider();
        excelData = new ConfigExcelDataProvider();

    }


}
