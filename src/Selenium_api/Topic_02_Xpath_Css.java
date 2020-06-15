package Selenium_api;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css {
	WebDriver driver;
	String Url = "http://live.demoguru99.com/";
	String error_invalid_Email = "Please enter a valid email address. For example johndoe@domain.com.";
	String error_empty_field = "This is a required field."; 
	String error_password_less_6_Chars= "Please enter a valid email address. For example johndoe@domain.com.";
	String error_incorrect_password = "Invalid login or password.";
	String page_title_dashboard = "My Dashboard";
	  @BeforeClass
	  public void beforeClass() {
		  
		  driver = new FirefoxDriver(); 
		  driver.manage().timeouts().implicitlyWait(10,
				  TimeUnit.SECONDS); driver.manage().window().maximize();
	  }	
	/* 
	 * TC 01 _ Login with empty Email and Password
	 * Step 01 - Truy cap vao trong http://live.demoguru99.com/
	 * Step 02 - Click vao link "My Account" de toi trang dang nhap
	 * Step 03 - De trong User Name/Password
	 * Step 04 - Click Login Button
	 * Step 05 - Verify error message xuat hien tai 2 field "This is a required field"
	 */
	
  @Test
  public void TC_01_LoginWithEmptyInfo() {
	  // Step 1 
	  driver.get("http://live.demoguru99.com/");
	  // Step 2
	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Step 03
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("");

	  driver.findElement(By.xpath("//*[@id= 'send2']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='advice-required-entry-pass']")).getText(),error_empty_field);
	  Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='advice-required-entry-email']")).getText(),error_empty_field);

  }

  /*
   * TC 02 - Login with invalid Email
   */
  @Test
  public void TC_02_LoginWithIvalidEmail() {
	  // Step 1 
	  driver.get("http://live.demoguru99.com/");
	  // Step 2
	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Step 03
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("123434@1234");
	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123456");

	  driver.findElement(By.xpath("//*[@id= 'send2']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='advice-required-entry-email']")).getText(), error_invalid_Email);

  }
  
  /*
   * TC 03 - Login with Password < 6 chars
   */
  @Test
  public void TC_03_LoginWithPassLess6Chars() {
	  // Step 1 
	  driver.get("http://live.demoguru99.com/");
	  // Step 2
	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Step 03
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("123434@1234.com");
	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("12345");

	  driver.findElement(By.xpath("//*[@id= 'send2']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='advice-required-entry-pass']")).getText(), error_password_less_6_Chars);

  }
  
  /*
   * TC 04 - Login with Incorrect Passwrod
   */
  @Test
  public void TC_04_LoginWithIncorrectPasswrod() {
	  // Step 1 
	  driver.get("http://live.demoguru99.com/");
	  // Step 2
	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Step 03
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123456666");

	  driver.findElement(By.xpath("//*[@id= 'send2']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//*[@class='error-msg']//span[text()='Invalid login or password.']")).getText(), error_incorrect_password);

  }
 
  /*
   * TC 05 - Login with Valid Email and Password
   */
  @Test
  public void TC_05_LoginWithValidInfo() {
	  // Step 1 
	  driver.get("http://live.demoguru99.com/");
	  // Step 2
	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Step 03
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("automation_13@gmail.com");
	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123123");

	  driver.findElement(By.xpath("//*[@id= 'send2']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText(), page_title_dashboard);
	  
  }
 
  @AfterClass
  public void afterClass() {
  }

}
