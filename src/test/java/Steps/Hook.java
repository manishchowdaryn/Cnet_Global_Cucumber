package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import listener.ExtentProperties;

public class Hook extends BaseUtil{

    private BaseUtil base;
       
    public Hook(BaseUtil base) {
        this.base = base;
    }

    public static String scenarioName;
    Properties prop = new Properties();
	InputStream input = null;
	
  
    @Before
    public void InitializeTest(Scenario scenario) throws IOException {
		
    	scenarioName= scenario.getName();
		System.out.println(scenarioName);
		
		input = new FileInputStream("resources//config//configuration.properties");
		prop.load(input);
		
		String browserName = prop.getProperty("BrowserName");
		System.out.println(browserName);
		System.out.println(prop.getProperty("BaseURL"));
		//Reporter.assignAuthor("Maneesh Nama");
		
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.getReportPath();
        
		if(browserName.equalsIgnoreCase("FireFox")){
			 File file = new File("driver//geckodriver.exe");
			 System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
			 base.driver = new FirefoxDriver();
			 base.driver.manage().window().maximize();
			 		
		} else if(browserName.equalsIgnoreCase("Chrome")){
			 File file = new File("driver//chromedriver.exe");
			 System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			 base.driver = new ChromeDriver();
			 base.driver.manage().window().maximize();
			 
		} else if(browserName.equalsIgnoreCase("IE")){
			File file = new File("driver//IEDriverServer.exe");
		    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			base.driver = new InternetExplorerDriver();
			base.driver.manage().window().maximize();
			
		} else {
			
            throw new IllegalArgumentException("The Browser Type is Undefined");
            
     }
        
    }

    @After(order = 1)
	public void afterScenario(Scenario scenario) {
		
    	if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the Extent-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/ExtentReport/screenshots/" + screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
 
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			
			} 
		}
	}
	
	
	@After(order = 0)
	public void AfterSteps() {
		base.driver.quit();
	}
	
}
