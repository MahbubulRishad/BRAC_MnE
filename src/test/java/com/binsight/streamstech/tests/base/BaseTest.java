package com.binsight.streamstech.tests.base;

import com.binsight.streamstech.base.BasePage;
import com.binsight.streamstech.base.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected   WebDriver driver;
    private final Properties properties;

    public Page page;
//    public BasePage basePage;

    public BaseTest() {
        String filePah = System.getProperty("user.dir") + File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"config.properties";
        properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(filePah);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void browserSetUp() {
        String browserName = properties.getProperty("browserName");

        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headless")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browserName.equalsIgnoreCase("chromeHeadless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("chromeHeadless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            System.out.println("please provide a browser");
        }

        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();

         page = new BasePage(driver);
//         basePage = new BasePage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String getUsername(){
        return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

    public String getGroupType(){
        return properties.getProperty("groupType");
    }
}
