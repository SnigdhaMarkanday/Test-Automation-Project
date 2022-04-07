package Exp8;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseReg {

	public static void main(String[] args) {
		BaseTest.setUpBrowser();
		
		WebDriver driver = BaseTest.generateTest();
		driver.findElement(By.id("pv-nav-sign-in")).click();
		BaseTest.captureScreenshort(driver);
		driver.findElement(By.id("createAccountSubmit")).click();
		BaseTest.captureScreenshort(driver);
		
		WebElement customerName = driver.findElement(By.id("ap_customer_name"));
		customerName.sendKeys("Snigdha");
		
		try
		{
			WebElement phoneNumber = driver.findElement(By.id("ap_phone_number"));
			phoneNumber.sendKeys("7017287259");
		}
		
		catch(NoSuchElementException E)
		{
			System.out.println(E);
		}
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("500077256@stu.upes.ac.in");
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("R171219035");
		
		try
		{
			WebElement passwordCheck = driver.findElement(By.id("ap_password_check"));
			passwordCheck.sendKeys("R171219035");
		}
		
		catch(NoSuchElementException E)
		{
			System.out.println(E);
		}
		
		WebElement pressContinueButton = driver.findElement(By.id("continue"));
		pressContinueButton.click();
		
		BaseTest.captureScreenshort(driver);
		
		BaseTest.tearDown(driver);

	}

}
