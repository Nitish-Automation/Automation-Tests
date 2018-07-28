Feature: Customer Login Failure
  User cannot log in with invalid user id and password

 Scenario: Invalid Login
  Given the user in on the login page
  When he enters %mngr136775% as user id
  And he enters %vybEpabc% as password
  And he clicks the LOGIN button with invalid login info
  Then ensure the appearance of alert message 