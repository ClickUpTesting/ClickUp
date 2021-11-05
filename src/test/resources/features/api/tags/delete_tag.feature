@API @Tag
Feature: Delete Tags

  @Smoke @CreateTag
  Scenario: As a user I want to delete a Tag's name
    Given I set the endpoint /space/{space_id}/tag/{tag_name}
    When I execute a DELETE request
    Then I verify that the response status is 200