package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(css= "#input-lastname")
    private WebElement lastNameInput;

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyToggle;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueBtn;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String password, boolean toogle){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        if (toogle){
            ScrollManager.scrollToTheElement(privacyToggle);
            privacyToggle.click();
        }
    }
    public void clickTheContinueBtn(){
        continueBtn.click();
    }
}
