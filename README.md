## Description
This is a sample automated test for validating an Image Search app end to end functionality using Selenium WebDriver

## Pre-requisites

1. Download latest Java SE Development Kit from the [website](https://www.oracle.com/java/technologies/downloads/#java8).
2. Download and extract the latest applicable [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads
   ).
3. Download and install [IntelliJ](https://www.jetbrains.com/idea/download/).
4. Download the project from [github](https://github.com/jldaluddung/upgrowth_app_webDriverTest.git) as a zip file.

Note: If you want to run TestSample_Saucelab.java, you need a Saucelaub account and update the code with the username and token.

## Running the test form IntelliJ
1. Extract the downloaded [github](https://github.com/jldaluddung/upgrowth_app_webDriverTest.git) project
2. Run IntelliJ
3. Open the project by selecting the extracted folder
4. Open TestSample.java and edit code:
   1. In Line14, make sure the path is set to where you have downloaded chromedriver
   2. In Line31, set searchTerm to a term you want to find images with
5. Build the project 
6. Run TestSample.java
7. See test run and once done results are in the console.