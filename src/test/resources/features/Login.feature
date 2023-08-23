Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get Successfully logged in
Examples:
|username                     |password  |
|maheshchowdary01@gmail.com   |110398    |
|maheshchowdary02@gmail.com   |110398    |
|maheshchowdary03@gmail.com   |110398    |



Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address into email field
And users enters invalid password "Mahi@199843" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "maheshchowdary0505@gmail.com" into email field
And users enters invalid password "Mahi@199843" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address into email field
And User enters valid password "Mahi@1998" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter email address into email field
And User dont enter password into password field 
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch