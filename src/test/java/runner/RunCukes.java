package runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.Reporter;
import com.cucumber.listener.ExtentProperties;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"resources/features"} ,
				 monochrome = true,
				 glue = "steps",
				 tags = "@EndToEndDeployment",
				 plugin= {"html:target/site/cucumber-report-html",
					      "json:target/cucumber.json",
					      "pretty:target/cucumber-pretty.txt",
					      "usage:target/cucumber-usage.json",
						  "com.cucumber.listener.ExtentCucumberFormatter:"})

public class RunCukes extends AbstractTestNGCucumberTests{
	
	
	// End to end
	
	// End tot end2
	
	// abc
	
	
	/*@BeforeClass
    public static void setup() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.getReportPath();
    }
	
	 @AfterClass
	    public static void teardown() {
	        Reporter.loadXMLConfig(new File("extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("os", "Windows");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	    }*/
}
