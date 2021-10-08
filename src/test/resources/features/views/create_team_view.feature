Feature: Create Team View

  @DeleteView
  Scenario: As a user I want to create a Team View
    Given I set the view with request endpoint to /team/{team_id}/view
    When I set the view body with following values:
      | name | Team View For Testing |
      And I execute the POST request for views
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/views/create_team_view.json