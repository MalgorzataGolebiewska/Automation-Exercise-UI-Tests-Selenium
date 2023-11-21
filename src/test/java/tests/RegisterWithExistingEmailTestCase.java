package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.SeleniumHelper;

public class RegisterWithExistingEmailTestCase extends BaseTest{

    @BeforeMethod
    public void before(){
        SeleniumHelper.registerUser(driver);
    }

    @AfterMethod
    public void after(){
        SeleniumHelper.deleteUser(driver);
    }

    @Test
    public void registerUserWithExistingEmail(){
        UserData userData = new UserData();

        SignupLoginPage signupLoginPage = new HomePage(driver)
                .openSignupLoginPage()
                .useRegistedData(userData);

        Assert.assertEquals(signupLoginPage.getLoginUserHeader().getText(),"Login to your account");
        Assert.assertEquals(signupLoginPage.getEmailExistText().getText(),"Email Address already exist!");


    }
}
