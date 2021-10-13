Feature: Delete View

  @CreateTeamView
  Scenario: As a user I want to delete a team view
    Given I set the views with request endpoint to /view/{view_id}
    When I execute the DELETE request for views
    Then I verify that the response status is 200