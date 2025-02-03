# MITTPP
Project task for college course Methods and techniques of testing software support
# Automated UI Testing with Selenium and TestNG

This project contains automated UI tests for the official website of NK Osijek using Selenium WebDriver and TestNG.

## Technologies Used
- **Java**: Programming language for the test scripts
- **Selenium WebDriver**: For browser automation
- **TestNG**: Testing framework for structuring and executing test cases
- **WebDriverManager**: For managing the Chrome WebDriver
- **Google Chrome**: Browser used for testing

## Project Structure
- **HomePage.java**: Page Object Model (POM) class for the homepage containing methods for interactions
- **VijestiPage.java**: POM class for the "Vijesti" (News) page
- **HomePageTest.java**: Test class containing test cases for the homepage functionality

## Prerequisites
1. Install **Java 8+**
2. Install **Maven** (for dependency management)
3. Install **Google Chrome**

## Setup Instructions
1. Clone this repository:
   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```
3. Run the test suite using TestNG:
   ```sh
   mvn test
   ```

## Running Tests Manually
You can run the tests manually using TestNG:
1. Open `HomePageTest.java`
2. Right-click the file and select **Run as TestNG Test** (if using an IDE like IntelliJ or Eclipse)
3. Or, execute the following command:
   ```sh
   mvn test -Dtest=HomePageTest
   ```

## Test Cases
| Test Case | Description |
|-----------|------------|
| `testHomePageTitle` | Verifies that the homepage title is correct |
| `testVijestiPageTitle` | Ensures that clicking the 'Pogledaj Više' button navigates to the correct page |
| `testSocialLinksArePresent` | Checks if social media links are present on the homepage |
| `testClickOpusGlobalImage` | Clicks the Opus Global image and verifies redirection |
| `testPogledajViseNavigation` | Ensures the 'Pogledaj Više' button navigates to the correct URL |

## Notes
- The `acceptCookies()` method ensures tests are not interrupted by cookie pop-ups.
- The `@BeforeMethod` annotation sets up the WebDriver before each test.
- The `@AfterMethod` annotation ensures the WebDriver quits after each test to prevent memory leaks.

## Troubleshooting
- **WebDriver not found**: Ensure that the WebDriverManager setup command is included in the `setUp()` method.
- **Element not found errors**: Inspect the website for any UI changes that might require updating locators.
- **Chrome issues**: Ensure that the Chrome browser is updated to the latest version.
