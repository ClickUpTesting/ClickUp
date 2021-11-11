@GUI @Workspace
Feature: Delete a workspace

  @Smoke @CreateWorkspace
  Scenario: Delete a workspace
    Given I login to click up as an admin
      And I navigate to a workspace menu
    When I delete a workspace
    Then I verify that the workspace does not exist in the list of workspace