#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Magento homapage testing
  All test case refer magento will be stored here

  Scenario: Open HomePage
    Given Open Browser
    Then Enter URL
    Then Wait PageLoad completely
    Then Verify PageTitle 
		Then Close browser
		
  Scenario: Failed login using wrong credentials
  	Given Open Browser 
  	And Enter URL 
  	Then Wait PageLoad completely
  	Then Click Login Button
  	Then Verify Login Page are displayed
    Then I fill in "email" with "<ag@gmail.com>"
    And I fill in "password" with "<password>"
    And I click on the "submit-button" button
    And I should see "<The email or password is incorrect.>" message
    Then Close browser
 
    
   
    
 