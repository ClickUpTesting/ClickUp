Feature: keyPresses

  @keys
  Scenario: Type keys
    Given I navigate to Keys page
    When I type A and Back Space
    Then  You entered: BACK_SPACE message should be displayed