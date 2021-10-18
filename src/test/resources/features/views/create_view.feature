Feature: Create View

  @API @SmokeTesting @DeleteView
  Scenario: As a user I want to create a Team View
    Given I set the view with request endpoint to /team/{team_id}/view
    When I set the view body with following values:
      | name | Team View For Testing |
      And I execute the POST request for views
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/views/create_view.json

  @API @SmokeTesting @DeleteView
  Scenario: As a user I want to create a Space View
    Given I set the view with request endpoint to /space/{space_id}/view
    When I set the view body with following values:
      | name | Space View For Testing |
      And I execute the POST request for views
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/views/create_view.json

  @API @SmokeTesting @DeleteView
  Scenario: As a user I want to create a Folder View
    Given I set the view with request endpoint to /folder/{folder_id}/view
    When I set the view body with following values:
      | name | Folder View For Testing |
      And I execute the POST request for views
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/views/create_view.json

  @API @SmokeTesting @DeleteView
  Scenario: As a user I want to create a List View
    Given I set the view with request endpoint to /list/{list_id}/view
    When I set the view body with following values:
      | name | List View For Testing |
      And I execute the POST request for views
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/views/create_view.json