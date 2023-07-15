package br.com.liandro.qafood.page;

import br.com.liandro.qafood.page.object.HomePageObject;
import br.com.liandro.qafood.page.object.LoginPageObject;
import br.com.liandro.qafood.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectFactory {

    protected AppiumDriver driver;
    protected WebDriverWait waitDriver;

    private PageObjectHelper pageObjectHelper;
    private LoginPageObject loginPageObject;
    private HomePageObject homePageObject;

    public PageObjectFactory(AppiumDriver driver) {
        this.driver = driver;
        waitDriver = DriverManager.getWaitDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public PageObjectHelper getPageObjectHelper() {
        if (this.pageObjectHelper == null) {
            this.pageObjectHelper = new PageObjectHelper(driver);
        }
        return this.pageObjectHelper;
    }

    public LoginPageObject getLoginPageObject() {
        if (this.loginPageObject == null) {
            this.loginPageObject = new LoginPageObject(driver);
        }
        return this.loginPageObject;
    }

    public HomePageObject getHomePageObject() {
        if (this.homePageObject == null) {
            this.homePageObject = new HomePageObject(driver);
        }
        return this.homePageObject;
    }

}
