
Feature: user should be able to login to the system

  #Test Scenario 1
  Scenario: user login with valid username and password
    Given Open Browser
    And user navigate to login Page
    When user enter valid username and password
    And user click on login button
    Then user could login successfully
    And go to home page

  Scenario: Open Browser
    Given Open Browser
    And user navigate to login Page