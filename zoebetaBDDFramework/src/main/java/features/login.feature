@TestDataReding
Feature: zoe_beta beta Login Feature

Scenario: zoe_beta beta Login scenario

Given User is already on login page
When title of login page is zoemenu
Then user enter username and password
And user clicks on login buttion
And user is on home page


Scenario: zoe_beta invalid login test

Given User is already on login page
Then title of login page should be verfiedy
Then user enter invalid username and password
And user clcik on login button
And the error message should display