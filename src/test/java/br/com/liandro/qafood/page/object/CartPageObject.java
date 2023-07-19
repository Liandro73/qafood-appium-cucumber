package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CartPageObject extends PageObjectHelper {

    @AndroidFindBy(accessibility = "confirm-order-button")
    @iOSXCUITFindBy(accessibility = "confirm-order-button")
    private WebElement btnConfirmOrder;

    public CartPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnConfirmOrderButton() {
        checkElementIsVisible(btnConfirmOrder);
        clickOnElement(btnConfirmOrder);
    }

}
