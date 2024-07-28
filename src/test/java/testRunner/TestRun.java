package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features = {".//features"},glue="stepDefinitions") //.feature means it will execute all the files which are inside the folder
@CucumberOptions(
		features = { ".//features/Login.feature" },
		//features = { ".//features" }, 
		glue = "stepDefinitions", 
		plugin = { "pretty",
		"html:Junit_reports/myreport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		// "rerun:target/rerun.txt",
		},
		dryRun = true, // checks mapping between scenario steps and step definition methods
		monochrome = true, // to avoid junk characters in output
		publish = true // to publish report in cucumber server
) // it will run only one feature file i.e login.featurefile
public class TestRun {

}
