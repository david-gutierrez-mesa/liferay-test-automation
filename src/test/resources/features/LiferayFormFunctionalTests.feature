#Author: dgutimesa@gmail.com
Feature: Liferay Form Functional Tests
  I want to test Liferay Form page

  Scenario: The text party rock must be present in the form
    Given I am in Liferay Form page
    Then I text "party rock" is present

  Scenario: A successful message should appear after the form has been successfully submitted
    Given I am in Liferay Form page
    And I fill name field with "test name"
    And I fill date of birth with month "-216" from this one and day "12"
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I am redirected to confirmation page
    And I get success message

  Scenario: All fields must be mandatory and contain an error message if they are not filled
    Given I am in Liferay Form page
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "name"
    And I get "This field is required" error message for field "birthday"
    And I get "This field is required" error message for field "comments"
    
  Scenario: Only name is filled so I get error message for the others
    Given I am in Liferay Form page
    And I fill name field with "test name"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "birthday"
    And I get "This field is required" error message for field "comments"
    And I get no error message for field "name"
    
   Scenario: Only tell me about you is filled so I get error message for the others
    Given I am in Liferay Form page
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "birthday"
    And I get "This field is required" error message for field "name"
    And I get no error message for field "comments"
    
  Scenario: Only birthday is filled so I get error message for the others
    Given I am in Liferay Form page
    And I fill date of birth with month "-8" from this one and day "12"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "name"
    And I get "This field is required" error message for field "comments"
    And I get no error message for field "birthday"
  
   Scenario: Only name and birthday are filled so I get error message for comments
    Given I am in Liferay Form page
    And I fill name field with "test name"
    And I fill date of birth with month "-8" from this one and day "12"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "comments"
    And I get no error message for field "name"
    And I get no error message for field "birthday"

  Scenario: Only name and comments are filled so I get error message for birthday
    Given I am in Liferay Form page
    And I fill name field with "test name"
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "birthday"
    And I get no error message for field "name"
    And I get no error message for field "comments"

  Scenario: Only birthday and comments are filled so I get error message for name
    Given I am in Liferay Form page
    And I fill date of birth with month "-8" from this one and day "12"
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "This field is required" error message for field "name"
    And I get no error message for field "birthday"
    And I get no error message for field "comments"