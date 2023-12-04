package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.UserPage;
import utils.SeleniumHelper;

public class LogOutUserTestCase extends BaseTest{

    @BeforeMethod
    public void before(){
        SeleniumHelper.registerUser(driver);
    }

    @AfterMethod
    public void after(){
        SeleniumHelper.deleteUser(driver);
    }

    @Test
    public void loginUserWithCorrectEmailAndPassword() {
        UserData userData = new UserData();

        SignupLoginPage signupLoginPage = new HomePage(driver)
                .openSignupLoginPage();
        Assert.assertEquals(signupLoginPage.getLoginUserHeader().getText(),"Login to your account");
        UserPage userPage = signupLoginPage
                .loginToAccount(userData);
        Assert.assertEquals(userPage.getLoggedName().getText(), "Logged in as " + userData.getName());
        SignupLoginPage signupLoginPageBack = userPage
                .clickLogoutButton();
        Assert.assertEquals(signupLoginPageBack.getLoginUserHeader().getText(), "Login to your account");
    }
}
