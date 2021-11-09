@GUI @Tag
Feature: Update Tag

  @Smoke @AddTagToTask @DeleteTask
  Scenario: Update a tag's name
    Given I login to click up as an admin
    And I navigate to a task menu
    When I update a tag with the following parameters
      | name | my tag updated |
    Then I verify that the tag contains the configured values

