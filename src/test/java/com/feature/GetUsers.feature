
@tag
Feature: GET users feature
  I want to use this template for my feature file

  @pojo
  Scenario: Validate user is able to get response body for a specific user
    Given user has an baseURI
    When user hits the API for a "GET" request with user end point for "2" user
    Then information related to specific user should get displayed

@pojo1
  Scenario: Validate user is able to get response body for all the users on first page
    Given user has an baseURI
    When user hits the API for a "GET" request with users end point
    Then user should get all the users information
    
@pojo1
  Scenario: Validate the schema of the reponse body
    Given user has an baseURI
    When user hits the API for a "GET" request with user end point for "2" user
    Then schema of the json response should match with the predefined schema