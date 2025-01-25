package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

   @Test
    public void verifyDashboardElements(){

       LoginPage loginPage = new LoginPage(driver);
       loginPage.enterUsername("Admin");
       loginPage.enterPassword("admin123");
       loginPage.clickLoginButton();

       DashboardPage dashboardPage = new DashboardPage(driver);

       Assert.assertTrue(dashboardPage.isQuickLaunchVisible(),"Quick Launch item not Visible");
       Assert.assertTrue(dashboardPage.isLeaveListVisible(),"Leave List is Not Visible");
       Assert.assertTrue(dashboardPage.isEmployeeDistributionVisible(),"Employment Distribution is Not Visible");

       dashboardPage.Logout();

       Assert.assertTrue(dashboardPage.isOnLoginPage(),"Logout Failed, User is not redirected to Login");

   }

}
