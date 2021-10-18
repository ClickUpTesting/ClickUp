Feature: Get all Spaces

  @API @RegressionTesting @DeleteSpaces
  Scenario: As a user I want to get all spaces and verity the quantity
    Given I get the initial amount of not archived spaces
    And I set the space with request endpoint to /team/{team_id}/space
    And I set the query parameters as:
      | archived | false |
    When I add the amount of 2 to the total of spaces
    And I execute the GET request
    Then I verify the amount of spaces has increased by 2
    And I verify that the response status is 200