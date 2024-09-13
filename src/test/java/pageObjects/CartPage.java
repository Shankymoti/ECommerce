package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	//constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElements
	@FindBy(css=".cartSection h3")
	List<WebElement>  cartProducts;
	
	@FindBy(xpath="//div[@class='subtotal cf ng-star-inserted']//button")
	WebElement checkoutBtn;
	
	
	
	By productsCarts = By.cssSelector(".cartSection h3");
	//Actions
	
	public List<WebElement> getCatalogListInCart()
	{
		waitForElementToAppear(productsCarts);
		return cartProducts;
		
	}
	
	public void clickOnCheckoutBtn() {
		checkoutBtn.click();
	}
	
}
