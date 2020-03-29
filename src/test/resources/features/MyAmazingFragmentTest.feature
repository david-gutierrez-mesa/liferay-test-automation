#Author: david.gutierrez@liferay.com
Feature: My Amazing Fragment
  I want to test My Amazing fragment

  Scenario: Test My Amazing Fragment as Admin
    Given I am logged in Liferay as "ADMINISTRATOR"
    And I navigate to "MyAmazingPage"

  Scenario: Test My Amazing Fragment as Standard User
    Given I am logged in Liferay as "STANDARD_USER"
    And I navigate to "MyAmazingPage"