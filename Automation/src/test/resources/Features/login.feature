Feature: Feature to test login functionality

  Scenario: Check login is successfully using valid credentials.
    
    Given User is on login page
    When User enters user name and password
    And User clicks on login button
    Then User should be land to homepage successfully.

