package pages;

import models.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ContactUsPage {

    @FindBy(xpath = "//div[@class='contact-form']/h2")
    private WebElement getInTouchText;

    @FindBy(xpath = "//div/input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//div/input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div/input[@name='subject']")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//div/input[@name='upload_file']")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//div/input[@name='submit']")
    private WebElement submitButton;

    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getGetInTouchText() {
        return getInTouchText;
    }

    public ContactUsPage fillContactData(UserData userData) {
        nameInput.sendKeys(userData.getName());
        emailInput.sendKeys(userData.getEmail());
        subjectInput.sendKeys("Subject Test");
        messageInput.sendKeys("Message Test");
        return this;
    }

    public ContactUsPage uploadFile(UserData userData) {
        String relativePath = userData.getFileToUpload();
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();
        uploadFileButton.sendKeys(absolutePath);
        return this;
    }

    public ContactUsMessagePage clickSubmitButton() {
        submitButton.click();
        driver.switchTo().alert().accept();
        return new ContactUsMessagePage(driver);
    }

}
