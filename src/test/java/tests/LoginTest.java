package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //Assertions
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(loginPage.getPageTitle(),expectedTitle,"Login Failed....");
    }
}
