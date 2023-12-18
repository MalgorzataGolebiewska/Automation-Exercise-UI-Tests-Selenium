package tests;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsMessagePage;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsFormTestCase extends BaseTest {

    @Test
    public void contactUsForm() {
        UserData userData = new UserData();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageCenterTitle().getText(), "FEATURES ITEMS");

        ContactUsPage contactUsPage = homePage
                .openContactUsPage();
        Assert.assertEquals(contactUsPage.getGetInTouchText().getText(), "GET IN TOUCH");
        ContactUsMessagePage fillContactUsPage = contactUsPage
                .fillContactData(userData)
                .uploadFile(userData)
                .clickSubmitButton();
        Assert.assertEquals(fillContactUsPage.getVerifyMessage().getText(),"Success! Your details have been submitted successfully.");
        HomePage backToHomePage = fillContactUsPage
                .clickHomeButton();
        Assert.assertEquals(backToHomePage.getPageCenterTitle().getText(),"FEATURES ITEMS");
    }

}
