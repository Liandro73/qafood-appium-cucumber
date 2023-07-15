#language:en

  @Regressive
  Feature: : Login system
    Like as a registered user
    I want to access my account

    @Smoke @LoginSuccessfully
    Scenario Outline: Login successfully
      Given that I am on the Login page
      When I fill the fields email and password correctly "<email>" "<password>"
      And I click on Sign in button
      Then I should see the Home page

      Examples:
        | email           | password |
        | teste@teste.com | 123456   |

    @Smoke @Login
    Scenario Outline: Login full process
      Given that I do all process of the Login correctly "<email>" "<password>"

      Examples:
        | email           | password |
        | teste@teste.com | 123456   |