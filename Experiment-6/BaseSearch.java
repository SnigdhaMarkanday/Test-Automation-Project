package Exp8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseSearch {

	public static void main(String[] args) {
		BaseTest.setUpBrowser();

		WebDriver driver = BaseTest.generateTest();
		
		driver.findElement(By.id("pv-nav-sign-in")).click();
		
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("aditya_dentist@yahoo.co.in");
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("snigdhA@1");
		BaseTest.captureScreenshort(driver);
			
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
		loginButton.click();
		BaseTest.captureScreenshort(driver);
		
		WebElement searchBar = driver.findElement(By.cssSelector("#pv-search-nav"));
		searchBar.sendKeys("hero");
		BaseTest.captureScreenshort(driver);
		
		driver.findElement(By.id("pv-search-nav")).sendKeys(Keys.ENTER);
		BaseTest.captureScreenshort(driver);
		boolean n;
		n=driver.findElement(By.cssSelector("#av-search > div > div.X8aBJ_.av-search-grid.av-s-g-clear > div:nth-child(1) > div > div._38SAO3.tst-hover-container._1pYuE7._1aBOAx > div._1y15Fl.dvui-beardContainer.D0Lu_p.av-grid-beard > div:nth-child(1) > div._1Opa2_.dvui-packshot.av-grid-packshot > a > img")).isDisplayed();
		System.out.println(n);
		BaseTest.captureScreenshort(driver);
		
		BaseTest.tearDown(driver);

	}

}
