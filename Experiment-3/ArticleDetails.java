package TestNG_Lab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Proj7 
{
	WebDriver driver;
	boolean n;
	
	@BeforeTest
	public void beforeSearchArticle() 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snigdha\\Desktop\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.primevideo.com/");
	}
	
	
	  @Test(priority=0)
	  public void login() {
	  driver.findElement(By.id("pv-nav-sign-in")).click();
	  
	  WebElement email = driver.findElement(By.id("ap_email"));
	  email.sendKeys("aditya_dentist@yahoo.co.in");
	  
	  WebElement password = driver.findElement(By.id("ap_password"));
	  password.sendKeys("snigdhA@1");
	  
	  WebElement loginButton = driver.findElement(By.id("signInSubmit"));
	  loginButton.click(); }
	 
	@Test(priority=1)
	public void searchArticle() 
	{
	
		WebElement searchBar = driver.findElement(By.cssSelector("#pv-search-nav"));
		searchBar.sendKeys("hero");
		
		driver.findElement(By.id("pv-search-nav")).sendKeys(Keys.ENTER);
		n=driver.findElement(By.cssSelector("#av-search > div > div.X8aBJ_.av-search-grid.av-s-g-clear > div:nth-child(1) > div > div._38SAO3.tst-hover-container._1pYuE7._1aBOAx > div._1y15Fl.dvui-beardContainer.D0Lu_p.av-grid-beard > div:nth-child(1) > div._1Opa2_.dvui-packshot.av-grid-packshot > a > img")).isDisplayed();
	}
	
	@AfterTest
	public void afterSearchArticle() 
	{
		driver.close();
	}
}
