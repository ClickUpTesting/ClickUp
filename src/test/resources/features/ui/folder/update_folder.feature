@GUI @Folder @FolderUI
Feature: Update Folder

  @Smoke @CreateFolder @DeleteFolder
  Scenario: Update a folder with default setting
    Given I login to click up as an admin
      And I navigate to a folder menu
    When I update a new folder with field
      | name | New folder updated |
    Then I verify that the folder contains the default values