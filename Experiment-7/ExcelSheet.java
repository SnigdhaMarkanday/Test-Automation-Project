package TestNG_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Proj11
{
	public static void main(String[] args) throws IOException
	{
		String Username = "";
		String Password = "";
		
		try 
		{
			FileInputStream file = new FileInputStream("C:\\Users\\snigdha\\Desktop\\DataREADER.xlsx");
			
			try (XSSFWorkbook wb = new XSSFWorkbook(file)) 
			{
				XSSFSheet sheet = wb.getSheet("Login");
				
				int rowCount = sheet.getLastRowNum();
				
				for(int i = 1; i <= rowCount; i++)
				{
					XSSFRow row = sheet.getRow(i);
					
					if(row.getCell(0).getCellType() == CellType.NUMERIC)
					{
						Username = row.getCell(0).getRawValue();
					}
					else
					{
						Username = row.getCell(0).toString();
					}
					
					Password = row.getCell(1).toString();
					
					login(Username, Password);
				}
			}
			
			file.close();
		} 
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void login(String Username, String Password)
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snigdha\\Desktop\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.primevideo.com/");
		
		driver.findElement(By.id("pv-nav-sign-in")).click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys(Username);
		
		//WebElement continueButton = driver.findElement(By.id("continue"));
		//continueButton.click();
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys(Password);
			
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		loginButton.click();
		
		driver.close();

		System.out.println("\n Username Used : " + Username + "\n Password Used : " + Password);
	}
}

