package Hotel;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HotelLogin {
	public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	public String expected;
	public String actual;

	public void enterUsername(WebDriver driver, String username){
		this.username=driver.findElement(By.id("username"));
		this.username.clear();
		this.username.sendKeys(username);
	}
	
	public void enterPassword(WebDriver driver, String password){
		this.password = driver.findElement(By.id("password"));
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickLogin(WebDriver driver){
		login = driver.findElement(By.id("login"));
		login.click();
	}
	
	public void assertTitle(WebDriver driver){
		expected = "AdactIn.com - Search Hotel";
		actual = driver.getTitle();
		assertEquals(actual, expected);
	}
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://www.adactin.com/HotelApp/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws Exception {
		enterUsername(driver, "");
		enterPassword(driver, "");
		clickLogin(driver);
		assertTitle(driver);

	}
	
	@After
	public void closeDriver(){
		driver.close();
	}
	

}
