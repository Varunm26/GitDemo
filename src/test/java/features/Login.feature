Feature: Application Login

Scenario Outline: Positive Test Case Validation login
Given Initialize the Browser with chrome
And Navigate to "http://qaclickacademy.com" Site
And Click on login link in home page to land on secure sign in page
When user enters <username> and <password> and logs in
Then Verify that user is successfully logged in 

Examples: 
|username			|password	| 
|test99@gmail.com	|123456		|
|test123@gmail.com	|12345		|
