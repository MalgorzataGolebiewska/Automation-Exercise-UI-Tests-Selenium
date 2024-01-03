package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

public class HomePage {
    @FindBy(xpath = "//div[@class='features_items']/h2")
    private WebElement pageCenterTitle;

    @FindBy(xpath = "//div/ul/li[4]")
    private WebElement signupLoginButton;

    @FindBy(xpath = "//div/ul/li[5]")
    private WebElement testCaseButton;

    @FindBy(id = "ad_position_box")
    private WebElement advertisment;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getPageCenterTitle() {
        SeleniumHelper.waitForElementToBeVisible(driver, pageCenterTitle);
        return pageCenterTitle;
    }

    public SignupLoginPage openSignupLoginPage() {
        signupLoginButton.click();
        return new SignupLoginPage(driver);
    }

    public TestCasePage openTestCasePage() {
        testCaseButton.click();
        //nie znalazłam innego rozwiązania na reklamę google, stąd odświeżenie i ponowne kliknięcie
        driver.navigate().refresh();
        testCaseButton.click();
        return new TestCasePage(driver);
    }
}
