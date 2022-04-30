Feature: Verify dispatcher scenarios

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
    And User selects load option "Billing"
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
    
  Scenario: Check dispatcher functionality - Assign Route
    When User navigates to dispatcher page from left menu
    And User adds new load
    And User selects load option "Routing"
    And User selects driver "Test port"
    And User selects date
    And User selects pull container address "Port_1 758 N Larrabee St, Chicago, IL 60654, USA"
    And User selects deliver load address "m6 8526 W Golf Rd, Niles, IL 60714, USA"
    And User selects return container address "Port_1 758 N Larrabee St, Chicago, IL 60654, USA"
    And User save the changes
    