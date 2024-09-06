package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Assert;


public class movieSteps {
	  private Response response;

	    @Given("I am at the user registration endpoint")
	    public void i_am_at_the_user_registration_endpoint() {
	        RestAssured.baseURI = "http://localhost:7007";
	    }

	    @When("I register a new user with username {string}, password {string}, and email {string}")
	    public void i_register_a_new_user(String username, String password, String email) {
	        response = given()
	            .contentType("application/json")
	            .body(String.format("{\"username\": \"%s\", \"password\": \"%s\", \"email\": \"%s\"}", username, password, email))
	        .when()
	            .post("/users/register");
	    }

	    @Then("the user should be registered successfully")
	    public void the_user_should_be_registered_successfully() {
	        response.then().statusCode(201);
	        String responseBody = response.getBody().asString();
	        Assert.assertTrue(responseBody.contains("username"));
	    }

	    @Given("I am at the user login endpoint")
	    public void i_am_at_the_user_login_endpoint() {
	        RestAssured.baseURI = "http://localhost:7007";
	    }

	    @When("I login with username {string} and password {string}")
	    public void i_login_with_username_and_password(String username, String password) {
	        response = given()
	            .contentType("application/json")
	            .body(String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password))
	        .when()
	            .post("/users/login");
	    }

	    @Then("I should be logged in successfully")
	    public void i_should_be_logged_in_successfully() {
	        response.then().statusCode(200);
	        String responseBody = response.getBody().asString();
	        Assert.assertTrue(responseBody.contains("Login successful"));
	    }

	    @Given("I am at the add movie endpoint")
	    public void i_am_at_the_add_movie_endpoint() {
	        RestAssured.baseURI = "http://localhost:7007";
	    }

	    @When("I add a new movie with title {string}, director {string}, genre {string}, and release date {string}")
	    public void i_add_a_new_movie(String title, String director, String genre, String releaseDate) {
	        response = given()
	            .contentType("application/json")
	            .body(String.format("{\"title\": \"%s\", \"director\": \"%s\", \"genre\": \"%s\", \"releaseDate\": \"%s\"}", title, director, genre, releaseDate))
	        .when()
	            .post("/movies");
	    }

	    @Then("the movie should be added successfully")
	    public void the_movie_should_be_added_successfully() {
	        response.then().statusCode(201);
	        String responseBody = response.getBody().asString();
	        Assert.assertTrue(responseBody.contains("title"));
	    }

	    @Given("I am at the movie details endpoint with movieId {int}")
	    public void i_am_at_the_movie_details_endpoint_with_movieId(int movieId) {
	        RestAssured.baseURI = "http://localhost:7007";
	        response = given()
	            .when()
	            .get("/movies/" + movieId);
	    }

	    @When("I retrieve the movie details")
	    public void i_retrieve_the_movie_details() {
	        // This is done in the given step for this scenario.
	    }

	    @Then("the movie title should be {string}")
	    public void the_movie_title_should_be(String title) {
	        response.then().statusCode(200);
	        response.then().body("title", equalTo(title));
	    }

	    @Given("I am at the movie search endpoint with title {string}")
	    public void i_am_at_the_movie_search_endpoint_with_title(String title) {
	        RestAssured.baseURI = "http://localhost:7007";
	        response = given()
	            .queryParam("title", title)
	        .when()
	            .get("/movies/search");
	    }

	    @When("I search for movies by title")
	    public void i_search_for_movies_by_title() {
	        // This is done in the given step for this scenario.
	    }

	    @Then("I should find movies with the title {string}")
	    public void i_should_find_movies_with_the_title(String title) {
	        response.then().statusCode(200);
	        response.then().body("title", hasItem(title));
	    }

	    @Given("I am at the movie filter endpoint with genre {string}")
	    public void i_am_at_the_movie_filter_endpoint_with_genre(String genre) {
	        RestAssured.baseURI = "http://localhost:7007";
	        response = given()
	            .queryParam("genre", genre)
	        .when()
	            .get("/movies/filter");
	    }

	    @When("I filter movies by genre")
	    public void i_filter_movies_by_genre() {
	        // This is done in the given step for this scenario.
	    }

	    @Then("I should find movies with the genre {string}")
	    public void i_should_find_movies_with_the_genre(String genre) {
	        response.then().statusCode(200);
	        response.then().body("genre", hasItem(genre));
	    }
	    
//rental
	    
	    @When("I send a GET request to {string}")
	    public void i_send_a_get_request_to(String endpoint) {
	        response = given().when().get(endpoint);
	    }

	    @Then("the response status should be {int}")
	    public void the_response_status_should_be(int statusCode) {
	        response.then().statusCode(statusCode);
	    }

	    @Then("the response should contain rental with ID {int}")
	    public void the_response_should_contain_rental_with_id(int rentalId) {
	        response.then().body("id", equalTo(rentalId));
	    }

	   //update profile
	    
	    	   	
@When("I set the request body for updating user profile")

public void i_set_the_request_body_for_updating_user_profile() {

    response = RestAssured.given()

            .contentType(ContentType.JSON)

            .body("{ \"username\": \"updateduser\", \"email\": \"updateduser@example.com\" }")

            .when()

            .put("/users/1");

}

}