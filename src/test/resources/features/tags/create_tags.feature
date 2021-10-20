Feature: Create Tags

  @API @SmokeTesting @DeleteTag
  Scenario: As a user I want to create a Tag
    Given I set the endpoint /space/{space_id}/tag
    When I set the tags body with following values:
      | name   | APIV2   |
      | tag_fg | #ffffff |
      | tag_bg | #3c9d9b |
    And I execute a POST request
    Then I verify the values on the tags list
    And I verify that the response status is 200

  @API @SmokeTesting @DeleteTag
  Scenario: As a user I want to create a Tag with only name
    Given I set the endpoint /space/{space_id}/tag
    When I set the tags body with following values:
      | name   | APIV10  |
    And I execute a POST request
    Then I verify the values on the tags list
    Then I verify that the response status is 200

  @API @NegativeTesting
  Scenario: As a user I want to verify that it is not possible to create a Tag without name
    Given I set the endpoint /space/{space_id}/tag
    When I set the tags body with following values:
      | tag_fg | #ffffff |
      | tag_bg | #3c9d9b |
    And I execute a POST request
    Then I verify that the response status is 400