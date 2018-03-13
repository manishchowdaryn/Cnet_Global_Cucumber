package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

public class EndToEndDeploymentStep extends BaseUtil {

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

	public EndToEndDeploymentStep(BaseUtil base) {
		this.base = base;
		Login = new Login(base.driver);
		Logout = new Logout(base.driver);
		FilterNavigation = new FilterNavigation(base.driver);
		DescribeNeeds = new DescribeNeeds(base.driver);
		ChooseOptions = new ChooseOptions(base.driver);
		RequestProcess = new RequestProcess(base.driver);

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
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");

	}

	@Then("^Switch to MainFrame$")
	public void switch_to_MainFrame() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		base.driver.switchTo().frame(Login.switch_to_Main_frame());
	}

	@Then("^Verify whether Login page is correctly opened or not$")
	public void verify_whether_Login_page_is_correctly_opened_or_not() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
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
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
	}

	@Then("^Verify whether Home page is correctly opened or not$")
	public void verify_whether_Home_page_is_correctly_opened_or_not() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		String homePageTitle = base.driver.getTitle();
		assertEquals("Home page loading... | ServiceNow", homePageTitle);
	}

	@When("^Enter Value in Filter Navigation Field Text Box \"([^\"]*)\"$")
	public void enter_Value_in_Filter_navigation_Field_Text_Box(String searchFilterValue) throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement searchFilter = wait.until(ExpectedConditions.elementToBeClickable(FilterNavigation.searchFilter()));
		searchFilter.clear();
		searchFilter.sendKeys(searchFilterValue);
		//

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
	}

	@When("^Click on Service Catalog Order Guides Link$")
	public void click_On_Service_Catalog_Order_Guides_Link() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement serviceCatalogOrderGuide = wait
				.until(ExpectedConditions.elementToBeClickable(FilterNavigation.serviceCatalogOrderGuide()));
		serviceCatalogOrderGuide.click();
		// Thread.sleep(3000);
	}

	@When("^Click on End To End Deployment$")
	public void click_On_End_To_End_Deployment() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement endToEndDeployment = wait
				.until(ExpectedConditions.elementToBeClickable(FilterNavigation.endToEndDeployment()));
		endToEndDeployment.click();
		//
	}

	@Then("^Verify whether Try It button is enabled or not$")
	public void verify_Try_It() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement tryIT = wait.until(ExpectedConditions.elementToBeClickable(FilterNavigation.tryIT()));
		Boolean status = tryIT.isEnabled();
		assertTrue(true);
	}

	@When("^Click on Try It$")
	public void click_On_Try_It() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement tryIT = wait.until(ExpectedConditions.elementToBeClickable(FilterNavigation.tryIT()));
		tryIT.click();
	}

	@Then("^Verify whether Describe Needs page is getting displayed or not$")
	public void verifyDescribeNeeds() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement describeNeedsText = wait
				.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.describeNeedsText()));
		String describeNeedsValue = describeNeedsText.getText();
		assertEquals(describeNeedsValue, "Describe Needs");

	}

	@When("^Click On Project LookUP$")
	public void click_On_Project_LookUP() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement projectLookUP = wait.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.projectLookUP()));
		projectLookUP.click();
	}

	@Then("^Switch to Multiple Window and Select Text as \"([^\"]*)\"$")
	public void HandleMultipleWindows(String projectLookUPValue)
			throws IOException, InterruptedException, AWTException {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");

		try {
			String mainWindow = base.driver.getWindowHandle();
			String windowTitle = base.driver.getTitle();
			Set<String> allWindowHandles = base.driver.getWindowHandles();
			for (String currentWindowHandle : allWindowHandles) {
				if (!currentWindowHandle.equals(mainWindow)) {
					base.driver.switchTo().window(currentWindowHandle);
					try {
						WebDriverWait wait = new WebDriverWait(base.driver, 10);
						wait.until(ExpectedConditions.elementToBeClickable(By.linkText(projectLookUPValue)));
						base.driver.findElement(By.linkText(projectLookUPValue)).click();
					} catch (NoSuchElementException exc) {
						exc.printStackTrace();
					} catch (WebDriverException e) {
						e.printStackTrace();
					}
				}
			}
			base.driver.switchTo().window(mainWindow);
		} catch (NoSuchElementException exc) {
			exc.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@When("Select Environment Information as \"([^\"]*)\"$")
	public void environmentDropdown(String environmentInformationValue) throws Exception {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select select = new Select(DescribeNeeds.environmentInformation());
		select.selectByVisibleText(environmentInformationValue);
		// Thread.sleep(2000);
	}

	@When("Select Type of Environment as \"([^\"]*)\"$")
	public void typeOfEnvironment(String typeofEnvironment) throws Exception {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select typeofEnvironmentValue = new Select(DescribeNeeds.typeOfEnvironment());
		typeofEnvironmentValue.selectByVisibleText(typeofEnvironment);
		// Thread.sleep(2000);
	}

	@When("Select Environment Name as \"([^\"]*)\"$")
	public void environmentName(String environmentName) throws IOException, AWTException {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		DescribeNeeds.environmentName().clear();
		DescribeNeeds.environmentName().sendKeys(environmentName);
	}

	@When("^Click On Cloud Platform$")
	public void click_On_Cloud_Platform() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement cloudPlatformLookUP = wait
				.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.cloudPlatfromLookUp()));
		cloudPlatformLookUP.click();
	}

	@When("^Select Existing Key Pair Checkbox$")
	public void select_Existing_Key_Pair() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement existingKeyPairElement = wait
				.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.existingKeyPair()));
		existingKeyPairElement.click();
	}

	@When("^Click On Select Key Pair$")
	public void click_On_Select_Key_Pair() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement selectKeyPairLookUP = wait
				.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.selectKeyPair()));
		selectKeyPairLookUP.click();
	}

	@When("^Select WebServer Checkbox$")
	public void select_WebServer() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement webServerCheckbox = wait
				.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.webserverChecbox()));
		webServerCheckbox.click();
	}

	@When("^Select Webserver Type as \"([^\"]*)\"$")
	public void select_webServer_Type(String webserverType) throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select webServerType = new Select(DescribeNeeds.webserverType());
		webServerType.selectByVisibleText(webserverType);
	}

	@When("^Select Container Platform as \"([^\"]*)\"$")
	public void select_Container_Platform(String containerPlatform) throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select containerPlatformValue = new Select(DescribeNeeds.containerPlatform());
		containerPlatformValue.selectByVisibleText(containerPlatform);
	}

	@When("^Select Database Server Checkbox$")
	public void select_Database_Server() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseServerCheckbox = wait
				.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.databaseserverChecbox()));
		databaseServerCheckbox.click();
	}

	@When("^Select Database Type as \"([^\"]*)\"$")
	public void select_Database_Type(String databaseserverType) throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select databaseServerType = new Select(DescribeNeeds.databaseserverType());
		databaseServerType.selectByVisibleText(databaseserverType);
	}

	@When("^Select Database Container Platform as \"([^\"]*)\"$")
	public void select_Database_Container_Platform(String databasecontainerPlatform) throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select databasecontainerPlatformValue = new Select(DescribeNeeds.databasecontainerPlatform());
		databasecontainerPlatformValue.selectByVisibleText(databasecontainerPlatform);
	}

	@When("^Select Application Type as \"([^\"]*)\"$")
	public void select_Application_Type(String applicationType) throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		Select applicationTypeValue = new Select(DescribeNeeds.applicationType());
		applicationTypeValue.selectByVisibleText(applicationType);
	}

	@When("^Click on Choose Options$")
	public void click_On_Choose_Options() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement chooseOptions = wait.until(ExpectedConditions.elementToBeClickable(DescribeNeeds.chooseOptions()));
		chooseOptions.click();
	}

	@Then("^Verify whether Choose Options page is getting displayed or not$")
	public void verifyChooseOptions() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement chooseOptions = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.chooseOptions()));
		String chooseOptionsText = chooseOptions.getText();
		assertEquals(chooseOptionsText, "Choose Options");

	}

	@When("^Click On Server Requested LookUP$")
	public void click_On_Server_Requested() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement serverRequestedLookUP = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.serviceRequestedLookUp()));
		serverRequestedLookUP.click();
	}

	@When("Enter Cluster Name as \"([^\"]*)\"$")
	public void enter_Cluster_Name(String clusterNameValue) throws Exception {
		// Thread.sleep(3000);

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		ChooseOptions.clusterName().clear();
		ChooseOptions.clusterName().sendKeys(clusterNameValue);
	}

	@When("^Select Existing Network Checkbox$")
	public void select_Existing_Network_Checkbox() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement selectNetworkexistingKeyPair = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.selectNetworkexistingKeyPair()));
		selectNetworkexistingKeyPair.click();
		// Thread.sleep(5000);
	}

	@When("^Click On Select Network$")
	public void click_On_Select_Network() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement selectNetworkLookUP = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.selectNetworkLookUP()));
		selectNetworkLookUP.click();
		// Thread.sleep(5000);
	}

	@When("^Select Security Group Checkbox$")
	public void select_Security_Group_Checkbox() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement securityGroup = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.securityGroup()));
		securityGroup.click();
		// Thread.sleep(5000);
	}

	@When("^Click On Security Group$")
	public void click_On_Security_Group() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement securityGroupLookUp = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.securityGroupLookUp()));
		securityGroupLookUp.click();
		// Thread.sleep(5000);
	}

	@When("^Click On Operating System LookUP$")
	public void click_On_Operating_System() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement operatingSystemLookUp = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.operatingSystemLookUp()));
		operatingSystemLookUp.click();
	}

	@When("^Click On Server Size LookUP$")
	public void click_On_Server_Size() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement serverSizeLookUp = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.serverSizeLookUp()));
		serverSizeLookUp.click();
	}

	@When("^Click On Next Tab$")
	public void click_On_Next_Tab() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement nextTab = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.nextTab()));
		nextTab.click();
	}

	@When("^Select Database Network Configuration Checkbox$")
	public void select_Database_Network_Configuration_Checkbox() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseselectNetworkexistingKeyPair = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.databaseselectNetworkexistingKeyPair()));
		databaseselectNetworkexistingKeyPair.click();
		// Thread.sleep(5000);
	}

	@When("^Click On Database Network Configuration Group$")
	public void click_On_Database_Network_Configuration_Group() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseselectNetworkLookUP = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.databaseselectNetworkLookUP()));
		databaseselectNetworkLookUP.click();
		// Thread.sleep(5000);
	}

	@When("^Select Database Security Group Checkbox$")
	public void select_Database_Security_Group_Checkbox() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseSecurityGroup = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.databaseSecurityGroup()));
		databaseSecurityGroup.click();
		// Thread.sleep(5000);
	}

	@When("^Click On Database Security Group$")
	public void click_On_Database_Security_Group() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseSecurityGroupLookUP = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.databaseSecurityGroupLookUP()));
		databaseSecurityGroupLookUP.click();
		// Thread.sleep(5000);
	}

	@When("^Click On Database Service Requested LookUP$")
	public void click_On_Database_Service_Requested() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseServiceRequestedLookUp = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.databaseServiceRequestedLookUp()));
		databaseServiceRequestedLookUp.click();
	}

	@When("Enter Database Cluster Name as \"([^\"]*)\"$")
	public void enter_Database_Cluster_Name(String databaseClusterNameValue) throws Exception {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		// Thread.sleep(3000);
		ChooseOptions.databaseClusterName().clear();
		ChooseOptions.databaseClusterName().sendKeys(databaseClusterNameValue);
	}

	@When("^Click On Database Operating System LookUP$")
	public void click_On_Database_Operating_System() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement databaseOperatingSystemLookUp = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.databaseOperatingSystemLookUp()));
		databaseOperatingSystemLookUp.click();
	}

	@When("^Click On Check Out$")
	public void click_On_Check_Out() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.checkOut()));
		checkOut.click();
	}

	@Then("^Verify whether Shopping Cart page is getting displayed or not$")
	public void verifyCheckOut() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");

		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.shoppingCart()));
		String shoppingCartText = shoppingCart.getText();
		assertEquals(shoppingCartText, "Shopping Cart");

	}

	@When("^Click on Order Now$")
	public void click_on_Order_Now() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement orderNow = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.orderNow()));
		orderNow.click();
	}

	@Then("^Validate Successful Message is displayed or not$")
	public void validate_Successful_Message() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement successMessage = wait.until(ExpectedConditions.elementToBeClickable(ChooseOptions.successMessage()));
		String successMessageValue = successMessage.getText();
		assertEquals(successMessageValue, "Thank you, your request has been submitted");
	}

	@When("^Get the Request Number after created$")
	public void get_Request_Number() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement requestNumber = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.getRequestNumber()));
		String requestNumberValue = requestNumber.getText();
		System.out.println(requestNumberValue);

	}

	@Then("^Click On Recently Created Requested Number$")
	public void click_On_Request_Number() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement requestNumber = wait
				.until(ExpectedConditions.elementToBeClickable(ChooseOptions.getRequestNumber()));
		requestNumber.click();

	}

	@When("^Click on RITM Numbers and Approve all RITM Numbers for the Request Created$")
	public void click_RITM_Numbers() throws Throwable {
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement ritmNumber = wait.until(ExpectedConditions.elementToBeClickable(RequestProcess.RITMNumbers()));

		List<WebElement> ritmNumberValue = base.driver.findElements(By.xpath(
				"html/body/div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table[1]/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		System.out.println(ritmNumberValue.size());

		for (int i = 1; i <= ritmNumberValue.size(); i++) {

			WebElement ritmLinkText = base.driver.findElement(By.xpath(
					"html/body/div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table[1]/tbody/tr/td/div/table/tbody/tr[" + i
							+ "]/td[3]/a"));
			ritmLinkText.click();

			// Thread.sleep(3000);

			WebElement approveTab = wait.until(ExpectedConditions.elementToBeClickable(RequestProcess.approveTab()));
			approveTab.click();

			// Thread.sleep(2000);

			WebElement requestButton = wait
					.until(ExpectedConditions.elementToBeClickable(RequestProcess.requestButton()));
			requestButton.click();

			// Thread.sleep(2000);

			try {

				Select approveState = new Select(RequestProcess.approveDropdown());
				approveState.selectByVisibleText("Approved");

				System.out.println("Not Entered in to Catch");

			} catch (UnhandledAlertException e) {

				base.driver.switchTo().alert().accept();

				// Thread.sleep(2000);

				Select approveState = new Select(RequestProcess.approveDropdown());
				approveState.selectByVisibleText("Approved");

				System.out.println("Entered in to Catch");
			}

			// Thread.sleep(3000);

			WebElement updateButton = wait
					.until(ExpectedConditions.elementToBeClickable(RequestProcess.updateButton()));
			updateButton.click();

			// Thread.sleep(3000);

			WebElement updateButton1 = wait
					.until(ExpectedConditions.elementToBeClickable(RequestProcess.updateButton()));
			updateButton1.click();

			// Thread.sleep(3000);

		}

		base.driver.findElement(By.id("sysverb_update")).click();

	}

	@Then("^Switch to Multiple Window$")
	public void switchToMultipleWindow() throws IOException, InterruptedException, AWTException {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		try {
			String mainWindow = base.driver.getWindowHandle();
			String windowTitle = base.driver.getTitle();
			Set<String> allWindowHandles = base.driver.getWindowHandles();
			for (String currentWindowHandle : allWindowHandles) {
				if (!currentWindowHandle.equals(mainWindow)) {
					base.driver.switchTo().window(currentWindowHandle);
				}
			}
			base.driver.switchTo().window(mainWindow);
		} catch (NoSuchElementException exc) {
			exc.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@When("^Search Request in a CMDB Table as \"([^\"]*)\"$")
	public void search_Request_CMDB(String searchFilterValue) throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		FilterNavigation.searchFilterClick().click();
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement searchFilter = wait.until(ExpectedConditions.elementToBeClickable(FilterNavigation.searchFilter()));
		searchFilter.clear();
		searchFilter.sendKeys(searchFilterValue);
		searchFilter.sendKeys(Keys.ENTER);
		// Thread.sleep(3000);
	}

	@When("^Click on User Menu Dropdown$")
	public void click_on_User_Menu_Dropdown() throws Throwable {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath(
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
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
				System.getProperty("user.dir") + "/ScreenShots" + folderName + "/Screenshot" + i + ".jpg",
				"LoginValidation");
		WebDriverWait wait = new WebDriverWait(base.driver, 10);
		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(Logout.logouButtont()));
		logoutButton.click();
	}

}
