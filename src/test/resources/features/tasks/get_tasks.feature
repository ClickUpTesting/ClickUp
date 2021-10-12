Feature: Get all Task

  @CreateListInSpace @DeleteList
  Scenario: As a user I want to get all task and verity the quantity
    Given I set the task with request endpoint to /list/{list_id}/task
    When I add the amount of 2 to the total of task
      And I execute the GET request
    Then I verify the amount of tasks has increased by 2
      And I verify that the response status is 200
