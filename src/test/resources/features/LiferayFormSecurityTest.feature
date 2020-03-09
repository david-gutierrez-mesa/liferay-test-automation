#Author: dgutimesa@gmail.com
Feature: Liferay Form Security Tests
  I want to run some smoke and hight level security tests
  
  Scenario: I enter a SQL injection in name field
    Given I am in Liferay Form page
    And I fill name field with "my name\"; DROP TABLE users; \""
    And I fill date of birth with month "-8" from this one and day "12"
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "Not allowed characters" error message for field "name"
    And I get no error message for field "birthday"
    And I get no error message for field "comments"

  Scenario: I enter a SQL injection in tell me about you field
    Given I am in Liferay Form page
    And I fill name field with "test name"
    And I fill date of birth with month "-8" from this one and day "12"
    And I fill tell me about you field with value "my name\"; DROP TABLE users; \""
    When I press submit button
    Then I stay in Liferay Form page
    And I get "Not allowed characters" error message for field "comments"
    And I get no error message for field "birthday"
    And I get no error message for field "name"
