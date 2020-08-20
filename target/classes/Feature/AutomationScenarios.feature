Feature: Fill Contact form


Scenario: Fill in contact form and send it

Given user is on home page
Then user goes to footer page
Then user clicks on contact link
Then new window appears 
Then user enters message
And user enters full name
And user enters email
Then user clicks on send button
Then message is displayed


Scenario: Navigate to destination through the menu

Given user is on home page
Then user clicks on menu button
Then user clicks on destination 
Then user selects destination
Then user is on desired destination


Scenario: Links on homepage

Given user is on home page
When user is on read more section
Then user clicks on first link read more
Then user is on desired unique places page
Then user is back to homepage
Then user goes to postlockdown trip section
Then user clicks on second link romantic getaways
Then user is on desired getaways page
Then user is back to homepage
Then user goes to best vacation section
Then user clicks on third link best vacations
Then user is on desired vacations page
Then user is back to homepage
Then user goes to future trip section
Then user clicks on fourth link future trip
Then user is on desired trip page
Then user is back to homepage
Then user goes to footer page
Then user clicks on fifth link about
Then user is on desired about page
Then user is back to homepage

