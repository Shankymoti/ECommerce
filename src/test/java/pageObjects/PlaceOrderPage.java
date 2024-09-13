package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PlaceOrderPage extends BasePage{
	
	//Constructor
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
	}

	
	//WebElement
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryDropDown;
	
	

	By dropDownElements = By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span");
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']//span")
	List<WebElement> countriesList;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeOrderButton;
	
	//Actions
	public void enterCountryInDropDown() {
		countryDropDown.sendKeys("ind");
		
	}
	
	public List<WebElement> getCountriesListFromDropdown(){
		waitForElementToAppear(dropDownElements);
		return countriesList;
		
	}
	
	public void clickOnPlaceOrderBtn() {
		placeOrderButton.click();
	}
	
	
	
	
	
}
