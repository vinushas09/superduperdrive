package com.udacity.jwdnd.course1.cloudstorage.TestPages;

import org.h2.mvstore.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTest {

    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginTest(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String userPassword){
        username.sendKeys(userName);
        password.sendKeys(userPassword);
        loginButton.click();
    }
}
