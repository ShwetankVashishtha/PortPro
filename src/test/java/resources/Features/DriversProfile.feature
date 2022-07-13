Feature: Check driver profile functionality

  Background: PortPro Login
    Given User is redirected to AUT login url
    And User login with "qaautomation123@yopmail.com" and "Yash1234"

  Scenario: Driver creation functionality
    When User redirects to Driver profile section
    And User clicks "Add New Driver" button
    When User enters FirstName, LastName, Email, Phone, Password
    And User selects a Username and Timezone from dropdown
    And User selects License state 
    And User provides License number
    And User clicks "Add" button
    Then User gets message on driver creation "Driver Added Successfully"