package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCatalogPage extends BasePage {
	
	
	//Constructor
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
	}

	//WebElement
	
	
	@FindBy(xpath="//section[@id='products']//div[@class='card-body']//b")
	List<WebElement> products;
	
	@FindBy(xpath="//section[@id='products']//div[@class='card-body']//button[2]")
	WebElement selectProduct;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement dashboardCart;
	
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	
//	By productsBy = By.cssSelector(".mb-3");
	By productsBy = By.xpath("//section[@id='products']//div[@class='card-body']//b");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList(){
		waitForElementToAppear(productsBy);
		return products;
	}
	
	
	public void addCatalogToCart(String productName) {
		for(WebElement product : products) {
			String prod = product.getText();
			System.out.println(prod);
			System.out.println(productName);
			if(prod.equals(productName)) {
				selectProduct.click();
				waitForElementToDisappear(spinner);
				waitForElementToAppear(toastMessage);
				
				break;
			}
		}
		
		
		
	}
	
	public void navigateToCart() {
		dashboardCart.click();
	}
	
	
	
}
