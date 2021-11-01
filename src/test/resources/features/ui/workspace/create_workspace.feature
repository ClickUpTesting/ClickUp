@GUI @Workspace
Feature: Create Workspace

  @Smoke @DeleteWorkspace
  Scenario: Create a Workspace with default setting
    Given I login to click up as an admin
    When I create a new workspace with field
      | name | New workspace random |
    Then I verify that the created workspace contains the default values

