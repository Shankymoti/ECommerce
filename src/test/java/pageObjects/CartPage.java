package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	//constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement>  cartProducts;
}
