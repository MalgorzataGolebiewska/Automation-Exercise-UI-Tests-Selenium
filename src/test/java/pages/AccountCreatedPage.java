package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    @FindBy(xpath = "//h2[@class='title text-center']/b")
    private WebElement accountCreatedHeader;

    @FindBy(xpath = "//div[@class='pull-right']")
    private WebElement continueButton;

    private final WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAccountCreatedHeader() {
        return accountCreatedHeader;
    }

    public UserPage openUserPage() {
        continueButton.click();
        return new UserPage(driver);
    }

}
