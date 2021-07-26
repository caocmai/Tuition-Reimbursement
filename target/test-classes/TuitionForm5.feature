Feature: Testing out the form page

	Scenario: The guest is able to fill out the form
		Given The guest is on the form page
		When The guest fills out the form with their username and password
		Then They should now be logged in