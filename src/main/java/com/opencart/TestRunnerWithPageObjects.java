package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGenerator;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        String email = RandomDataGenerator.generateRandomEmail();
        String password = RandomDataGenerator.generatePassword();
        System.out.println(email);
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataGenerator.generateFirstName(), RandomDataGenerator.generateLastName(), email, password, true);
        registerPage.clickTheContinueBtn();


        DriverManager.getInstance().tearDown();
        System.out.println("The execution is over.");
    }
}