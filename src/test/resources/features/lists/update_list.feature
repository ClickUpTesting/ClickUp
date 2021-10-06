Feature: Update List

  @CreateList @DeleteList
  Scenario: As a user I want to update a list in folder
    Given I set the list with request endpoint to /list/{list_id}
    When I set the request body with following values:
      | name | My list is updated |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/create_required_field.json

  @CreateList @DeleteList
  Scenario: As a user I want to update a list in folder
    Given I set the list with request endpoint to /list/{list_id}
    When I set the request body with following values:
      | name          | My list is updated   |
      | content       | Updated List Content |
      | due_date      | 1567780450202        |
      | due_date_time | true                 |
      | priority      | 1                    |
      | status        | red                  |
      | unset_status  | true                 |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/list_required_all_field.json
