package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseReport {

    protected static ExtentReports extentReports;

    protected static ExtentTest extentTest; //It is used to start, monitor and finalize your tests. It logs the steps and statuses of the test (success, failure, warnings, etc.).

    protected static ExtentHtmlReporter extentHtmlReporter; //It is used to save test results in HTML format and create visual reports.

    @BeforeTest(alwaysRun = true) //Always work first
    public void setUpTest() {
        extentReports = new ExtentReports(); //Starts Reporting
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Report" + date + ".html"; //After the report is created, I specify where the report will be uploaded.

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // Chrome
        extentReports.setSystemInfo("Automation Engineer", "Ömer Celebi");

        extentHtmlReporter.config().setDocumentTitle("TestNG Test");
        extentHtmlReporter.config().setDocumentTitle("TestNG Reports");

    }

    @AfterMethod(alwaysRun = true) // After each test method, if there is an error in the test, it takes a screenshot and adds it to the report.
    public void tearDownMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
        }

    }


}
