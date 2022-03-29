package stepdefinitions;

import commonutils.CommonUtils;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import responses.WeatherResponse;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Steps {
    ValidatableResponse validatableResponse;

    @BeforeAll
    public static void setBaseURI() throws Throwable {
        RestAssured.baseURI = CommonUtils.getCentralData("BaseUri");

    }

//    @And("User makes a request for creating a list")
//    public void createList(DataTable table) throws Throwable{
//        // Set the create list request data like list name,iso_639_1,description,public and iso_3166_1
//        ListRequest listRequest = setListRequest(table);
//        //Making post request for creating list
//        validatableResponse=given()
//                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
//                .header("Authorization", CommonUtils.getCentralData("authorization"))
//                .header("Content-Type", "application/json;charset=utf-8")
//                .pathParam("version",CommonUtils.getCentralData("version"))
//                .body(listRequest)
//                .when()
//                .post("/{version}/list")
//                .then();
//    }

    @When("User makes request to get weather details by {string} city and {string} country")
    public void userMakesRequestToGetWeatherDetailsByCityAndCountry(String city, String country) {
        validatableResponse = given()
                .pathParam("version", CommonUtils.getCentralData("version"))
                .queryParam("q", city + "," + country)
                .queryParam("APPID", CommonUtils.getCentralData("api_key"))
                .when()
                .get("data/{version}/weather")
                .then();
    }

    @Then("Verify that the request is successful and verify the response body contains weather information specific to {string} city of {string} country")
    public void verifyRequestWasSuccessfulAndVerifyTheResponseBody(String city, String country) {
        int responseCode = validatableResponse.extract().statusCode();
        Assertions.assertEquals(200, responseCode, "Expected response Code:" + 200 + "Actual response code:" + responseCode);
        WeatherResponse weatherResponse = validatableResponse.extract().as(WeatherResponse.class);
        Assertions.assertFalse(Double.isNaN(weatherResponse.getMain().getTemp()), "Temp is not a number");
        Assertions.assertEquals(city, weatherResponse.getName(), "Weather response contains city" + weatherResponse.getName() + " while the expected city is " + city);
        Map<String, String> countries = new HashMap<>();
        for (String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            countries.put(l.getDisplayCountry(), iso);
        }
        Assertions.assertEquals(countries.get(country), weatherResponse.getSys().getCountry(), "Weather response contains country" + weatherResponse.getSys().getCountry() + " while the expected city is " + country);
    }

    @When("User makes request to get weather details by city ID {int}")
    public void userMakesRequestToGetWeatherDetailsByCityID(int id) {
        System.out.println("jhjhjhj");
        validatableResponse = given()
                .pathParam("version", CommonUtils.getCentralData("version"))
                .queryParam("id", id)
                .queryParam("APPID", CommonUtils.getCentralData("api_key"))
                .when()
                .get("data/{version}/weather")
                .then();
    }

    @Then("Verify that the request is successful and verify the response body contains weather information specific to city having {int} ID")
    public void verifySuccessfulRequestAndResponseSpecificToCityID(int id) {
        int responseCode = validatableResponse.extract().statusCode();
        Assertions.assertEquals(200, responseCode, "Expected response Code:" + 200 + "Actual response code:" + responseCode);
        WeatherResponse weatherResponse = validatableResponse.extract().as(WeatherResponse.class);
        Assertions.assertFalse(Double.isNaN(weatherResponse.getMain().getTemp()), "Temp is not a number");
        Assertions.assertEquals(id, weatherResponse.getId(), "Expected city ID " + id + "and actual city Id in Response:" + weatherResponse.getId());
    }

    @When("User makes request to get weather details by {string} latitude and {string} longitude")
    public void userMakesRequestToGetWeatherDetailsByLatitudeAndLongitude(String latitude, String longitude) {
        validatableResponse = given()
                .pathParam("version", CommonUtils.getCentralData("version"))
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("APPID", CommonUtils.getCentralData("api_key"))
                .when()
                .get("data/{version}/weather")
                .then();
    }


    @Then("Verify that the request is successful and verify the response body contains weather information specific to {double} latitude and {double} longitude")
    public void verifyRequestIsSuccessfulAndResponseContainsInformationSpecificToLatitudeAndLongitude(double lat, double lon) {
        int responseCode = validatableResponse.extract().statusCode();
        Assertions.assertEquals(200, responseCode, "Expected response Code:" + 200 + "Actual response code:" + responseCode);
        WeatherResponse weatherResponse = validatableResponse.extract().as(WeatherResponse.class);
        Assertions.assertFalse(Double.isNaN(weatherResponse.getMain().getTemp()), "Temp is not a number");
        Assertions.assertEquals(lat, weatherResponse.getCoord().getLat(), "Expected Latitude " + lat + "and actual latitude in Response:" + weatherResponse.getCoord().getLat());
        Assertions.assertEquals(lon, weatherResponse.getCoord().getLon(), "Expected Longitude " + lon + "and actual longitude in Response:" + weatherResponse.getCoord().getLon());
    }

    @Then("Verify request response code is {int} and contains {string} message")
    public void verifyRequestResponseCodeAndContainsMessage(int code, String message) {
        int responseCode = validatableResponse.extract().statusCode();
        Assertions.assertEquals(code, responseCode, "Expected response Code:" + code + "Actual response code:" + responseCode);
        String errorCode = (String) validatableResponse.extract().response().getBody().as(HashMap.class).get("cod");
        String responseMessage = (String) validatableResponse.extract().response().getBody().as(HashMap.class).get("message");
        Assertions.assertEquals(String.valueOf(code), errorCode);
        Assertions.assertEquals(message, responseMessage);
    }

}
