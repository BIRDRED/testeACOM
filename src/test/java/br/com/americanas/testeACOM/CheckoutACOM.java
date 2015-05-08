package br.com.americanas.testeACOM;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutACOM  {

	public WebDriver driver;
	private String baseUrl;
	Date data = new Date(System.currentTimeMillis()); 
	
	@Before
	public void runBeforeEveryTest() {
		FirefoxProfile fp = new FirefoxProfile();
		FirefoxBinary ffox = new FirefoxBinary();
		ffox.setEnvironmentProperty("DISPLAY", ":0");
		driver = new FirefoxDriver(ffox, fp);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		baseUrl = "http://www.americanas.com.br/produto/120736101/game-need-for-speed-rivals-ps4";
	}
	
	@Test
	public void LoginFirefox() throws InterruptedException{
    	driver.get(baseUrl);
    	Wait<WebDriver> wait = new WebDriverWait(driver, 15);
    	driver.manage().deleteAllCookies();
        Thread.sleep(7000);
        Cookie gtmsac = new Cookie("gtm_sac", "ucla");
    	driver.manage().addCookie(gtmsac);
    	driver.findElement(By.cssSelector(".spt-b-main-buy")).click();
        Thread.sleep(5000);
    	driver.findElement(By.cssSelector(".list-actions #upper-buy-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("account-email")).sendKeys("test_fitanalytics@b2wdigital.com");
    	driver.findElement(By.id("account-password")).sendKeys("testWAFA");
    	driver.findElement(By.id("button-login-customer")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.cssSelector(".boleto")).click();
    	Thread.sleep(5000);
    	driver.findElement(By.cssSelector(".buttons .withStep .next")).click();
    	Thread.sleep(5000);
        driver.close();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
