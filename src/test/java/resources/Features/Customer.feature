Feature: Check customer creation and updation functionality

  Background: PortPro Login
    Given User is redirected to AUT login url
    And User login with "testport14@gmail.com" and "123456789"

  Scenario: Customer creation functionality
    When User redirects to Customer profile section
    And User clicks "Add New Customer" button
    And User selects customer checkbox
    When User enters Company Name, Address, City, State, Zip Code, Country, Email and Password
    And User clicks add new customer button on popup
    Then User gets message on customer creation "Successfully added"
    
    Scenario: Customer Update Functionality
    When User redirects to Customer profile section
    And User filters the list to get all customers
    And User edits a random customer
    When User enters recovery email
    And User update the changes
    And User gets message on customer updation "Successfully updated"
    
    