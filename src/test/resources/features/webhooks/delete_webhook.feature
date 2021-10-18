Feature: Delete a webhook

  @API @SmokeTesting @CreateWebhook
  Scenario: As a user I want to delete a webhook
    Given I set the endpoint /webhook/{webhook_id}
    When I execute a DELETE request
    Then I verify that the response status is 200