Feature: Create a webhook

  @API @SmokeTesting @WebHooks @DeleteWebhooks
  Scenario: As a user I want to create a webhook with all fields
    Given I set the webhooks with request endpoint to /team/{team_id}/webhook
    When I set the request body with following values:
      | endpoint   | https://myendpoint.com  |
      | events[0]  | taskCreated             |
      | events[1]  | taskUpdated             |
      | events[2]  | taskDeleted             |
      | events[3]  | taskPriorityUpdated     |
      | events[4]  | taskStatusUpdated       |
      | events[5]  | taskAssigneeUpdated     |
      | events[6]  | taskDueDateUpdated      |
      | events[7]  | taskTagUpdated          |
      | events[8]  | taskMoved               |
      | events[9]  | taskCommentPosted       |
      | events[10] | taskCommentUpdated      |
      | events[11] | taskTimeEstimateUpdated |
      | events[12] | taskTimeTrackedUpdated  |
      | events[13] | listCreated             |
      | events[14] | listUpdated             |
      | events[15] | listDeleted             |
      | events[16] | folderCreated           |
      | events[17] | folderUpdated           |
      | events[18] | folderDeleted           |
      | events[19] | spaceCreated            |
      | events[20] | spaceUpdated            |
      | events[21] | spaceDeleted            |
      | events[22] | goalCreated             |
      | events[23] | goalUpdated             |
      | events[24] | goalDeleted             |
      | events[25] | keyResultCreated        |
      | events[26] | keyResultUpdated        |
      | events[27] | keyResultDeleted        |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/webhooks/create_webhook.json