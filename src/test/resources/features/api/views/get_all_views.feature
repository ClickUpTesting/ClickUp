@API @View
Feature: Get all Views

  @Regression @DeleteViews
  Scenario: As a user I want to get all Team Views and verity the quantity
    Given I get the initial amount of team views
      And I set the views with request endpoint to /team/{team_id}/view
    When I add the amount of 2 to the total of team views
      And I execute the GET request for views
    Then I verify the amount of views has increased by 2
      And I verify that the response status is 200

  @Regression @DeleteViews
  Scenario: As a user I want to get all Space Views and verity the quantity
    Given I get the initial amount of space views
      And I set the views with request endpoint to /space/{space_id}/view
    When I add the amount of 2 to the total of space views
      And I execute the GET request for views
    Then I verify the amount of views has increased by 2
      And I verify that the response status is 200

  @Regression @DeleteViews
  Scenario: As a user I want to get all Folder Views and verity the quantity
    Given I get the initial amount of folder views
      And I set the views with request endpoint to /folder/{folder_id}/view
    When I add the amount of 2 to the total of folder views
      And I execute the GET request for views
    Then I verify the amount of views has increased by 2
      And I verify that the response status is 200

  @Regression @DeleteViews
  Scenario: As a user I want to get all List Views and verity the quantity
    Given I get the initial amount of list views
      And I set the views with request endpoint to /list/{list_id}/view
    When I add the amount of 2 to the total of list views
      And I execute the GET request for views
    Then I verify the amount of views has increased by 2
      And I verify that the response status is 200