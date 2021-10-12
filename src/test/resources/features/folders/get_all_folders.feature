Feature: Get all Folders

  @DeleteFolders
  Scenario: As a user I want to get all folders and verity the quantity
    Given I get the initial amount of not archived folders
      And I set the folder with request endpoint to /space/{space_id}/folder
      And I set the query parameters as:
      | archived | false |
    When I add the amount of 2 to the total of folders
      And I execute the GET request
    Then I verify the amount of folders has increased by 2
      And I verify that the response status is 200