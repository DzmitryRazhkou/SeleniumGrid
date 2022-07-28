package com.qa.selenium_grid4;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class SeleniumGrid4_Test {

    ExtentReports er = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Selenium_Grid4.html");

    public WebDriver driver;

    @BeforeTest
    public void BrowserLaunch(){
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        er.attachReporter(spark);


    }
}
