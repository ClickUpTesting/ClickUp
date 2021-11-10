@GUI @Workspace
Feature: Create Workspace

  @Smoke @CreateWorkspace @DeleteWorkspace
  Scenario: Create a Workspace with default setting
    Given I login to click up as an admin
      And I navigate to a workspace menu
    When I update a workspace with the following parameters
      | name | My workspace Updated |
    Then I verify that the created workspace contains the default values
