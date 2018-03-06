package runner;


import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"resources/features/EndToEndDeployment.feature"} ,
				 monochrome = true,
				 glue = "steps",
				 tags = "@EndToEndDeployment",
				 plugin= {"html:target/site/cucumber-report-html",
					      "json:target/cucumber.json",
					      "pretty:target/cucumber-pretty.txt",
					      "usage:target/cucumber-usage.json",
						  "com.cucumber.listener.ExtentCucumberFormatter:ExtentReport/report.html"})




public class RunCukes extends AbstractTestNGCucumberTests{
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("extent-config.xml");
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	}
	
}
