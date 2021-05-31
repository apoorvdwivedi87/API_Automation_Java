
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 @pojo
  Scenario: Validate user is able to get response body for all the users on first page
    Given user has an baseURI
    When user hits the API for a "GET" request with users end point
    Then user should get all the users information