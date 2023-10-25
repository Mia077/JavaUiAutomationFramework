package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();

        //new window
        driver.switchTo().newWindow(WindowType.TAB);


        driver.get("https://andreisecuqa.host/");

        Thread.sleep(1000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataGenerator.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataGenerator.generateLastName();
        lastNameInput.sendKeys(lastName);
        //lastNameInput.sendKeys("Pettrescu");
        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        //emailInput.sendKeys("Nicupetrescu@gmail.com");
        String email = RandomDataGenerator.generateRandomEmail();
        emailInput.sendKeys(email);
        System.out.println(email);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        //passwordInput.sendKeys("Tos2day");
        String password = RandomDataGenerator.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);
        //------
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement privacyPolicy1 = driver.findElement(By.xpath("//input[@name='agree']"));
        js.executeScript("arguments[0].scrollIntoView(true);", privacyPolicy1);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='agree']")));
///
        Thread.sleep(2000);
        privacyPolicy1.click();

        WebElement registerBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        registerBtn.click();
        Thread.sleep(5000);
        System.out.println("the execution is over.");

        driver.close();
        driver.quit();

    }
}