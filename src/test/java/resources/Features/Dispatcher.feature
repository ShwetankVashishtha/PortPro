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
    And User click on Complete Load

  Scenario: Check dispatcher functionality - View Load and update any field
    When User navigates to dispatcher page from left menu
    And User selects any available load from list of loads
    And User selects the chassis pickup location "m6 8526 W Golf Rd, Niles, IL 60714, USA"
    And User selects the chassis termination location "m7 2237 Mason Street, San Francisco"
    And User update the changes
    Then User is presented with a message "Updated!"

  Scenario: Check dispatcher functionality - View and add/update billing (main)
    When User navigates to dispatcher page from left menu
    And User selects any available load from list of loads
    #And User clicks the billing tab
    And User selects load option "Billing"
    And User selects main customer
    When User clicks the add charge button
    And User selects random charge type from charge dropdown
    And User enter the amount
    And User update the changes
    Then User gets billing success message "Your pricing has been updated!"
    And User fetchs the total ampount from billing tab
    And User removes the added bill
    And User is presented with successful pricing deletion message "Your pricing has been deleted!"
    And User gets the updatd total amount from getLoadDetail api and verify with billing tab

  Scenario: Check dispatcher functionality - View and add/update billing (sub)
    When User navigates to dispatcher page from left menu
    And User selects any available load from list of loads
    #And User clicks the billing tab
    And User selects load option "Billing"
    And User selects sub customer
    And User clicks add sub bill
    And User selects sub customer from dropdown
    And User selects random charge type from charge dropdown
    And User enter the amount
    And User update the changes
    Then User gets billing success message for sub customer "Your pricing has been updated!"
    And User removes the added bill

  Scenario: Check dispatcher functionality - Add Payment (Main Customer)
    When User navigates to dispatcher page from left menu
    And User selects any available load from list of loads
    And User selects load option "Payment"
    #And User navigates to payment tab
    And User clicks add payment button
    And User enters amount
    And User selects payment date
    When User clicks save payment
    Then Payment addedd successfully

  Scenario: Check dispatcher functionality - Approve - Unapprove
    When User navigates to dispatcher page from left menu
     And User selects any available load from list of loads
     And User selects load option "Routing"
     And User selects driver "Test port"
     And User save the changes
     And User click on Complete Load
     And User selects load option "Billing"
     And User finds that Approve and Approve and Invoice checkbox are enabled
     And Unapproved Rebill checkbox are disabled
     And User select checkbox "Approve"
     And User select checkbox "Unapprove"
     And User select checkbox "Approve & Invoice" and close email popup
     And User select checkbox "Rebill"

   Scenario: Check dispatcher functionality - Document Upload
     When User navigates to dispatcher page from left menu
     And User selects any available load from list of loads
     And User selects load option "Documents"
     And User clicks document upload button
     And User uploads a file from machine
     And User selects the file type
     And User save the document
    
    Scenario: Check add paymet functionality - Add Payment
      When User navigates to Add Payments tab
      And User selects a customer from the dropdown as "Cust_2, 14/56 INDIRA NAGAR, Hempstead, TX 77445, USA"
      And User selects a random load available for the customer
      And User add the payment
      Then application displays a sussessful payment message "You have added a payment!"
    
