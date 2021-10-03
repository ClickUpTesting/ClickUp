Feature: Delete Tags

  @DeleteTag
  Scenario: As a user I want to delete a Tag's name
    Given I set the Tags composed endpoint /space/{space_id}/tag/{tag_name}
    When I execute the PUT request for tags
    Then I verify that the response status is 200