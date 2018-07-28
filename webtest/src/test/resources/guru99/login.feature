Feature: Customer Login
  As a customer, I can log in with valid user id and password

 Scenario: Valid Login
  Given the user in on the login page
  When he enters %mngr136775% as user id
  And he enters %vybEpen% as password
  And he clicks the LOGIN button with valid login info
  Then ensure the Manger Id is %mngr136775%