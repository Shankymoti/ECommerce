package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.CartPage;

public class TC003_CartTest extends BaseClass{

	@Test
	public void verifyCartSection() throws InterruptedException {
		
		TC001_LoginTest tlp = new TC001_LoginTest();
		tlp.verifyLogin();
		
		Thread.sleep(5000);
		TC002_ProductCatalog pC = new TC002_ProductCatalog();
		pC.selectProductCatalog();
		
		CartPage cp =new CartPage(driver);
		
		List<WebElement> cartCatalogList =cp.getCatalogListInCart();
		
		for(WebElement cataListItem : cartCatalogList) {
			String prodName = cataListItem.getText();
			if(prodName.equals(pC.productName)) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
 		}
		
		cp.clickOnCheckoutBtn();
	}
}
