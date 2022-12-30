Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "amyraa702@gmail.com" and password as "MavenProject@1" into the fields
And User clicks on Login button
Then Verify user is able to successfully login