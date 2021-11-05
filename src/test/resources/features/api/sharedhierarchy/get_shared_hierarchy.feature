@API
Feature: Get Shared Hierarchy

  @Smoke @SharedHierarchy
  Scenario: As a user I want to get a shared hierarchy
    Given I set the shares with request endpoint to /team/{team_id}/shared
    When I execute the GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/sharedhierarchy/get_shared_hierarchy.json