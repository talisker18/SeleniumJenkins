package com.henz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*running jenkins in windows: need to config a lot -> better use VM
 * 
 * 
 * 
 * how to run: install jenkins.war from web
 * 
 * launch jenkins with bash: java -jar jenkins.war --httpPort=8083
 * open URL
 * unlock jenkins
 * 
 * ...ready
 * 
 * login = joel:admin
 * 
 * 
 * see also session 'phase-6__s4'
 * 
 * 
 * 
 * */

public class NewTest {
	
	private WebDriver driver;
	SoftAssert soft = new SoftAssert();
	
	
	//chrome
	/*@Test(groups="Chrome")
	public void launchChrome() {
		System.setProperty("webdriver.chrome.driver", "/home/hjoel87gmx/Downloads/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test(groups="Chrome", dependsOnMethods="launchChrome")
	public void openGoogleWithChrome() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.get("https://www.google.com");
		soft.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(groups="Chrome", dependsOnMethods="openGoogleWithChrome")
	public void makeQueryWithChrome() {
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		element.sendKeys("simplilearn");
		element.sendKeys(Keys.ENTER);
	}*/
	
	//firefox
	@Test(groups="Firefox")
	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver", "/home/hjoel87gmx/Downloads/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test(groups="Firefox", dependsOnMethods="launchFirefox")
	public void openGoogleWithFirefox() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver.get("https://www.google.com");
		soft.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(groups="Firefox", dependsOnMethods="openGoogleWithFirefox")
	public void makeQueryWithFirefox() {
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		element.sendKeys("simplilearn");
		element.sendKeys(Keys.ENTER);
	}
	
	@BeforeTest
	public void beforeTest() {
		//nothing to do here atm
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
