package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class OrderPageObject extends PageObjectHelper {

    @AndroidFindBy(accessibility = "order-sucess-txt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='order-sucess-txt']")
    private WebElement labelConfirmationThatOrderIsDone;

    public OrderPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkThatConfirmationThatOrderIsDoneTextIsDisplayed() {
        elementExistsAndIsDisplay(labelConfirmationThatOrderIsDone);
    }

}
