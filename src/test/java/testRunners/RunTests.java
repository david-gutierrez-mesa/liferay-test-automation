package testRunners;

import browserManager.DriverManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinition" }, plugin = { "pretty",
		"html:target/cucumber-reports" })
public class RunTests {

	@AfterClass
	public static void afterClass(){
		DriverManager.quitDriver();
	}
}