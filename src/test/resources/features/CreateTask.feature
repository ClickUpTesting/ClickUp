Feature: Create Tasks

  @Task @FunctionalTesting
  Scenario: As a manager I want to create an Individual

    Given I build a "POST" request
    When I create a new "Task" with parameters:
    Then I verify that the response is "OK"

