package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CartPageObject extends PageObjectHelper {

    @AndroidFindBy(accessibility = "confirm-order-button")
    @iOSXCUITFindBy(accessibility = "confirm-order-button")
    private WebElement btnConfirmOrder;

    public CartPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnConfirmOrderButton() throws IOException {
        takeScreenshot("selected item in the order");
        checkElementIsVisible(btnConfirmOrder);
        clickOnElement(btnConfirmOrder);
    }

}
