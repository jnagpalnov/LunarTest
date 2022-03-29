Feature: Weather Testing

  Scenario: Validate weather details based on city and country
    When User makes request to get weather details by "London" city and "UK" country
    Then Verify that the request is successful and verify the response body contains weather information specific to "London" city of "United Kingdom" country

  Scenario: Validate weather details based on the valid city ID
    When User makes request to get weather details by city ID 2172797
    Then Verify that the request is successful and verify the response body contains weather information specific to city having 2172797 ID

  Scenario: Validate weather details based on the valid city latitude and longitude
    When User makes request to get weather details by "35" latitude and "109" longitude
    Then Verify that the request is successful and verify the response body contains weather information specific to 35 latitude and 109 longitude

  Scenario: Verify error on requesting weather details of city which does not exists in that country
    When User makes request to get weather details by "Stockholm" city and "UK" country
    Then Verify request response code is 404 and contains "city not found" message

  Scenario: Verify error on requesting weather details of city ID which is invalid
    When User makes request to get weather details by city ID 8787
    Then Verify request response code is 404 and contains "city not found" message

  Scenario: Validate error on requesting weather details based on the invalid latitude but with valid longitude
    When User makes request to get weather details by "367675" latitude and "109" longitude
    Then Verify request response code is 400 and contains "wrong latitude" message

  Scenario: Validate error on requesting weather details based on the valid latitude but with invalid longitude
    When User makes request to get weather details by "35" latitude and "367675" longitude
    Then Verify request response code is 400 and contains "wrong longitude" message

  Scenario: Validate error on requesting weather details based on the invalid string latitude and invalid String longitude
    When User makes request to get weather details by "3hj5" latitude and "367jk675" longitude
    Then Verify request response code is 400 and contains "wrong latitude" message

  Scenario: Validate error on requesting weather details based on the valid String latitude but with valid longitude
    When User makes request to get weather details by "35" latitude and "367jk675" longitude
    Then Verify request response code is 400 and contains "wrong longitude" message

#  Scenario: Validate all the weather details
#    When User makes request to get weather details by "London" city and "UK" country
#    Then Verify request is successful and verify the every field of response body


