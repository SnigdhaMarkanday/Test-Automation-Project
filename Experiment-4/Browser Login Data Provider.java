import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestNG_Lab.Proj6;

public class Proj8 
{
	WebDriver driver;
	
	@BeforeTest
	public void beforeLogin()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snigdha\\Desktop\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.primevideo.com/");
	}
	
	@Test(dataProviderClass = Proj6.class, dataProvider = "loginTestData")
	public void login(String Email, String Password) 
	{
		driver.findElement(By.id("pv-nav-sign-in")).click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys(Email);
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys(Password);
			
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		loginButton.click();
	}
	
	@AfterTest
	public void afterLogin()
	{
		driver.close();
	}
}
