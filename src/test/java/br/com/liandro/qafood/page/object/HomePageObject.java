package br.com.liandro.qafood.page.object;

import br.com.liandro.qafood.page.PageObjectHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomePageObject extends PageObjectHelper {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Selecione seu endereço...']")
    @iOSXCUITFindBy(accessibility = "address-button")
    private WebElement selectDeliveryAddress;

    public HomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkSelectDeliveryAddressIsDisplayed() {
        waitVisibilityOfElement(selectDeliveryAddress);
    }

}
