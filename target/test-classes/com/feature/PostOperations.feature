@tag
Feature: POST operations
 
  @pojo1
  Scenario: Validate user is able to perform POST operation
  Given user has a base URI
  When user hits the API for a "POST" request with user end point
  Then user should get a status code = 201
  
  @pojo1
  Scenario: Validate user is able to perform POST operation using POJO class
  Given user has a base URI
  When user hits the API for a "POST" request with user end point with POJO class
  Then user should get a status code = 201
  
  @pojo1
  Scenario: Validate user is able to update POST body before performing POST operation using POJO class
  Given user has a base URI
  When user hits the API for a "POST" request with user end point by replacing POST body
  Then user should get a status code = 201
  
  
    
 