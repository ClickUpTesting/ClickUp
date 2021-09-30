Feature: Create Tags

  @DeleteTag
  Scenario: As a user I want to create a Tag for tracking an objective
    Given I set the tags with request endpoint to /space/{space_id}/tag
    When I set the tags body with following values:
      | name   | APIV2   |
      | tag_fg | #ffffff |
      | tag_bg | #3c9d9b |
      And I execute the POST request for tags
    Then I verify that the response status is 200
