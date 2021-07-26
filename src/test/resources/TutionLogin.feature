Feature: Testing out the Login Page

	Scenario: The guest is able to fill out the login form
		Given The guest is on the login page
		When The enters username and password
		Then They should be logged in