import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Proj2 {

		public static void main(String[] args)
		{
			
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\snigdha\\Desktop\\Chrome Driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://www.primevideo.com/");
			
			driver.findElement(By.id("pv-nav-sign-in")).click();
			driver.findElement(By.id("createAccountSubmit")).click();
			
	WebElement customerName = driver.findElement(By.id("ap_customer_name"));
			customerName.sendKeys("Snigdha");
			
	
			
			WebElement email = driver.findElement(By.id("ap_email"));
			email.sendKeys("500077256@stu.upes.ac.in");
			
			WebElement password = driver.findElement(By.id("ap_password"));
			password.sendKeys("R171219035");
			
			
			WebElement pressContinueButton = driver.findElement(By.id("continue"));
			pressContinueButton.click();
			
		    driver.close();
		}
	}


