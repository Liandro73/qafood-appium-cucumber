package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import br.com.liandro.qafood.utils.enuns.SwipeDirection;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;

public class RestaurantPageObject extends PageObjectHelper {

    @AndroidFindBy(accessibility = "open-cart-button")
    @iOSXCUITFindBy(accessibility = "open-cart-button")
    private WebElement btnGoToCart;

    public RestaurantPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnAddFoodItemOnTheCart_Random() {
        int foodItemListNumber = randomNumber(3);

        if (Platform.IOS.equals(getPlatform())) {
            WebElement cardFoodStore = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name='add-item-buttom'])[" + (foodItemListNumber + 1) + "]"));
            checkElementIsVisible(cardFoodStore);
            clickOnElement(cardFoodStore);
        }
        if (Platform.ANDROID.equals(getPlatform())) {
            WebElement cardFoodStore = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='add-item-buttom'])[" + (foodItemListNumber + 1) + "]"));
            checkElementIsVisible(cardFoodStore);
            clickOnElement(cardFoodStore);
        }
    }

    public void clickOnGoToCartButton() {
        checkElementIsVisible(btnGoToCart);
        clickOnElement(btnGoToCart);
    }


}
