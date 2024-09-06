#NAME: YASHWANTH CHELLOJU

Feature: Movie Management

 
  Scenario: Register a new user
    Given I am at the user registration endpoint
    When I register a new user with username "virat", password "virat@123", and email "virat@example.com"
    Then the user should be registered successfully

  Scenario: User login
    Given I am at the user login endpoint
    When I login with username "virat" and password "virat@123"
    Then I should be logged in successfully

  Scenario: Add a new movie
    Given I am at the add movie endpoint
    When I add a new movie with title "Kalki", director "Nag Ashwin", genre "mythology", and release date "2024-09-05"
    Then the movie should be added successfully

  Scenario: Retrieve movie details
    Given I am at the movie details endpoint with movieId 1
    When I retrieve the movie details
    Then the movie title should be "Kushi"

  Scenario: Search movies by title
    Given I am at the movie search endpoint with title "Kushi"
    When I search for movies by title
    Then I should find movies with the title "Kushi"

  Scenario: Filter movies by genre
    Given I am at the movie filter endpoint with genre "lovestory"
    When I filter movies by genre
    Then I should find movies with the genre "lovestory"
    
# Rental Processing

  Scenario: Get rental details by ID
    When I send a GET request to "/rentals/1"
    Then the response status should be 200
    And the response should contain rental with ID 1
    
 Scenario: Update user profile
When I set the request body for updating user profile
And I send a PUT request to "/users/1"
Then the response status code should be 200