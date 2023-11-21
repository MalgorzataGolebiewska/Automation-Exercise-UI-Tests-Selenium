package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    @FindBy(xpath = "//li[10]/a")
    private WebElement loggedName;

    @FindBy(xpath = "//div/ul[@class='nav navbar-nav']/li[5]/a")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//div//ul/li[4]")
    private WebElement logoutButton;

    private final WebDriver driver;

    public UserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getLoggedName() {
        return loggedName;
    }

    public DeleteAccountPage deleteAccount() {
        deleteAccountButton.click();
        return new DeleteAccountPage(driver);
    }

    public SignupLoginPage clickLogoutButton() {
        logoutButton.click();
        return new SignupLoginPage(driver);
    }

}
