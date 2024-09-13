package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.PlaceOrderPage;

public class TC005_ConfirmationTest extends BaseClass{
	
	@Test
	public void verifyConformationMessage() {
		TC001_LoginTest tlp = new TC001_LoginTest();
		tlp.verifyLogin();
		
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
		
		//=============================here it Palce Order Test cases statrted ==============
		
		PlaceOrderPage pOP =  new PlaceOrderPage(driver);
		
		pOP.enterCountryInDropDown();
		
	  List<WebElement> countriesList =  pOP.getCountriesListFromDropdown();
	  
	  for(WebElement cList : countriesList) {
		  String getCountry = cList.getText();
		  if(getCountry.equals("India")) {
			  cList.click();
			  break;
		  }
	  }
	  
	  pOP.clickOnPlaceOrderBtn();
		
		
		
		
		//==================Confirmation Test Starts from here
		
		
		ConfirmationPage cP = new ConfirmationPage(driver);
		
		String confirmMessage = cP.verifyConfirmMsg();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	}

}
