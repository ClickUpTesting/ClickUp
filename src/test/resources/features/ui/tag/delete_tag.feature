@GUI @Tag
Feature: Delete a tag

  @Smoke @AddTagToTask @DeleteTask
  Scenario: Delete a tag in a task
    Given I login to click up as an admin
    And I navigate to a task menu
    When I delete a tag
    Then I verify that the tag has been deleted