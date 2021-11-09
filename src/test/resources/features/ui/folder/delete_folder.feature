@GUI @Folder @FolderUI
Feature: Delete a folder

  @Smoke @CreateFolder
  Scenario: Delete a folder in a space
    Given I login to click up as an admin
      And I navigate to a folder menu
    When I delete a folder
    Then I verify that the folder does not exist in the space