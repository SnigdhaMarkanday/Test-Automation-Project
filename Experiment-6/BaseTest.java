package Exp8;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest
{
	static WebDriver driver;
	static String driverPath;
	static String baseURL;
	
	@BeforeTest
	public static void setUpBrowser()
	{
		  driverPath = "C:\\Users\\snigdha\\Desktop\\Chrome Driver\\chromedriver.exe";
		  baseURL = "https://www.primevideo.com/";
	}
	
	@Test
	public static WebDriver generateTest()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		captureScreenshort(driver);
		
		return driver;
	}
	
	public static void captureScreenshort(WebDriver ldriver)
	{
		String folderPath = "C:\\Users\\snigdha\\Desktop\\TA SS\\";
		
		File src = ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(src, new File(folderPath + System.currentTimeMillis() + ".png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	public static void explicittWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@AfterTest
	public static void tearDown(WebDriver driver)
	{
		driver.close();
	}
}

