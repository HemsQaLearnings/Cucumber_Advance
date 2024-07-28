Feature: Login

  Scenario: Sucessful login
    Given the user is on OrangeHrm Login Page
    When the user enters valid credentials (username:"Admin" , password:"admin123");
    And the user clicks on login Button
    Then the User should redirected to the HomePage
    And the user should see a Dashboard
#after writing the code you should check the intendation. without intendation it will not work make a note
#how to check : press "Control + F" button in your keyboard
#else select all the script and right click select pretty format
