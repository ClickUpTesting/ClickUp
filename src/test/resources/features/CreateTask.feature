Feature: Create Tasks

  @Task @FunctionalTesting
  Scenario: As a manager I want to create an Individual

    Given I build a "POST" request
    When I create a new "Task" with parameters:
      | name | task scenario 1|
    Then I verify that the response is 200
      And I verify that the parameters are correct

