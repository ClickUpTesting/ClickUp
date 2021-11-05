@API @Folder
Feature: Get Folder

  @Smoke @CreateFolder @DeleteFolder
  Scenario: As a user I want to get a folder
    Given I set the folder with request endpoint to /folder/{folder_id}
    When I execute the GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/folder/create_folder.json