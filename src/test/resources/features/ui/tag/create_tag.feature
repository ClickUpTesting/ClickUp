@GUI @Tag
Feature: Create Tag

  @Smoke @CreateTask @DeleteTask
  Scenario: Create a tag with default settings
    Given I login to click up as an admin
      And I navigate to a task menu
    When I create a tag with the following parameters
      | name | my tag created |
    Then I verify that the tag contains the configured values

