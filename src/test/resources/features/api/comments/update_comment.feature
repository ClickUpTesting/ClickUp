Feature: Update comment

  @API @SmokeTesting @Comment @CreateCommentInList @DeleteComment
  Scenario: As a user I want to update a comment in list
    Given I set the comment with request endpoint to /comment/{comment_id}
    When I set the request body with following values:
      | comment_text | Updated list comment content |
      | assignee     | 53480                        |
      | notify_all   | false                        |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify the values on the comments list
