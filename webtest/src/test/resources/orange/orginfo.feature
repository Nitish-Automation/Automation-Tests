Feature: Validating organization info ids
  Login with admin account to hrm system and validate org ids

  Scenario: Login with admin and validate org tax and reg ids
    Given User is on the login page
    And Enters %admin% as username
    And Enters %admin% as password
    And Click login button
    Then Make sure login is success
    And User is able to navigate to orginfo page
    When User sucessfully land on orginfo page
    And Registration id is disabled and value is %A23456%
