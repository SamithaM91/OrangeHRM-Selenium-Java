package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    private final WebDriverWait wait;

    //Locators
    private final By usernameField = By.xpath("//input[@placeholder='Username']");
    private final By passwordField = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By errorMessage = By.xpath("//p[text()[normalize-space()='Invalid credentials']]");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    @Step("Enter Username: {Username}")
    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Enter Password")
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Clock on Login Button")
    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Get Page Title")
    public String getPageTitle(){
        return driver.getTitle();
    }

    @Step("Get Invalid Login Error")
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    @Step("Check if Dashboard is displayed")
    public boolean isDashboardDisplayed(){
        return driver.getCurrentUrl().contains("dashboard");
    }


}
