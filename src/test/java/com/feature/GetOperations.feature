Feature: GET Operations

  Background: 
    Given user has an baseURI
    When user hits the API for a "GET" request with all users end point for "2" page
    

  @test
  Scenario: Validate user is getting a valid status code
    Then user should get a 200 status code

  @test
  Scenario: Validate user is getting data from second page
    Then user should get "2" as page count

  @test
  Scenario: Validate user is getting 6 records per page
    Then user should get 6 records per page

  @test
  Scenario: validate user is getting a record with lastname as Funke
    Then user should a recordarray with lastname "Funke"

