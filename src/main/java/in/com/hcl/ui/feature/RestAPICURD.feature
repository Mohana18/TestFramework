Feature: Validate the CURD operation

Scenario: Fetch,create
Given I created employee
When I hit get request1
Then I should get created employee

Scenario: update and get the updated data
Given I update an existing employee
When I hit get request2
Then I should get updated employee record
