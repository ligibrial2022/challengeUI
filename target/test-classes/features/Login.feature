#Author: Liseth

@Login
Feature: test in module Login

  @LoginExitoso
  Scenario: Successful Login
    Given the user wants to login
    When  the user enters the credentials
    Then  the user should be able to login


