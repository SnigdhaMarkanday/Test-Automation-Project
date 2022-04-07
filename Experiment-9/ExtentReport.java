package TestNG_Lab;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport
{
	static ExtentTest test;
	static ExtentReports report;

	String baseurl = "https://www.primevideo.com/";
	String driverpath = "C:\\Users\\snigdha\\Desktop\\Chrome Driver\\chromedriver.exe";
	WebDriver chromeDriver;

	@BeforeClass
	public static void initializeReport()
	{
		report = new ExtentReports("C:\\Users\\snigdha\\Desktop\\ExtenTReport\\ExtentReportResults.html");
		test = report.startTest("DemoReport");
	}

	@BeforeTest
	public void launchingBrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverpath);
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.get(baseurl);
	}

	@Test(priority=0)
	public void verifyingTitle()
	{
		// Inspecting the page - Check the title name under HTML tag
		String expected = "Welcome to Prime Video";
		String actual = chromeDriver.getTitle();
		
		if(actual.equalsIgnoreCase(expected))
		{
			test.log(LogStatus.PASS, "Title page verified");
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Title page test failed");
		}
	}
	
	@Test(priority=1)
	public void goToPrimeVideo()
	{
		chromeDriver.findElement(By.cssSelector("#pv-nav-logo > div")).click();
	}
	
	@Test(priority=2)
	public void clickOnSignIn()
	{
		chromeDriver.findElement(By.id("pv-nav-sign-in")).click();
		
		//Checking if Navigated to login page
		if(chromeDriver.findElement(By.id("ap_email")) != null)
		{
			test.log(LogStatus.PASS, "Sign On verified");
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Sign on not verified");
		}
	}

	@Test(priority=3)
	public void enterEmail()
	{
		WebElement email = chromeDriver.findElement(By.id("ap_email"));
		email.sendKeys("500077256@stu.upes.ac.in");
		
		// continue button would be displayed
		if(chromeDriver.findElement(By.id("ap_password")) != null)
		{
			test.log(LogStatus.PASS, "Login name entered correctly");
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Login name is not entered correctly");
		}
	}

	@Test(priority=4)
	public void enterPassword()
	{
		WebElement continueButton = chromeDriver.findElement(By.id("ap_password"));
		continueButton.sendKeys("R171219035");
		
		// the password field is shown now
		if(chromeDriver.findElement(By.id("signInSubmit")) != null)
		{
			test.log(LogStatus.PASS, "Continue button has been pressed successfully");
		}
		
		else
		{
			test.log(LogStatus.FAIL, "Continue button is not pressed correctly");
		}
	}

	@AfterTest
	public void destroyingSession()
	{
		chromeDriver.close();
		test.log(LogStatus.PASS, "Browser Closed Successfully");
	}
	
	@AfterClass
	public void publishingReport() 
	{
		report.endTest(test);
		report.flush();
	}
}

