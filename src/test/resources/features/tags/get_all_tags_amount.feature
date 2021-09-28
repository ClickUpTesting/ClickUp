Feature: Get all Tags

  Scenario: As a user I want to get all tags and verity the amount
    Given I set the request endpoint to /space/{space_id}/tag
    And I GET request all tags amount
    When I add the amount of 2 to the total of tags
    Then I verify the amount of has increased by 2
