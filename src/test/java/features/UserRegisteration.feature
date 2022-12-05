Feature: User Registeration
I Want to check that the user can register in our e-commerce website

Scenario Outline:	 User Registeration
Given the user in the homepage
When i click on register link
And i entered "<firstname>","<lastname>","<email>","<password>"
Then the registeration page displayed successfully
Examples:
| firstname | lastname | email         | password
| ahmed     | mohamed  |ahmed@test.com |12345678
| Mohamed   | Abbas  |test@test.com    	|12345678

