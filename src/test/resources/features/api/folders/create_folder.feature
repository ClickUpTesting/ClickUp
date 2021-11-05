@API @Folder
Feature: Create Folder

  @Smoke @DeleteFolder
  Scenario: As a user I want to create a folder
    Given I set the folder with request endpoint to /space/{space_id}/folder
    When I set the request body with following values:
      | name | Folder For Testing |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/folder/create_folder.json
