@GUI @CustomField
Feature: Create custom field formula

  @Smoke @CreateTaskInList @DeleteList
  Scenario: Create a custom field formula with default setting in a list
    Given I login to click up as an admin
      And I navigate to a list menu
    When I create a new custom field formula with field
      | name | New custom formula |
    Then I verify that the created list contains the default values of formula