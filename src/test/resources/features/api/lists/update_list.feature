@API @List
Feature: Update List

  @Smoke @CreateListInFolder @DeleteList
  Scenario: As a user I want to update a list in folder
    Given I set the list with request endpoint to /list/{list_id}
    When I set the request body with following values:
      | name | My list is updated |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/list/create_required_field.json

  @Smoke @CreateListInFolder @DeleteList
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
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/list/list_required_all_field.json

  @Smoke @CreateListInSpace @DeleteList
  Scenario: As a user I want to update a list in space
    Given I set the list with request endpoint to /list/{list_id}
    When I set the request body with following values:
      | name          | My list is updated in space   |
      | content       | Updated List Content in space |
      | due_date      | 1567234402342                 |
      | due_date_time | false                         |
      | priority      | 2                             |
      | status        | yellow                        |
      | unset_status  | false                         |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/list/list_required_all_field.json