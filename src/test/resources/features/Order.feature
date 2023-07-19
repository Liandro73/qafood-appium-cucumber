#language:en

@Regressive
Feature: : Order full process
  Like as a registered user
  I want to place an order

  @Smoke @OrderSuccessfully
  Scenario Outline: Order successfully
    Given that I do all process of the Login correctly "<email>" "<password>"
    And I add a product to the cart
    When I click on confirm order button
    Then I should be redirected to the Order confirmation page

    Examples:
      | email           | password |
      | teste@teste.com | 123456   |