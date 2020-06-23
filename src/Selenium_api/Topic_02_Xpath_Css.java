package Selenium_api;

import org.testng.annotations.Test;

import com.sun.istack.internal.logging.Logger;

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
	String error_password_less_6_Chars= "Please enter 6 or more characters without leading or trailing spaces.";
	String error_incorrect_password = "Invalid login or password.";
	String page_title_dashboard = "MY DASHBOARD";
	String page_hello_user = "Hello, Automation Testing!";
	String page_User_name = "Automation Testing";
	String page_email_use ="automation_13@gmail.com";
	 
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
	  String message = driver.findElement(By.xpath("//*[@id='advice-validate-email-email']")).getText();
	  
	  Assert.assertEquals(message, error_invalid_Email);
	  
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
	  String message = driver.findElement(By.xpath(".//*[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(message, error_password_less_6_Chars);

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
//  @Test
//  public void TC_05_LoginWithValidInfo() {
//	  // Step 1 
//	  driver.get("http://live.demoguru99.com/");
//	  // Step 2
//	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
//	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
//	  Assert.assertEquals(driver.getTitle(), "Customer Login");
//	  // Step 03
//	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("automation_13@gmail.com");
//	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123123");
//	  // Step 04: Click login button
//	  driver.findElement(By.xpath("//*[@id= 'send2']")).click();
//	  //Step 4: Verify some info
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText(), page_title_dashboard);
//	  Assert.assertEquals(driver.findElement(By.xpath("//*[@class ='dashboard']/descendant::strong")).getText(), page_hello_user);
//	 // Assert.assertEquals(driver.findElement(By.xpath("//*[@class='dashboard']/descendant::p[contains(text(), 'Automation Testing')]")).getText().substring(18), page_User_name);
//	 // Step 6: Click Account -> logout by last() xpath
//	  driver.findElement(By.xpath("//div[@class ='account-cart-wrapper']/descendant::*[text()='Account']")).click();
//	  //driver.findElement(By.xpath(".//*[@id='header-account']/descendant::*/a[@title='Log Out']")).click();
//	  driver.findElement(By.xpath(".//*[@id='header-account']/descendant::*[last()]")).click();
//  }
// 
  
  /*
  * TC_06 Create new account
  */
  @Test
  public void TC_06_CreateNewAccount() {
	  String first_name 	= "Thuy";
	  String middle_name 	= "Thu";
	  String last_name 		= "Pham";
	  String Email_address 	= RandomeEmail();
	  String password		= "defaultPass";
	  // Step 1 
	  driver.get("http://live.demoguru99.com/");
	  // Step 2: Go to My Account page(Login page)
	  //driver.findElement(By.xpath(".//a[@class= 'skip-link skip-account']")).click();\
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  //Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Step 3: Click Create New Account
	  driver.findElement(By.xpath(".//*[@id='login-form']/descendant::a[@title='Create an Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	  // Step 4: fillout info
	  driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(first_name);
	  driver.findElement(By.xpath("//*[@id='middlename']")).sendKeys(middle_name);
	  driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(last_name);
	  driver.findElement(By.xpath("//*[@id='email_address']")).sendKeys(Email_address);
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@id='confirmation']")).sendKeys(password);
	  // Step 5: click Register
	  driver.findElement(By.xpath(".//*[@title='Register' and @type='submit']")).click();
	  //Step 6: Verify success message
	  Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='success-msg']/descendant::span")).getText(), "Thank you for registering with Main Website Store.");
  }
  
  public String RandomeEmail() {
	String email = "emailtest"+ Math.random() + "@gmail.com";
	return email;
	  
  }
  @AfterClass
  public void afterClass() {
  }

}
