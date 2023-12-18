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

    @FindBy(xpath = "//div/ul/li[8]")
    private WebElement contactUsButton;

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

    public ContactUsPage openContactUsPage() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

}