package pages;

import models.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    private WebElement enterAccountHeader;

    @FindBy(id = "uniform-id_gender2")
    private WebElement mrsGenderRadio;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement optinCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement firstAddressInput;

    @FindBy(id = "address2")
    private WebElement secondAddressInput;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(tagName = "button")
    private WebElement createAccountButton;

    private final WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEnterAccountHeader() {
        return enterAccountHeader;
    }

    public AccountCreatedPage openAccountCreatedPage(UserData userData) {
        mrsGenderRadio.click();
        passwordInput.sendKeys(userData.getPassword());

        Select selectDay = new Select(daysSelect);
        selectDay.selectByVisibleText("5");

        Select selectMonth = new Select(monthsSelect);
        selectMonth.selectByVisibleText("August");

        Select selectYear = new Select(yearsSelect);
        selectYear.selectByVisibleText("2000");

        newsletterCheckbox.click();
        optinCheckbox.click();
        firstNameInput.sendKeys(userData.getFirstName());
        lastNameInput.sendKeys(userData.getLastName());
        companyInput.sendKeys(userData.getCompany());
        firstAddressInput.sendKeys(userData.getFirstAddress());
        secondAddressInput.sendKeys(userData.getSecondAddress());

        Select selectCountry = new Select(countrySelect);
        selectCountry.selectByVisibleText("Canada");

        stateInput.sendKeys(userData.getState());
        cityInput.sendKeys(userData.getCity());
        zipcodeInput.sendKeys(userData.getZipcode());
        mobileNumberInput.sendKeys(userData.getMobileNumber());

        createAccountButton.click();
        return new AccountCreatedPage(driver);
    }

}

