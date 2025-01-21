package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    @Description("Test valid login functionality with correct username and password")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //Assertions
        Assert.assertTrue(loginPage.isDashboardDisplayed(),"Redirected to Dashboard upon successful login");

    }

    @Test
    @Description("Test invalid login functionality with incorrect username and password")
    public void testInvalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Sam");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();

        String invalidLogin = loginPage.getErrorMessage();
        Assert.assertEquals(invalidLogin,"Invalid credentials", "Unable to login: Invalid credentials");
    }

}
