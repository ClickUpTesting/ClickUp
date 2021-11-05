@API @Attachment
Feature: create a task attachment

  @Smoke @CreateTask @DeleteTask
  Scenario: As a user I want to create a task attachment
    Given I set the endpoint /task/{task_id}/attachment
    When I Add an attachment to the task
      And I execute a POST request
    Then I verify that the response status is 200
      And I verify the attachment is in the task