//package com.udacity.jwdnd.course1.cloudstorage.TestPages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class HomeTest {
//
//    private WebDriver webDriver;
//    @FindBy(id = "nav-notes-tab")
//    private WebElement notesTab;
//
//    @FindBy(id = "nav-credentials-tab")
//    private WebElement credentialsTab;
//
//    @FindBy(id = "logoutButton")
//    private WebElement logout;
//
//    public HomeTest(WebDriver driver){
//        PageFactory.initElements(driver, this);
//        this.webDriver = driver;
//    }
//
//    public void logoutButton(){
//        logout.click();
//    }
//
//    public void addNewNote(String noteTitle, String noteDescription){
//        WebDriverWait wait = new WebDriverWait(webDriver, 20);
//        notesTab.click();
//
//        WebElement notesTabButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewNoteModal")));
//        notesTabButton.click();
//
//        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ById.id("note-title")));
//        title.sendKeys(noteTitle);
//
//        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ById.id("note-description")));
//        description.sendKeys(noteDescription);
//
//        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.id("save-changes")));
//        save.click();
//    }
//
//    public void editNote(WebElement editElement, String noteTitle, String noteDescription){
//        WebDriverWait wait = new WebDriverWait(webDriver, 20);
//        notesTab.click();
//
//        WebElement notesTabButton = wait.until(ExpectedConditions.elementToBeClickable(editElement));
//        notesTabButton.click();
//
//        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ById.id("note-title")));
//        title.clear();
//        title.sendKeys(noteTitle);
//
//        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ById.id("note-description")));
//        description.clear();
//        description.sendKeys(noteDescription);
//
//        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.id("save-changes")));
//        save.click();
//    }
//
//    public void deleteNote(WebElement deleteElement){
//        WebElement button = deleteElement.findElement(By.cssSelector("td:nth-child(1) a.btn-danger"));
//        WebDriverWait wait = new WebDriverWait(this.webDriver, 20);
//        notesTab.click();
//
//        WebElement element0 = wait.until(ExpectedConditions.elementToBeClickable(button));
//        element0.click();
//    }
//
//    public void addCredential(String credentialUrl, String credentialUserName, String credentialPassword){
//        credentialsTab.click();
//
//        WebDriverWait wait = new WebDriverWait(webDriver,20);
//        WebElement credentialButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addCredentialModal")));
//        credentialButton.click();
//
//        WebElement cUrl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credential-url")));
//        cUrl.sendKeys(credentialUrl);
//
//        WebElement cUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credential-username")));
//        cUserName.sendKeys(credentialUserName);
//
//        WebElement cPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credential-password")));
//        cPassword.sendKeys(credentialPassword);
//
//        WebElement saveChanges = wait.until(ExpectedConditions.elementToBeClickable(By.id("credential-save-changes")));
//        saveChanges.click();
//    }
//
//    public void editCredentials(WebElement editElement, String editCredentialUrl, String editCredentialUserName, String editCredentialPassword){
//        credentialsTab.click();
//
//        WebDriverWait wait = new WebDriverWait(webDriver,20);
//        WebElement credentialButton = wait.until(ExpectedConditions.elementToBeClickable(editElement));
//        credentialButton.click();
//
//        WebElement cUrl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credential-url")));
//        cUrl.sendKeys(editCredentialUrl);
//
//        WebElement cUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credential-username")));
//        cUserName.sendKeys(editCredentialUserName);
//
//        WebElement cPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("credential-password")));
//        cPassword.sendKeys(editCredentialPassword);
//
//        WebElement saveChanges = wait.until(ExpectedConditions.elementToBeClickable(By.id("credential-save-changes")));
//        saveChanges.click();
//    }
//
//    public void deleteCredential(WebElement deleteElement) {
//        WebElement deleteButton = deleteElement.findElement(By.cssSelector("td:nth-child(1) a.btn-danger"));
//
//        WebDriverWait wait = new WebDriverWait(this.webDriver, 20);
//        credentialsTab.click();
//
//        WebElement element0 = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
//        element0.click();
//    }
//}
