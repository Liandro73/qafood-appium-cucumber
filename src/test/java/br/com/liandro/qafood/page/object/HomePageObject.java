package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import br.com.liandro.qafood.utils.enuns.SwipeDirection;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;

public class HomePageObject extends PageObjectHelper {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Selecione seu endereço...']")
    @iOSXCUITFindBy(accessibility = "address-button")
    private WebElement btnSelectDeliveryAddress;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='PERMITIR']")
    @iOSXCUITFindBy(accessibility = "Permitir")
    private WebElement btnAllowingToUseLocation;

    public HomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkSelectDeliveryAddressIsDisplayed() {
        waitVisibilityOfElement(btnSelectDeliveryAddress);
    }

    public void clickOnSelectDeliveryAddressButton() {
        clickOnElement(btnSelectDeliveryAddress);
    }

    public void clickOnAllowToUseLocationButton() {
        checkElementIsVisible(btnAllowingToUseLocation);
        clickOnElement(btnAllowingToUseLocation);
    }

    public void clickOnCardFoodStore_Random() {
        swipe(SwipeDirection.SWIPE_DOWN);

        int storeCardListNumber = randomNumber(6);

        if (Platform.IOS.equals(getPlatform())) {
            WebElement cardFoodStore = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name='store-list-item'])[" + (storeCardListNumber + 1) + "]"));
            checkElementIsVisible(cardFoodStore);
            clickOnElement(cardFoodStore);
        } else if (Platform.ANDROID.equals(getPlatform())) {
            WebElement cardFoodStore = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='store-list-item'])[" + (storeCardListNumber + 1) + "]"));
            checkElementIsVisible(cardFoodStore);
            clickOnElement(cardFoodStore);
        }
    }

}
