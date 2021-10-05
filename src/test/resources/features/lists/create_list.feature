Feature: Create List

  @DeleteList
  Scenario: As a user I want to create a list for tracking an objective
    Given I set the list with request endpoint to /folder/{folder_id}/list
    When I set the request body with following values:
      | name | My list created 41 |
    And I execute the POST request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/list/create_required_field.json

  @DeleteList
  Scenario: As a user I want to create a list for tracking an objective
    Given I set the list with request endpoint to /folder/{folder_id}/list
    When I set the request body with following values:
      | name          | My list created 41 |
      | content       | New List Content   |
      | due_date      | 1567780450202      |
      | due_date_time | false              |
      | priority      | 1                  |
      | status        | red                |
    And I execute the POST request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/list/create_all_field.json