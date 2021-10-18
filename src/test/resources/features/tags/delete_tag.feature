Feature: Delete Tags

  @API @SmokeTesting @CreateTag
  Scenario: As a user I want to delete a Tag's name
    Given I set the tags with request endpoint to /space/{space_id}/tag/{tag_name}
    When I execute a PUT request
    Then I verify that the response status is 200