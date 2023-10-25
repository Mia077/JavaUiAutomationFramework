package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
       webDriverType.toUpperCase();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("The Chrome Driver is initialised. " + webDriverType.toUpperCase());

    }
     public static DriverManager getInstance(){
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance;
     }

     public WebDriver getDriver(){
        return driver;
     }
     public void tearDown(){
        driver.close();
        driver.quit();
        driver= null;
     }
}
