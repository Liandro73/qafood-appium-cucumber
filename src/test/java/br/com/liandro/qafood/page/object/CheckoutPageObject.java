package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CheckoutPageObject extends PageObjectHelper {

    @AndroidFindBy(accessibility = "do-order-button")
    @iOSXCUITFindBy(accessibility = "do-order-button")
    private WebElement btnDoTheOrder;

    public CheckoutPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void selectThePaymentMethod_Random() throws IOException {
        int paymentMethodNumber = randomNumber(2);
        String paymentMethod;

        if (paymentMethodNumber == 0) {
            paymentMethod = "Cartão de crédito";
        } else {
            paymentMethod = "Dinheiro";
        }
        if (Platform.IOS.equals(getPlatform())) {
            WebElement cardFoodStore = driver.findElement(AppiumBy.accessibilityId(paymentMethod));
            swipeToElementIos(cardFoodStore);
            checkElementIsVisible(cardFoodStore);
            clickOnElement(cardFoodStore);
            takeScreenshot("payment method selected");
        } else if (Platform.ANDROID.equals(getPlatform())) {
            swipeToElementAndroid(paymentMethod);
            WebElement cardFoodStore = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"" + paymentMethod + "\"]"));
            checkElementIsVisible(cardFoodStore);
            clickOnElement(cardFoodStore);
            takeScreenshot("payment method selected");
        }
    }

    public void clickOnDoTheOrderButton() {
        checkElementIsVisible(btnDoTheOrder);
        clickOnElement(btnDoTheOrder);
    }

}
