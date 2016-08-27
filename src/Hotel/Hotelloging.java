package Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hotelloging {
	
	public WebDriver driver;
	public static WebElement username;
	public static WebElement password;
	public static WebElement login;
	public static String expected;
	public static String actual;

	public static void enterUsername(WebDriver driver, String usernames){
		username=driver.findElement(By.id("username"));
		username.sendKeys(usernames);
	}
	
	public static void enterPassword(WebDriver driver, String passwords){
		password = driver.findElement(By.id("password"));
		password.sendKeys(passwords);
	}
	
	public static void clickLogin(WebDriver driver){
		login = driver.findElement(By.id("login"));
		login.click();
	}
	
	public static void assertTitle(WebDriver driver){
		expected = "AdactIn.com - Search Hotel";
		actual = driver.getTitle();
		assertEquals(actual, expected);
	}
	


	public void login(WebDriver driver){
		//pass SelectHotel driver to Hotelloging driver
		this.driver = driver;
		driver.get("http://www.adactin.com/HotelApp/");
		enterUsername(driver, "doggiecai");
		enterPassword(driver, "sj191013");
		clickLogin(driver);
		assertTitle(driver);
	}

}
