@GUI @FolderUI
Feature: Create Workspace

  @Smoke @CreateSpace @DeleteSpace
  Scenario: Create a folder with default setting
    Given I login to click up as an admin
#      And I navigate to workspace environment page
    When I create a new folder with field
      | name | New folder random |
    Then I verify that the created folder contains the default values
