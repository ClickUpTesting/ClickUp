Feature: Update View

  @CreateTeamView @DeleteView
  Scenario: As a user I want to update a view name and its type
    Given I set the view with request endpoint to /view/{view_id}
    When I set the request body with following values:
      | name | Updated View For Testing With New Name |
      | type | board                                  |
      And I execute the PUT request for views
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/views/updated_view.json