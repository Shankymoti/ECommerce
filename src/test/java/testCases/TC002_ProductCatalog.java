package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.ProductCatalogPage;

public class TC002_ProductCatalog extends BaseClass {
	
	String productName = "ZARA COAT 3";
	@Test(priority=1)
	public void selectProductCatalog() {
		TC001_LoginTest lt = new TC001_LoginTest();
		lt.verifyLogin();
		
		ProductCatalogPage prodCatalogPage = new ProductCatalogPage(driver);
		
		List<WebElement> productList = prodCatalogPage.getProductList();
		prodCatalogPage.addCatalogToCart(productName);
		prodCatalogPage.navigateToCart();
	}
	

}
