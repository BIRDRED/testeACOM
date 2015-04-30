package br.com.americanas.testeACOM;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyOfLoginACOM  {

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
		baseUrl = "https://carrinho.americanas.com.br/CustomerWeb/pages/Login/";
	}
	
	@Test
	public void LoginFirefox() throws InterruptedException{
    	driver.get(baseUrl);
    	Wait<WebDriver> wait = new WebDriverWait(driver, 15);
    	driver.findElement(By.cssSelector("#LoginForm .userData , .email")).sendKeys("test_fitanalytics@b2wdigital.com");
    	driver.findElement(By.cssSelector("#LoginForm .userData , .pasw")).sendKeys("testWAFA");
    	driver.findElement(By.id("btProsseguir")).click();
        driver.close();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
