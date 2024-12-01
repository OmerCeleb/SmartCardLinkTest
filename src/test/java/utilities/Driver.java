package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    /*
    POM (Page Object Model)
    A software testing method that allows test cases to be written with
    less code and be maintained more easily. We use the POM pattern in TESTNG and CUCUMBER.
     */

    private Driver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (driver == null) {
            switch (browser) {
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();

            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
