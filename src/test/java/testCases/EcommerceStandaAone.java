package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Shashank Logic



public class EcommerceStandaAone {
 // https://github.com/RichaKambo/CICDAutomation
	public static void main(String[] args) throws InterruptedException{
		String prod = "ZARA COAT 3";
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://rahulshettyacademy.com/client/");
	  driver.findElement(By.id("userEmail")).sendKeys("shashank.k@zycus.com");
	  driver.findElement(By.id("userPassword")).sendKeys("Pass@123");
	  driver.findElement(By.id("login")).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//	  Thread.sleep(5000);
	  List<WebElement> products = driver.findElements(By.xpath("//section[@id='products']//div[@class='card-body']//b"));
	  for(WebElement product : products) {
		  String p= product.getText();
		  System.out.println("p");
		  if(p.equals(prod)) {
			  driver.findElement(By.xpath("//section[@id='products']//div[@class='card-body']//button[2]")).click();
			  break;
		  }
	  }
	 // Thread.sleep(5000);
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-animating")));
	  driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	
	  List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	  
	  for(WebElement cartProduct : cartProducts) {
		  String cp = cartProduct.getText();
		  if(cp.equals(prod)) {
			  Assert.assertTrue(true);
		  }else {
			  Assert.assertTrue(false);
		  }
	  }
	  driver.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']//button")).click();
	  // first way to select country from dropdown
	 WebElement countryDropdown = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
	  countryDropdown.sendKeys("ind");
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span")));
	  List<WebElement> countriesList = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span"));
	  for(WebElement cl : countriesList) {
		  String country = cl.getText();
		  System.out.println(country);
		  //Thread.sleep(3000);
		  if(country.equals("India")) {
			  cl.click();
			  break;
		  }
		// Thread.sleep(3000);
		//  Assert.assertEquals(countryDropdown.getText(), "India");

	  }  
	/*  // Second way to select Country from DropDown
	  
	  Actions a = new Actions(driver);
	  a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country")),"india").build().perform();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	 */
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		 Thread.sleep(3000);
		 
		 String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		 System.out.println(confirmMessage);
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}
	
	
}
