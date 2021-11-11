@GUI @Workspace
Feature: Delete a task

  @Smoke @CreateWorkspace
  Scenario: Delete a workspace in a list
    Given I login to click up as an admin
      And I navigate to a workspace menu
    When I delete a workspace
    Then I verify that the workspace does not exist in the list of workspace