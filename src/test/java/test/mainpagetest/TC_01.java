package test.mainpagetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class TC_01 extends TestBaseReport {
    @Test()
    public void homePageVerification() {
        extentTest = extentReports.createTest("User go to home page and verify that home page is opened","User go to home page and verify that home page is opened");
        // Go to https://www.smartcardlink.com as a visitor
        // 1- The Browser opens
        // 2- Enter the URL
        // 3- Press the Enter Key
        Driver.getDriver().get(ConfigReader.getProperty("sAdminUrl"));
        extentTest.info("User go to home page");

        // 4- Verify that home page is opened
        String expectedUrl = "https://www.smartcardlink.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Home page did not open");

        extentTest.pass("Testing access to the Home Page");

        // 5- Close the Browser
        Driver.closeDriver();
        extentTest.info("The browser closes");


    }


}
