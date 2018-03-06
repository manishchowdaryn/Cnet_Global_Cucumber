package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.BaseUtil;

public class FilterNavigation {

	public BaseUtil base;
    
    public FilterNavigation(WebDriver driver) {

 	   PageFactory.initElements(driver, this);
 
    }
    
     	@FindBy(how = How.XPATH, using = ".//*[@id='filter']")
	    public WebElement searchFilter;
     	
     	@FindBy(how = How.ID, using = "nav_filter_controls")
	    public WebElement searchFilterClick;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='gsft_nav']/div/magellan-favorites-list/div/div[2]/div/a/div[2]/span")
	    public WebElement serviceCatalogOrderGuide;
    
     	@FindBy(how = How.LINK_TEXT, using = "End to End Deployment")
	    public WebElement endToEndDeployment;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='try_it_catalog']")
	    public WebElement tryIT;
     
     	
	    public WebElement searchFilter() {
			return searchFilter;
		}
	
	    public WebElement searchFilterClick() {
			return searchFilterClick;
		}
	    
	    public WebElement serviceCatalogOrderGuide() {
			return serviceCatalogOrderGuide;
		}
	    
	    public WebElement endToEndDeployment() {
			return endToEndDeployment;
		}
	   
	    public WebElement tryIT() {
			return tryIT;
		}

	   
	    
}
