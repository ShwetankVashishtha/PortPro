Feature: Check driver profile functionality

  Background: PortPro Login
    Given User is redirected to AUT login url
    And User login with "testport14@gmail.com" and "123456789"

  Scenario: Driver creation functionality
    When User redirects to Driver profile section
    And User clicks "Add New Driver" button
    When User enters FirstName, LastName, Email, Phone, Password
    And User selecs a Username and Timezone from dropdown
    And User selects License state 
    And User provides License number
    And User clicks "Add" button
    Then User gets message on driver creation "Driver has been added."