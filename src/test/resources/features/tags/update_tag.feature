Feature: Update Tags

  @API @SmokeTesting @CreateTag @DeleteTag
  Scenario: As a user I want to update a Tag's name
    Given I set the tags with request endpoint to /space/{space_id}/tag/{tag_name}
    When I set the tags body with following values:
      | name | Edited |
      And I execute a PUT request
    Then I verify the values on the tags list
      And I verify that the response status is 200

  @API @SmokeTesting @CreateTag @DeleteTag
  Scenario: As a user I want to update a Tag's color
    Given I set the tags with request endpoint to /space/{space_id}/tag/{tag_name}
    When I set the tags body with following values:
      | tag_fg | #ffffff       |
      | tag_bg | #3c9d9b       |
      And I execute a PUT request
    Then I verify the values on the tags list
      And I verify that the response status is 200