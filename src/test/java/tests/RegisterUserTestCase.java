package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterUserTestCase extends BaseTest {

    @Test
    public void registerUser() {
        //given
        UserData userData = new UserData();
        //when
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageCenterTitle().getText(), "FEATURES ITEMS");
        //going to the login page
        SignupLoginPage signupLoginPage = homePage
                .openSignupLoginPage();
        Assert.assertEquals(signupLoginPage.getNewUserSignupHeader().getText(), "New User Signup!");
        //creating a new account
        CreateAccountPage createAccountPage = signupLoginPage
                .createAccountPage(userData);
        Assert.assertEquals(createAccountPage.getEnterAccountHeader().getText(), "ENTER ACCOUNT INFORMATION");
        //completing user data
        AccountCreatedPage accountCreatedPage = createAccountPage
                .openAccountCreatedPage(userData);
        Assert.assertEquals(accountCreatedPage.getAccountCreatedHeader().getText(), "ACCOUNT CREATED!");
        //the user has logged in correctly
        UserPage userPage = accountCreatedPage
                .openUserPage();
        Assert.assertEquals(userPage.getLoggedName().getText(), "Logged in as " + userData.getName());
        //deleting a user account
        DeleteAccountPage deleteAccountPage = userPage
                .deleteAccount();
        Assert.assertEquals(deleteAccountPage.getDeleteAccountInfo().getText(), "ACCOUNT DELETED!");
        //after deleting the user, go to the main page
        HomePage backToHomePage = deleteAccountPage
                .homePageReturn();
        Assert.assertEquals(backToHomePage.getPageCenterTitle().getText(), "FEATURES ITEMS");
    }

}
