Feature: Create task

  @CreateList @DeleteTask
  Scenario: As a user I want to create a list for tracking an objective
    Given I set the task with request endpoint to /list/{list_id}/task
    When I set the request body with following values:
      | name            | My Task created                                             |
      | description     | New Task Description                                        |
      | assignees[0]    | 183                                                         |
      | tags[0]         | tag name 1                                                  |
      | status          | complete                                                    |
      | priority        | 3                                                           |
      | due_date        | 1508369194377                                               |
      | due_date_time   | false                                                       |
      | time_estimate   | 8640000                                                     |
      | start_date      | 1567780450202                                               |
      | start_date_time | false                                                       |
      | notify_all      | true                                                        |
      | Custom fields   | src\test\resources\json\tasks\custom_fields_by_defects.json |

    And I execute the POST request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/task/create_task_all_fields.json
