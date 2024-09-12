package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass{
	
	@Test
	public void verifyLogin() {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterMail("shashank.k@zycus.com");
		lp.enterPassword("Pass@123");
		lp.clickOnSubmitBtn();
	}

}
