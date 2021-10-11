Feature: Get View

  @CreateTeamView @DeleteView
  Scenario: As a user I want to get a single Team View
    Given I set the views with request endpoint to /view/{view_id}
    When I execute the GET request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/views/create_view.json