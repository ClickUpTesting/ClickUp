Feature: Create List

  @DeleteList
  Scenario: As a user I want to create a list in folder with only name
    Given I set the list with request endpoint to /folder/{folder_id}/list
    When I set the request body with following values:
      | name | My list created 41 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/create_required_field.json

  @DeleteList
  Scenario: As a user I want to create a list in folder with all fields
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

  @DeleteList
  Scenario: As a user I want to create a list in space for tracking an objective
    Given I set the list with request endpoint to /space/{space_id}/list
    When I set the request body with following values:
      | name | My list created in space |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/create_required_field.json

  @DeleteList
  Scenario: As a user I want to create a list in space with all fields
    Given I set the list with request endpoint to /space/{space_id}/list
    When I set the request body with following values:
      | name          | My list created in space |
      | content       | New List Content         |
      | due_date      | 1786769379355            |
      | due_date_time | true                     |
      | priority      | 2                        |
      | status        | green                    |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/create_all_field.json
