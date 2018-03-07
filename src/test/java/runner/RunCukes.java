package runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import listener.ExtentProperties;
import listener.Reporter;

@CucumberOptions(features = {"resources/features"} ,
				 monochrome = true,
				 glue = "steps",
				 tags = "@EndToEndDeployment",
				 plugin= {"pretty",
					        "html:target/site/cucumber-report-html",
					        "json:target/cucumber.json",
					        "pretty:target/cucumber-pretty.txt",
					        "usage:target/cucumber-usage.json",
							"com.cucumber.listener.ExtentCucumberFormatter:"})

public class RunCukes extends AbstractTestNGCucumberTests{
	
	@BeforeClass
	public static void Setup(){
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.getReportPath();
		
	}
	
	@AfterClass
	public static void teardown(){
		Reporter.loadXMLConfig(new File("extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 7");
		
	}

}
