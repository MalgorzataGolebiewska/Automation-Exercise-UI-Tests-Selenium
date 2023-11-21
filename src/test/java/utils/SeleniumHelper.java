package utils;

import models.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.UserPage;

import java.time.Duration;

public class SeleniumHelper {

    public static void waitForLocator(By locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void registerUser(WebDriver driver){

        UserData userData = new UserData();

        HomePage homePage = new HomePage(driver)
                .openSignupLoginPage()
                .createAccountPage(userData)
                .openAccountCreatedPage(userData)
                .openUserPage()
                .clickLogoutButton()
                .clickLogoImg();

        Assert.assertEquals(homePage.getPageCenterTitle().getText(), "FEATURES ITEMS");

    }

    public static void deleteUser(WebDriver driver){

        UserData userData = new UserData();

        HomePage homePage = new HomePage(driver);
        SignupLoginPage signupLoginPage = homePage
                .openSignupLoginPage();
        UserPage userPage = signupLoginPage
                .loginToAccount(userData);
        Assert.assertEquals(userPage.getLoggedName().getText(), "Logged in as " + userData.getName());
        DeleteAccountPage deleteAccountPage = userPage
                .deleteAccount();
        Assert.assertEquals(deleteAccountPage.getDeleteAccountInfo().getText(), "ACCOUNT DELETED!");
    }

}