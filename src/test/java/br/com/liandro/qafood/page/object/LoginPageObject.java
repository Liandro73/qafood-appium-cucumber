package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends PageObjectHelper {

    @AndroidFindBy(accessibility = "email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='email']")
    private WebElement inputEmail;

    @AndroidFindBy(accessibility = "password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='password']")
    private WebElement inputPassword;

    @AndroidFindBy(accessibility = "login-button")
    @iOSXCUITFindBy(accessibility = "login-button")
    private WebElement btnLogin;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkThatInputEmailIsDisplayed() {
        waitVisibilityOfElement(inputEmail);
    }

    public void fillInputEmail(String email) {
        checkElementIsVisible(btnLogin);
        inputEmail.sendKeys(email);
    }

    public void fillInputPassword(String password) {
        checkElementIsVisible(btnLogin);
        inputPassword.sendKeys(password);
    }

    public void clickOnLoginButton() {
        checkElementIsVisible(btnLogin);
        clickOnElement(btnLogin);
    }

}
