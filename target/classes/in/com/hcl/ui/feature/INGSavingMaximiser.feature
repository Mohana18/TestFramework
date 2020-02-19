Feature: Creating New Customer in Savings Maximiser

Scenario: Testing the saving maximiser new account creation
	Given  Launch the given URL
	When Navigate to new Customer form in Savings Maximiser
 	|Nationality|GivenName|MiddleName|FamilyName|DateOfBirth|PlaceOfBirth|CountryOfBirth|EmailAddress|Mobile|EnterAddress|MaidenName|tcn|
    |India			|INDIA1		|INDIA2		 |INDIA3		|11/12/2008	|BANGALORE	 |INDIA					|abc123@abc.com|0412234567|65 MARTIN|AMMA|OpenSavingAcc|
   
	And Fill the form
	Then Form should be submitted successfully.
	
Scenario: Submitting the form without giving the mandatory fields
    Given Launch the Customer add page URL 
    When Without filling any data click on continue
    Then Form should not  be submitted and show the validation messages
    
    
    Scenario: Submitting the form by giving invalid mobile number.
    Given Launch the browser with given URL 
    When Give the invalid mobile number
    Then Form should not  get submitted and throw the error message
    