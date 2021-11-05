@GUI @Tag
Feature: Create Tag

  @Smoke @CreateTask @DeleteTask
  Scenario: Create a tag with default settings
    Given I login to click up as an admin
      And I open a new task
    When I create a tag with the following parameters
      | name | my tag created |
    Then I verify that the created tag contains the default values

