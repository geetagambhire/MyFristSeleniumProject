package com.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
public static WebDriver driver;

public static Properties prop;
public BasePage() {
    try {
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop.load(ip);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@BeforeMethod
public void initialization() {
    String browserName = prop.getProperty("browser");

    if (browserName.equalsIgnoreCase("chrome")) {
        driver = new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("firefox")) {
        driver = new FirefoxDriver();
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    
    driver.get(prop.getProperty("url"));
}

@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}