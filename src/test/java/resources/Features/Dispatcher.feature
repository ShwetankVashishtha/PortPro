Feature: Verify dispatcher scenarios

  Background: PortPro Login
    Given User is redirected to AUT login url
    And User login with "qaautomation123@yopmail.com" and "Yash1234"

  Scenario: Check dispatcher functionality - Add Load
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User deletes the created load

  Scenario: Check dispatcher functionality - Add Notes
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User adds notes "Hi, Where are you?"
    Then User should be able to add notes successfully
    And User deletes the created load

  Scenario: Check dispatcher functionality - Assign Driver
    When User navigates to dispatcher page from left menu
    And User assigns driver to load
    Then User should be able to assign driver successfully

  Scenario: Check dispatcher functionality - Assign Route
    When User redirects to Driver profile section
    And User search the driver with username "2115656455"
    And User verify that driver is not on hold
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Routing"
    And User selects driver "Test port"
    And User selects date
    And User selects pull container address "Port_1 758 N Larrabee St, Chicago, IL 60654, USA"
    And User selects deliver load address "m6 8526 W Golf Rd, Niles, IL 60714, USA"
    And User selects return container address "Port_1 758 N Larrabee St, Chicago, IL 60654, USA"
    And User save the changes
    And User click on Complete Load
    And User deletes the created load

  Scenario: Check dispatcher functionality - View Load and update any field
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects the chassis pickup location "m6 8526 W Golf Rd, Niles, IL 60714, USA"
    And User selects the chassis termination location "m7 2237 Mason Street, San Francisco"
    And User update the changes
    Then User is presented with a message "Updated!"
    And User deletes the created load

  Scenario: Check dispatcher functionality - View and add/update billing (main)
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Billing"
    And User selects main customer
    When User clicks the add charge button
    And User selects random charge type from charge dropdown
    And User enter the amount
    And User update the changes
    Then User gets billing success message "Your pricing has been updated!"
    And User removes the added bill
    And User is presented with successful pricing deletion message "Your pricing has been deleted!"
    And User fetches the total amount from billing tab
    And User gets the update total amount from getLoadDetail api and verify with billing tab
    And User deletes the created load

  Scenario: Check dispatcher functionality - View and add/update billing (sub)
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Billing"
    And User selects sub customer
    And User clicks add sub bill
    And User selects sub customer from dropdown
    And User adds "3" random charges and remove them
    And User deletes the created load

  Scenario: Check dispatcher functionality - Add Payment (Main Customer)
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Payment"
    And User clicks add payment button
    And User enters amount
    And User selects payment date
    When User clicks save payment
    Then Payment added successfully
    And User deletes the created load

  Scenario: Check dispatcher functionality - Approve - Unapprove
    When User redirects to Driver profile section
    And User search the driver with username "3271010573"
    And User verify that driver is not on hold
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Routing"
    And User selects driver "Irwin Cremin"
    And User save the changes
    And User click on Complete Load
    And User selects load option "Billing"
    And User finds that Approve and Approve and Invoice checkbox are enabled
    And Unapproved Rebill checkbox are disabled
    And User select checkbox "Approve"
    And User select checkbox "Unapprove"
    And User select checkbox "Approve & Invoice" and close email popup
    And User select checkbox "Rebill"
    And User deletes the created load

  Scenario: Check dispatcher functionality - Document Upload
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Documents"
    And User clicks document upload button
    And User uploads a file from machine
    And User selects the file type
    And User save the document
    And User deletes the created load

  Scenario: Check add payment functionality - Add Payment
    When User navigates to Add Payments tab
    And User selects a customer from the dropdown as "Cust_2, 14/56 INDIRA NAGAR, Hempstead, TX 77445, USA"
    And User selects a random load available for the customer
    And User add the payment
    Then application displays a successful payment message "You have added a payment!"

  Scenario: Check dispatcher functionality - View Billing
    When User navigates to dispatcher page from left menu
    And User adds new load
    Then User should be able to add load successfully
    And User selects load option "Billing"
    Then User should be able to view correct Summary
    And User deletes the created load
