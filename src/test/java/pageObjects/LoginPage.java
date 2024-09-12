package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	//Contructors
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//WebElement
	
	@FindBy(id="userEmail")
	WebElement userMail;
	
	@FindBy(id="userPassword")
	WebElement userPwd;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	
	//Actions
	
	public void enterMail(String mail) {
		userMail.sendKeys(mail);
	}
	
	public void enterPassword(String pwd) {
		userPwd.sendKeys(pwd);
	}
	
	public void clickOnSubmitBtn() {
		btnLogin.click();
	}
}
