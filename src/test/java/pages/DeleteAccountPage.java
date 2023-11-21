package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {

    @FindBy(xpath = "//div/h2/b")
    private WebElement deleteAccountInfo;

    @FindBy(xpath = "//div[@class='pull-right']/a")
    private WebElement continueButton;

    private final WebDriver driver;

    public DeleteAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDeleteAccountInfo() {
        return deleteAccountInfo;
    }

    public HomePage homePageReturn() {
        continueButton.click();
        return new HomePage(driver);
    }

}
