Feature: Get all webhooks

  @CreateWebhook @DeleteWebhook
  Scenario: As a user I want to get all webhook
    Given I set the endpoint /team/{team_id}/webhook
    When I execute a GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/webhooks/get_all_webhooks.json