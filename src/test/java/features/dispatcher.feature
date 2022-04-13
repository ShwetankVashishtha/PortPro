Feature: Verify login and dashboard scenarios

  Background: PortPro Login
    Given User is redirected to AUT login url
    And User login with "testport14@gmail.com" and "123456789"

  Scenario: Check dispatcher functionality - Add Load
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully

  Scenario: Check dispatcher functionality - View Billing
    When User navigates to dispatcher page from left menu
    And User adds new load
    And User navigates to Billing
    Then User should be able to view correct Summary

  Scenario: Check dispatcher functionality - Add Notes
    When User navigates to dispatcher page from left menu
    And User adds new load
    And User adds notes "Hi, Where are you?"
    Then User should be able to add notes successfully

  Scenario: Check dispatcher functionality - Assign Driver
    When User navigates to dispatcher page from left menu
    And User assigns driver to load
    Then User should be able to assign driver successfully