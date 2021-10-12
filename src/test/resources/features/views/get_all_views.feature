Feature: Get all Views

  @DeleteViews
  Scenario: As a user I want to get all Team Views and verity the quantity
    Given I get the initial amount of team views
      And I set the views with request endpoint to /team/{team_id}/view
    When I add the amount of 2 to the total of team views
      And I execute the GET request for views
    Then I verify the amount of views has increased by 2
      And I verify that the response status is 200