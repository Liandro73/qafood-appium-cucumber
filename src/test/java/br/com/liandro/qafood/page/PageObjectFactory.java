package br.com.liandro.qafood.page;

import br.com.liandro.qafood.page.object.*;
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
    private RestaurantPageObject restaurantPageObject;
    private CartPageObject cartPageObject;
    private CheckoutPageObject checkoutPageObject;
    private OrderPageObject orderPageObject;

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

    public RestaurantPageObject getRestaurantPageObject() {
        if (this.restaurantPageObject == null) {
            this.restaurantPageObject = new RestaurantPageObject(driver);
        }
        return  this.restaurantPageObject;
    }

    public CartPageObject getCartPageObject() {
        if (this.cartPageObject == null) {
            this.cartPageObject = new CartPageObject(driver);
        }
        return  this.cartPageObject;
    }

    public CheckoutPageObject getCheckoutPageObject() {
        if (this.checkoutPageObject == null) {
            this.checkoutPageObject = new CheckoutPageObject(driver);
        }
        return  this.checkoutPageObject;
    }

    public OrderPageObject getOrderPageObject() {
        if (this.orderPageObject == null) {
            this.orderPageObject = new OrderPageObject(driver);
        }
        return  this.orderPageObject;
    }

}
