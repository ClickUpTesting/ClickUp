@API @Comment
Feature: Delete Comment

  @Smoke @CreateCommentInList
  Scenario: As a user I want to delete a comment
    Given I set the comment with request endpoint to /comment/{comment_id}
    When I execute the DELETE request
    Then I verify that the response status is 200
