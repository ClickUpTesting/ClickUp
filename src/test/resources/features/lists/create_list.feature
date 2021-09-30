Feature: Create List

  @CreateList
  Scenario: As a user I want to create a list for tracking an objective
    Given I set the list with request endpoint to /folder/{folder_id}/list
    When I set the request body with following values:
      | name | My list created 41|
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/list/create_required_field.json
      And I verify the values set on the feature
