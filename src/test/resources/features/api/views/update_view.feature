Feature: Update View

  @API @SmokeTesting @CreateTeamView @DeleteView
  Scenario: As a user I want to update a view name and its type
    Given I set the view with request endpoint to /view/{view_id}
    When I set the request body with following values:
      | name | Updated View For Testing With New Name |
      | type | board                                  |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/views/updated_view.json