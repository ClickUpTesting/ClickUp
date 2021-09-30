Feature: Create List

  @GetList
  Scenario: As a user I want to create a list for tracking an objective
    Given I set the list with request endpoint to /list/{list_id}
    When I execute the GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/create_required_field.json
