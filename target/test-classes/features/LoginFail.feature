@LoginFailed
Feature: Failed Login

  @LoginFailed
  Scenario Outline: Unsuccessfully Login
    Given the user wants to login
    When  the user enters invalid credentials <User><Password>
    Then  the user should be able to see error <Message>
    Examples:
      |User       |Password     | Message              |
      |"ligibriale"|"12345"     | " There was a problem"|

