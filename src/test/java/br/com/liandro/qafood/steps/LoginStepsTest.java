package br.com.liandro.qafood.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsTest extends BaseSteps {

    public LoginStepsTest() {
    }

    /**
     * Login successfully
     */
    @Given("that I am on the Login page")
    public void thatIAmOnTheLoginPage() {
        loginPageObject.checkThatInputEmailIsDisplayed();
    }

    @And("I fill the fields email and password correctly {string} {string}")
    public void iFillTheFieldsEmailAndPasswordCorrectly(String email, String password) {
        loginPageObject.fillInputEmail(email);
        loginPageObject.fillInputPassword(password);
    }

    @When("I click on Sign in button")
    public void iClickOnButton() {
        loginPageObject.clickOnLoginButton();
    }

    @Then("I should see the Home page")
    public void iShouldSeeTheHomePage() {
        homePageObject.checkSelectDeliveryAddressIsDisplayed();
    }

    /**
     * Login full process
     */
    @Given("that I do all process of the Login correctly {string} {string}")
    public void thatIDoAllProcessOfTheLoginCorrectly(String email, String password) {
        loginPageObject.checkThatInputEmailIsDisplayed();
        loginPageObject.fillInputEmail(email);
        loginPageObject.fillInputPassword(password);
        loginPageObject.clickOnLoginButton();
        homePageObject.checkSelectDeliveryAddressIsDisplayed();
    }

}
