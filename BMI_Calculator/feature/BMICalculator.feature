
Feature: BMI Calculator

@Regression
  Scenario Outline: Calculate BMI , Capture the Result and Print it
  
    Given BMI Calculator is launched
    When Title of the page is matched
    Then Enter Age "<age>"
    And Enter Height "<height>"
    And Enter Weight "<weight>"
    And Tap on Calculate BMI
    And Capture & Print the Result
    And Close the browser
    

Examples: 
|age|height|weight|
|10|127|40|
|30|156|70|
|25|152|55|
|20|160|45|
|35|160|70|

