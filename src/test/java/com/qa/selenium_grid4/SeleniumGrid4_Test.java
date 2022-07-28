package com.qa.selenium_grid4;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid4_Test {

    ExtentReports er = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Selenium_Grid4.html");

    public WebDriver driver;
    public DesiredCapabilities caps = new DesiredCapabilities();
    public String url = "";

    @Parameters({"Browser"})
    @BeforeTest
    public void BrowserLaunch(String Browser) throws MalformedURLException {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        er.attachReporter(spark);

        if (Browser.equals("chrome")) {
            caps.setPlatform(Platform.MAC);
            caps.setBrowserName("chrome");

            ChromeOptions options = new ChromeOptions();
            options.merge(caps);

        } else if (Browser.equals("safari")) {
            caps.setPlatform(Platform.MAC);
            caps.setBrowserName("safari");

            SafariOptions options = new SafariOptions();
            options.merge(caps);
        } else {
            caps.setPlatform(Platform.MAC);
            caps.setBrowserName("firefox");

            FirefoxOptions options = new FirefoxOptions();
            options.merge(caps);
        }


        driver = new RemoteWebDriver(new URL("http://192.168.1.93:4444"), caps);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        er.flush();
        driver.quit();
    }
}
