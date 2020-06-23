package Selenium_api;

import org.testng.annotations.Test;

import com.sun.webkit.BackForwardList;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class WebBrowser {
	WebDriver driver ;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver(); 
		driver.manage().timeouts().implicitlyWait(10,
				  TimeUnit.SECONDS); driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
	}
	
/*
 * TC_01_Verify Url	
 */
  @Test
  public void TC_01_VerifyUrl() {
	  // Step 1: Access page: http://live.demoguru99.com
	  driver.get("http://live.demoguru99.com");
	  // Step 2: Click My Account link in footer
	  driver.findElement(By.xpath("//*[@id='header']/descendant::*[text()='Account']")).click();
	  driver.findElement(By.xpath(".//*[@id='header-account']/descendant::li[position()=1]")).click();
	  // Verify Url login page
	  Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
	  // Click CREATE AN ACCOUNT button
	  driver.findElement(By.xpath(".//*[@id='login-form']/descendant::a[@title='Create an Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	// Verify Url create account 
	  Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	  
  }
 /*
  * TC_02 : Verify Title (GetTitle)
  */
  @Test
  public void TC_02_VerifyTitle() {
	  // Step 1: Access page: http://live.demoguru99.com
	  driver.get("http://live.demoguru99.com");
	  // Step 2: Click My Account link in footer
	  driver.findElement(By.xpath("//*[@id='header']/descendant::*[text()='Account']")).click();
	  driver.findElement(By.xpath(".//*[@id='header-account']/descendant::li[position()=1]")).click();
	  // Verify Url login page
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Click CREATE AN ACCOUNT button
	  driver.findElement(By.xpath(".//*[@id='login-form']/descendant::a[@title='Create an Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	// Verify Url create account 
	  
  }
  /*
   * TC 03 : Navigate function (back/forward) 
   */
  @Test
  public void TC_03_Navigate() {
	// Step 1: Access page: http://live.demoguru99.com
		  driver.get("http://live.demoguru99.com");
		  // Step 2: Click My Account link in footer
		  driver.findElement(By.xpath("//*[@id='header']/descendant::*[text()='Account']")).click();
		  driver.findElement(By.xpath(".//*[@id='header-account']/descendant::li[position()=1]")).click();
		  // Verify Url login page
		  Assert.assertEquals(driver.getTitle(), "Customer Login");
		  driver.navigate().back();
		  driver.navigate().forward();
  }
  
  /*
   * TC 04 : Get Page Source Code (getPageSource)
   */
  @Test
  public void TC_04_getPageSource() {
	  // Step 1: Access page: http://live.demoguru99.com
	  driver.get("http://live.demoguru99.com");
	  // Step 2: Click My Account link in footer
	  driver.findElement(By.xpath("//*[@id='header']/descendant::*[text()='Account']")).click();
	  driver.findElement(By.xpath(".//*[@id='header-account']/descendant::li[position()=1]")).click();
	  // Verify Url login page
	  Assert.assertEquals(driver.getTitle(), "Customer Login");
	  // Click CREATE AN ACCOUNT button
	  driver.findElement(By.xpath(".//*[@id='login-form']/descendant::a[@title='Create an Account']")).click();
	  Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	// Verify Url create account 
	 if(driver.getPageSource().contains("Create an Account")) {
		 System.out.println("Text is present");
	 }
	 else System.out.println("Text is absent");
}
  
    
}
