package org.runner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilities.JvmReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src\\test\\resources\\Feature",glue = "org.stepdefinition",monochrome = true,dryRun = false,
	plugin= {"junit:target\\Reports\\amazon.xml"})
public class TestRunner {
		@AfterClass
		public static void generateReport() {
JvmReports.generateJvmReport("C:\\Users\\suren\\eclipse-workspace\\MavenTesting1\\target\\Reports\\amazon.json");
		}

}
