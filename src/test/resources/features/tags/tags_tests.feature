Feature: Get all Tags

  @CreateTag @DeleteTag
  Scenario: As a user I want to get all tags and verity the amount
    Given I set the request endpoint to /space/{space_id}/tag
    And I GET request all tags amount
    When I add the amount of 2 to the total of tags
    Then I verify the amount of has increased by 2

  @DeleteTag
  Scenario: As a user I want to create a Tag for tracking an objective
    Given I set the request endpoint to /space/{space_id}/tag
    When I set the tags body with following values:
      | name   | APIV2   |
      | tag_fg | #ffffff |
      | tag_bg | #3c9d9b |
      And I execute the POST request
    Then I verify that the response status is 200
