#Author: dgutimesa@gmail.com
Feature: Liferay Form Integrity and Robustness Tests
  I want to test Liferay form integrity and robustness

Scenario: I enter a birthday in the future so I get error message
    Given I am in Liferay Form page
    And I fill date of birth with month "4" from this one and day "12"
    And I fill name field with "test name"
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I stay in Liferay Form page
    And I get "Invalid future date" error message for field "birthday"
    And I get no error message for field "name"
    And I get no error message for field "comments"

Scenario: I enter special characters in name and I can save the form
successfully submitted
    Given I am in Liferay Form page
    And I fill name field with "!\"·$%&/()=?¿*^¨Ç_ªº-.,ç´`+¡’0-.,;:_ª≤><<!·$$%&/()=?¿^*Ç¨_:Ñ;_:_:,÷|@#¢∞¬÷\”≠´‚"
    And I fill date of birth with month "-8" from this one and day "12"
    And I fill tell me about you field with value "This is a test"
    When I press submit button
    Then I am redirected to confirmation page
    And I get success message

Scenario: I enter special characters in tell me about you and I can save the form
    Given I am in Liferay Form page
    And I fill name field with "test name"
    And I fill date of birth with month "-8" from this one and day "12"
    And I fill tell me about you field with value "!\"·$%&/()=?¿*^¨Ç_ªº-.,ç´`+¡’0-.,;:_ª≤><<!·$$%&/()=?¿^*Ç¨_:Ñ;_:_:,÷|@#¢∞¬÷\”≠´‚"
    When I press submit button
    Then I am redirected to confirmation page
    And I get success message

