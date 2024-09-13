package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ConfirmationPage extends BasePage{

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	 
	 @FindBy(css=".hero-primary")
	 WebElement confirmMsg;
	 
	 public String verifyConfirmMsg() {
		 String msg = confirmMsg.getText();
		 return msg;
	 }
}
