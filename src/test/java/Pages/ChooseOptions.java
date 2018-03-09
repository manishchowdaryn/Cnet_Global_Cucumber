package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BaseUtil;

public class ChooseOptions {

	public BaseUtil base;
    
		public ChooseOptions(WebDriver driver) {

			PageFactory.initElements(driver, this);
 
    	}
    
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:a23b99e2dbf20300a68fda11cf9619fc']")
	    public WebElement serviceRequestedLookUp;
         	
     	@FindBy(how = How.LINK_TEXT, using = "Choose Options")
	    public WebElement chooseOptions;
		
     	@FindBy(how = How.XPATH, using = ".//*[@id='IO:4de538f5db541300f69ff11ebf961976']")
	    public WebElement clusterName;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:bdc83589dbf00300a68fda11cf961990']")
	    public WebElement operatingSystemLookUp;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:01c77d49dbf00300a68fda11cf961954']")
	    public WebElement serverSizeLookUp;
     	
     	@FindBy(how = How.XPATH, using = "//div[@id='IO:15042020db470300a68fda11cf9619f7']/div[2]/div/span[2]/div/span/label")
	    public WebElement selectNetworkexistingKeyPair;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:a2946820db470300a68fda11cf961983']")
	    public WebElement selectNetworkLookUP;
     	
     	@FindBy(how = How.XPATH, using = "//div[@id='IO:8212f9bbdb041300a68fda11cf96191c']/div[2]/div/span[2]/div/span/label")
	    public WebElement securityGroup;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:0d73f9fbdb041300a68fda11cf961940']")
	    public WebElement securityGroupLookUp;
     	
     
     	@FindBy(how = How.XPATH, using = "//div[@id='IO:15042020db470300a68fda11cf9619f7']/div[2]/div/span[2]/div/span/label")
	    public WebElement databaseselectNetworkexistingKeyPair;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:a2946820db470300a68fda11cf961983']")
	    public WebElement databaseselectNetworkLookUP;
     	
     	
     	@FindBy(how = How.XPATH, using = "//div[@id='IO:8212f9bbdb041300a68fda11cf96191c']/div[2]/div/span[2]/div/span/label")
	    public WebElement databaseSecurityGroup;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:0d73f9fbdb041300a68fda11cf961940']")
	    public WebElement databaseSecurityGroupLookUP;
     	
   
     	@FindBy(how = How.XPATH, using = ".//*[@id='next_tab']")
	    public WebElement nextTab;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:0e6e99a6dbf20300a68fda11cf961989']")
	    public WebElement databaseServiceRequestedLookUp;
        
     	@FindBy(how = How.XPATH, using = ".//*[@id='IO:4de538f5db541300f69ff11ebf961976']")
	    public WebElement databaseClusterName;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:bdc83589dbf00300a68fda11cf961990']")
	    public WebElement databaseOperatingSystemLookUp;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='next_page']")
	    public WebElement checkOut;
        
     	@FindBy(how = How.XPATH, using = ".//*[@id='header_button_checkout_in_header']")
	    public WebElement orderNow;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='sc_order_status_intro_text']/div[1]/span")
	    public WebElement successMessage;
     
     	@FindBy(how = How.XPATH, using = ".//*[@id='requesturl']/b")
	    public WebElement getRequestNumber;
     	
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='sc_cart.do']/table/tbody/tr/td[2]/div")
	    public WebElement shoppingCart;
     	
     	
     	public WebElement shoppingCart() {
			return shoppingCart;
		}
     	    
     	
     	
     	public WebElement chooseOptions() {
			return chooseOptions;
		}
     	     
	    public WebElement serviceRequestedLookUp() {
			return serviceRequestedLookUp;
		}
	    
	    public WebElement clusterName() {
			return clusterName;
		}
	    
	    public WebElement operatingSystemLookUp() {
			return operatingSystemLookUp;
		}
	    
	    public WebElement serverSizeLookUp() {
			return serverSizeLookUp;
		}
	    
	    public WebElement nextTab() {
			return nextTab;
		}
	    
	    public WebElement databaseServiceRequestedLookUp() {
			return databaseServiceRequestedLookUp;
		}
	    
	    public WebElement databaseClusterName() {
			return databaseClusterName;
		}
	    
	    public WebElement databaseOperatingSystemLookUp() {
			return databaseOperatingSystemLookUp;
		}
	    
	    public WebElement checkOut() {
			return checkOut;
		}
	    
	    public WebElement orderNow() {
			return orderNow;
		}
	    
	    public WebElement successMessage() {
			return successMessage;
		}
	    
	    public WebElement getRequestNumber() {
			return getRequestNumber;
		}
	    
	    public WebElement selectNetworkexistingKeyPair() {
			return selectNetworkexistingKeyPair;
		}
	    
	    public WebElement selectNetworkLookUP() {
			return selectNetworkLookUP;
		}
	    	    
	    public WebElement securityGroup() {
			return securityGroup;
		}
	    
	    public WebElement securityGroupLookUp() {
			return securityGroupLookUp;
		}
	    
	    public WebElement databaseselectNetworkexistingKeyPair() {
			return databaseselectNetworkexistingKeyPair;
		}
	    
	    public WebElement databaseselectNetworkLookUP() {
			return databaseselectNetworkLookUP;
		}
	    
	    
	    
	    public WebElement databaseSecurityGroup() {
			return databaseSecurityGroup;
		}
	    
	    public WebElement databaseSecurityGroupLookUP() {
			return databaseSecurityGroupLookUP;
		}
	    
	    
	   
	   
}
