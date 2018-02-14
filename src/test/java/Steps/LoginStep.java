package Steps;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BaseUtil;
import Pages.Login;
import Pages.Logout;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep extends BaseUtil{

    public BaseUtil base;
    public Login Login;
    public Logout Logout;
    
    
    Properties prop = new Properties();
   	InputStream input = null;
   	
     public LoginStep(BaseUtil base) {
    	this.base = base;
    	Login = new Login(base.driver);
    	Logout = new Logout(base.driver);
    	
    }
    
    @Given("^Launch Browser and Navigate to CNet URL$")
    public void launchCNetURL() throws Throwable {
        input = new FileInputStream("resources//config//configuration.properties");
		prop.load(input);
		base.driver.manage().window().maximize();
		base.driver.get(prop.getProperty("BaseURL"));
    }
    
    @Then("^Switch to MainFrame$")
    public void switchToMainFrame() throws Throwable {
  
    	base.driver.switchTo().frame(Login.switch_to_Main_frame());
    }

    @Then("^Verify whether Login page is correctly opened or not$")
    public void verifyLoginPage() throws Throwable {
    	 String loginPageTitle = base.driver.getTitle();
    	 assertEquals("ServiceNow", loginPageTitle);
    }
    
    @When("^Enter Username and Password as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_Username_and_Password_as_and(String Username, String Password) throws Throwable {
    	Login.useridLocator().clear();
	   	Login.useridLocator().sendKeys(Username);
	   	Login.passwordLocator().clear();
	   	Login.passwordLocator().sendKeys(Password);
	   	Login.loginButton().click();
    }
    
    @Then("^Verify whether Home page is correctly opened or not$")
    public void verifyHomePage() throws Throwable {
		 String homePageTitle = base.driver.getTitle();
		 assertEquals("Home page loading... | ServiceNow", homePageTitle);
    }
    
   
    @When("^Click on User Menu Dropdown$")
    public void userMenuDropdown() throws Throwable {
	 	WebDriverWait wait = new WebDriverWait(base.driver, 10);
    	WebElement userMenuDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(Logout.user_info_dropdown()));
    	userMenuDropdownButton.click();
    }
    
  
    
    @When("^Click on Logout$")
    public void logout() throws Throwable {
	 	WebDriverWait wait = new WebDriverWait(base.driver, 10);
    	WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(Logout.logouButtont()));
    	logoutButton.click();
	}
    
   
    
 }
