package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.UserPage;
import utils.SeleniumHelper;

public class CorrectUserLoginTestCase extends BaseTest {

    @BeforeMethod
    public void before(){
        SeleniumHelper.registerUser(driver);
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
        DeleteAccountPage deleteAccountPage = userPage
                .deleteAccount();
        Assert.assertEquals(deleteAccountPage.getDeleteAccountInfo().getText(), "ACCOUNT DELETED!");
    }
}
