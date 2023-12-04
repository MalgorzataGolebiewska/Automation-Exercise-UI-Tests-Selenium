package pages;

import models.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupHeader;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class='login-form']/h2")
    private WebElement loginUserHeader;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div/div[@class='logo pull-left']")
    private WebElement logoImg;

    @FindBy(xpath = "//div[@class='login-form']/form/p")
    private WebElement errorText;

    @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/p")
    private WebElement emailExistText;

    private final WebDriver driver;

    public SignupLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getNewUserSignupHeader() {
        return newUserSignupHeader;
    }

    public CreateAccountPage createAccountPage(UserData userData) {
        nameInput.sendKeys(userData.getName());
        emailInput.sendKeys(userData.getEmail());
        signUpButton.click();
        return new CreateAccountPage(driver);
    }

    public WebElement getLoginUserHeader() {
        return loginUserHeader;
    }

    public UserPage loginToAccount(UserData userData) {
        loginEmailInput.sendKeys(userData.getEmail());
        loginPasswordInput.sendKeys(userData.getPassword());
        loginButton.click();
        return new UserPage(driver);
    }

    public HomePage clickLogoImg() {
        logoImg.click();
        return new HomePage(driver);
    }

    public SignupLoginPage sendValidUserdata() {
        loginEmailInput.sendKeys("login@lol.li");
        loginPasswordInput.sendKeys("test");
        loginButton.click();
        return this;
    }

    public SignupLoginPage useRegistedData(UserData userData) {
        nameInput.sendKeys(userData.getName());
        emailInput.sendKeys(userData.getEmail());
        signUpButton.click();
        return this;
    }

    public WebElement getEmailExistText() {
        return emailExistText;
    }

    public WebElement getErrorText() {
        return errorText;
    }

}
