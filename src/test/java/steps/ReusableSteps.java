package steps;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import Base.BaseUtil;
import Pages.ChooseOptions;
import Pages.DescribeNeeds;
import Pages.FilterNavigation;
import Pages.Login;
import Pages.Logout;
import Pages.RequestProcess;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReusableSteps extends BaseUtil {

		public BaseUtil base;
		public Login Login;
		public Logout Logout;
		public FilterNavigation FilterNavigation;
		public DescribeNeeds DescribeNeeds;
		public ChooseOptions ChooseOptions;
		public RequestProcess RequestProcess;
		static String folderName;

		Properties prop = new Properties();
		InputStream input = null;

		public ReusableSteps(BaseUtil base) {
			this.base = base;
			Login = new Login(base.driver);
			Logout = new Logout(base.driver);
		}

		@Given("^Launch Browser and Navigate to CNet URL$")
		public void launch_Browser_and_Navigate_to_CNet_URL() throws Throwable {
			input = new FileInputStream("resources//config//configuration.properties");
			prop.load(input);
			base.driver.manage().window().maximize();
			base.driver.get(prop.getProperty("BaseURL"));

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");

		}

		@Then("^Switch to MainFrame$")
		public void switch_to_MainFrame() throws Throwable {

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");
			base.driver.switchTo().frame(Login.switch_to_Main_frame());
		}

		@Then("^Verify whether Login page is correctly opened or not$")
		public void verify_whether_Login_page_is_correctly_opened_or_not() throws Throwable {

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");
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

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");
		}

		@Then("^Verify whether Home page is correctly opened or not$")
		public void verify_whether_Home_page_is_correctly_opened_or_not() throws Throwable {

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");
			String homePageTitle = base.driver.getTitle();
			assertEquals("Home page loading... | ServiceNow", homePageTitle);
		}

		@When("^Click on User Menu Dropdown$")
		public void click_on_User_Menu_Dropdown() throws Throwable {

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");
			WebDriverWait wait = new WebDriverWait(base.driver, 10);
			WebElement userMenuDropdownButton = wait
					.until(ExpectedConditions.elementToBeClickable(Logout.user_info_dropdown()));
			userMenuDropdownButton.click();
		}

		@When("^Click on Logout$")
		public void click_on_Logout() throws Throwable {

			folderName = Reporter.createFolder();
			int i = Reporter.takescreenshot();
			Reporter.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + folderName + "/Screenshot" + i + ".jpg",
					"LoginValidation");
			WebDriverWait wait = new WebDriverWait(base.driver, 10);
			WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(Logout.logouButtont()));
			logoutButton.click();
		}
}
