package Exp8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseLogin {
	public static void main(String args[]) {
	BaseTest.setUpBrowser();
	
	WebDriver driver = BaseTest.generateTest();
	driver.findElement(By.id("pv-nav-sign-in")).click();
	
	WebElement email = driver.findElement(By.id("ap_email"));
	email.sendKeys("500077256@stu.upes.ac.in");
	
	WebElement password = driver.findElement(By.id("ap_password"));
	password.sendKeys("R171219035");
	BaseTest.captureScreenshort(driver);
		
	WebElement loginButton = driver.findElement(By.id("signInSubmit"));
	loginButton.click();
	
	BaseTest.captureScreenshort(driver);
	
	BaseTest.tearDown(driver);
 }
}
