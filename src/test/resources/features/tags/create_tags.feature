Feature: Create Tags

  @CreateTag
  Scenario: As a user I want to create a Tag
    Given I set the tags with request endpoint to /space/{space_id}/tag
    When I set the tags body with following values:
      | name   | APIV2   |
      | tag_fg | #ffffff |
      | tag_bg | #3c9d9b |
      And I execute the POST request for tags
    Then I verify that the response status is 200

  @CreateTag
  Scenario: As a user I want to create a Tag with only name
    Given I set the tags with request endpoint to /space/{space_id}/tag
    When I set the tags body with following values:
      | name   | APIV10   |
      And I execute the POST request for tags
    Then I verify that the response status is 200

  Scenario: As a user I want to verify that it is not possible to create a Tag without name
    Given I set the tags with request endpoint to /space/{space_id}/tag
    When I set the tags body with following values:
      | tag_fg | #ffffff |
      | tag_bg | #3c9d9b |
      And I execute the POST request for tags
    Then I verify that the response status is 400