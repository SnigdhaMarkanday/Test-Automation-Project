package TestNG_Lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Proj12 {
   public static void main(String[] args)
	{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\snigdha\\Desktop\\Firefox Driver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		
		driver.get("https://www.primevideo.com/");
		
		driver.findElement(By.id("pv-nav-sign-in")).click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("500077256@stu.upes.ac.in");
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("R171219035");
			
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		loginButton.click();
		
		 driver.close();
	}
