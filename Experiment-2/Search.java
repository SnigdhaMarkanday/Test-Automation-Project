package TestNG_Lab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Proj3
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
	
	@Test
	public void login() 
	{
		driver.findElement(By.id("pv-nav-sign-in")).click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("500077256@stu.upes.ac.in");
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("R171219035");
			
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		loginButton.click();
  	}
	
	@AfterTest
	public void afterLogin()
	{
		driver.close();
	}
}
