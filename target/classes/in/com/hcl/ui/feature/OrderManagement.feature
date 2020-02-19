Feature: Postman order mangement

  Scenario: Create new order
    When Get token code to create order
    When Create new order
    Then Get Order details by id
    
