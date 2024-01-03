package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/h2/b")
    private WebElement pageHeader;

        private final WebDriver driver;

        public TestCasePage (WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

    public WebElement getPageHeader() {
        return pageHeader;
    }
}
