package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {

        public WebDriver driver;
        private final WebDriverWait wait;

        //Locators
        private final By quickLaunch = By.xpath("//p[text()='Quick Launch']");
        private final By leaveList = By.xpath("//p[text()='Employees on Leave Today']");
        private final By employeeDistribution = By.xpath("//p[text()='Employee Distribution by Location']");
        private final By userDropDown = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
        private final By logoutButton = By.xpath("//a[text()='Logout']");

        //Constructor
        public DashboardPage(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        //Actions
        public boolean isQuickLaunchVisible(){
            try {
                System.out.println("Waiting for the Quick Launch element to become visible...");
                wait.until(ExpectedConditions.visibilityOfElementLocated(quickLaunch)).isDisplayed();
                return true;
            } catch (TimeoutException e) {
                System.out.println("Quick Launch element is not visible.");
                return false;
            }

           // return wait.until(ExpectedConditions.visibilityOfElementLocated(quickLaunch)).isDisplayed();
        }

        public boolean isLeaveListVisible(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveList)).isDisplayed();
        }

        public boolean isEmployeeDistributionVisible(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDistribution)).isDisplayed();
        }

        public void Logout(){
            wait.until(ExpectedConditions.elementToBeClickable(userDropDown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        }

        public boolean isOnLoginPage(){
            String currentUrl = driver.getCurrentUrl();
            Assert.assertNotNull(currentUrl,"The current URL is null");
            return currentUrl.contains("login");
        }


}
