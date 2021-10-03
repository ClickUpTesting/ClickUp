Feature: Update Tags

  @CreateTag @DeleteTag
  Scenario: As a user I want to update a Tag's name
    Given I set the Tags composed endpoint /space/{space_id}/tag/{tag_name}
    When I set the tags body with following values:
      | name   | Edited   |
    And I execute the PUT request for tags
    Then I verify that the response status is 200

