package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsMessagePage {

    @FindBy(xpath = "//div[@class='contact-form']/div[2]")
    private WebElement verifyMessage;

    @FindBy(xpath = "//div/a[@class='btn btn-success']")
    private WebElement homeButton;

    private final WebDriver driver;

    public ContactUsMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getVerifyMessage() {
        return verifyMessage;
    }

    public HomePage clickHomeButton() {
        homeButton.click();
        return new HomePage(driver);
    }

}
