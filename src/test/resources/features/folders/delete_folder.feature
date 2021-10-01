Feature: Delete Folder

  @CreateFolder
  Scenario: As a user I want to delete a folder
    Given I set the folder with request endpoint to /folder/{folder_id}
    When I execute the DELETE request
    Then I verify that the response status is 200