package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){
        webDriverType.toUpperCase();
        driver = new ChromeDriver();
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
}
