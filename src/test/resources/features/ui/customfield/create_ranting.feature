@GUI @CustomField
Feature: Create custom field ranting

  @Smoke @CreateTaskInList @DeleteList
  Scenario: Create a custom field ranting with default setting in a list
    Given I login to click up as an admin
      And I navigate to a list menu
    When I create a new custom field ranting with field
      | name | New custom field ranting |
    Then I verify that the created list contains the default values of ranting