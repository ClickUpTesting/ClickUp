@API @Folder
Feature: Update Folder

  @Smoke @CreateFolder @DeleteFolder
  Scenario: As a user I want to update a folder
    Given I set the folder with request endpoint to /folder/{folder_id}
    When I set the request body with following values:
      | name | Folder For Testing With New Name |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/folder/create_folder.json
