package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;

public class IncorrectUserLoginTestCase extends BaseTest {

    @Test
    public void incorrectUserLoginTestCase() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageCenterTitle().getText(), "FEATURES ITEMS");

        SignupLoginPage signupLoginPage = homePage
                .openSignupLoginPage()
                .sendValidUserdata();
        Assert.assertEquals(signupLoginPage.getLoginUserHeader().getText(),"Login to your account");
        Assert.assertEquals(signupLoginPage.getErrorText().getText(), "Your email or password is incorrect!");

    }

}
