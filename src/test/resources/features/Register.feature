Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName     |mahesh                      |
|lastName      |darapaneni                  |
|telephone     |9014978300                  |
|password      |Mahi@1998                   |
And User selects privacy policy
And User clicks on continue button
Then User account should get created sucessfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName   |mahesh                        |
|lastName    |darapaneni                    |
|telephone   |9014978300                    |
|password    |Mahi@1998                     |                    
And user selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created sucessfully

Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName   |mahesh                      |
|lastName    |darapaneni                  |
|email       |maheshchowdary0505@gmail.com|
|telephone   |9014978300                  |
|password    |Mahi@1998                   |
And user selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields 
And User clicks on continue button
Then User should get proper warning messages for every mandatory fields