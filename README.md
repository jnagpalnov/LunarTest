# LunarTest

<p>Scenarios Automated:</p>
<ul><li>Validate weather details based on city and country.</li>
<li>Validate weather details based on the valid city ID.</li>
  <li>Validate weather details based on the valid city latitude and longitude.</li>
  <li>Verify error on requesting weather details of city which does not exists in that country.</li>
   <li>Verify error on requesting weather details of city ID which is invalid.</li>
   <li>Validate error on requesting weather details based on the invalid latitude but with valid longitude.</li>
   <li>Validate error on requesting weather details based on the valid latitude but with invalid longitude.</li>
 <li>Validate error on requesting weather details based on the invalid string latitude and invalid String longitude.</li>
 <li>Validate error on requesting weather details based on the valid String latitude but with valid longitude.</li>
</ul>
<h3>Programming Language and Automation Tools</h3>
<ul><li>Programming Language:Java</li>
  <li> Build Tool: Gradle</li>
  <li> <b>rest-assured 5.0.0</b></li>
  <li> <b>Cucumber-java:7.2.3</b></li>
  <li> IDE: IntelliJ IDEA Community</li>
</ul>
<h3>Folder Structure Overview</h3>
<p>The major components of this projects are:</p>
   <ul>
  <li>src/main/java/stepdefinitions/steps.java: Code behind each test steps.</li>
  <li>src/test/resources/features/MovieDatabaseList.feature: Containing all the test scenarios</li>
  <li>src/test/java/runner/CucumberTestsRunner: Junit test runner class</li>
  <li>src/test/resources/features/CentralData.Properties: Containing <b>BaseUri, version and api_key.</b></li>
  <li>build/reports/tests/: Contains generated html report</li>
  </ul>
  <h3>Running Cucumber Tests:</h3>

  <ul>
    <li> Open the project as a Gradle Project in IDE such as InteliJ IDEA</li>
 <li><b>Run the "src/test/java/runner/CucumberTestRunner.java" class or execute "gradle clean test" command from terminal</b></li>
  </ul>
 <h3>Cucumber Html output:</h3>
 <p> After running the tests via CucumberTestRunner.java , HTML report "Cucumber-report.html" will be generated under <b>"build/reports/tests/cucumber"</b> folder.</p>