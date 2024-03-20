//package com.udacity.jwdnd.course1.cloudstorage.TestPages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class SignupTest {
//
//    @FindBy(id = "inputFirstName")
//    private WebElement firstName;
//
//    @FindBy(id = "inputLastName")
//    private WebElement lastName;
//
//    @FindBy(id = "inputUsername")
//    private WebElement userName;
//
//    @FindBy(id = "inputPassword")
//    private WebElement password;
//
//    @FindBy(id = "buttonSignUp")
//    private WebElement signupButton;
//
//    public SignupTest(WebDriver driver){
//        PageFactory.initElements(driver, this);
//    }
//
//    public void signup(String userFirstName, String userLastName, String username, String userPassword){
//        firstName.sendKeys(userFirstName);
//        lastName.sendKeys(userLastName);
//        userName.sendKeys(username);
//        password.sendKeys(userPassword);
//        signupButton.click();
//    }
//}
