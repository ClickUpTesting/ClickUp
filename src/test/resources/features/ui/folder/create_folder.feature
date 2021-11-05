@GUI @Folder @FolderUI
Feature: Create Folder

  @Smoke @CreateSpace @DeleteSpace
  Scenario: Create a folder with default setting
    Given I login to click up as an admin
    When I create a new folder with field
      | name | New folder random |
    Then I verify that the created folder contains the default values
