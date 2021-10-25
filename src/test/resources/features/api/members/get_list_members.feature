Feature: Get list members

  @API @SmokeTesting @Member @CreateListInSpace @DeleteList
  Scenario: As a user I want to get the space list's members
    Given I set the endpoint /list/{list_id}/member
    When I execute a GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/members/task_members.json

  @API @SmokeTesting @Member @CreateListInFolder @DeleteList
  Scenario: As a user I want to get the folder list's members
    Given I set the endpoint /list/{list_id}/member
    When I execute a GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/members/task_members.json