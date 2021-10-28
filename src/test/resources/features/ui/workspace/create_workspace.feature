Feature: Create Workspace

  @UI @Workspace
  Scenario: Create a campaign with only required fields
    Given I go to my settings page
    When I create a new workspace with field
      | name|New workspace random |
    Then I verify that the created workspace contains the correct information
