Feature: Login

  @Login
  Scenario:Login to the-internet page
    Given I navigate to the internet page
    When I login successfully
    Then I verify the security page message

