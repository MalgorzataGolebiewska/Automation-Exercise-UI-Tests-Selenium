package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasePage;

public class TestCasePageTestCase extends BaseTest {

    @Test
    public void TestCasePage() {

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageCenterTitle().getText(), "FEATURES ITEMS");
        TestCasePage testCasePage = homePage
                .openTestCasePage();
        Assert.assertEquals(testCasePage.getPageHeader().getText(), "TEST CASES");
    }

}
