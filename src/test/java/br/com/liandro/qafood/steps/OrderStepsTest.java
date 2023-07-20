package br.com.liandro.qafood.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class OrderStepsTest extends BaseSteps {

    public OrderStepsTest() {
    }

    /**
     * Order full process
     */
    @And("I add a product to the cart")
    public void iAddAProductToTheCart() throws IOException {
        homePageObject.clickOnSelectDeliveryAddressButton();
        homePageObject.clickOnAllowToUseLocationButton();
        homePageObject.clickOnCardFoodStore_Random();
        restaurantPageObject.clickOnAddFoodItemOnTheCart_Random();
        restaurantPageObject.clickOnGoToCartButton();
        cartPageObject.clickOnConfirmOrderButton();
        checkoutPageObject.selectThePaymentMethod_Random();
    }

    @When("I click on confirm order button")
    public void iClickOnConfirmOrderButton() {
        checkoutPageObject.clickOnDoTheOrderButton();
    }

    @Then("I should be redirected to the Order confirmation page")
    public void iShouldBeRedirectedToTheOrderConfirmationPage() {
        orderPageObject.checkThatConfirmationThatOrderIsDoneTextIsDisplayed();
    }

}
