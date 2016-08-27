package Hotel;

import static org.junit.Assert.*;
import functions.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SharedUIMapTest extends HotelAppBizFunctions{
	public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	public String expected;
	public String actual;
	public Properties prop;
	public Select location;
	
	

	public void enterUsername(String username){
		this.username=driver.findElement(By.id(prop.getProperty("Txt_Login_Username")));
		this.username.sendKeys(username);
	}
	
	public void enterPassword( String password){
		this.password = driver.findElement(By.id(prop.getProperty("Txt_Login_Password")));
		this.password.sendKeys(password);
	}
	
	public void clickLogin(){
		login = driver.findElement(By.id(prop.getProperty("Btn_Login_Login")));
		login.click();
	}
	
	public void assertTitle(){
		expected = "AdactIn.com - Search Hotel";
		actual = driver.getTitle();
		assertEquals(actual, expected);
	}
	
	public void selectCity(){
		
		String strfilepath = "./Datapool/Location.xls";
	
		String strlocation = HA_GF_readXL(2,"location",strfilepath );
		location = new Select(driver.findElement(By.name("location")));
		location.selectByVisibleText(strlocation);
	    
		//String[] city = new String[4];
		
	}
	


	@Before
	public void startUpUI() throws Exception{
		driver = new FirefoxDriver();
		prop = new Properties();
	    
		//load properties file
		prop.load(new FileInputStream("./UIfolder/SharedUIMap.properties"));

	}

	@Test
	public void login() throws Exception {
		driver.get("http://www.adactin.com/HotelApp/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		enterUsername("doggiecai");
		enterPassword("sj191013");
		clickLogin();
		assertTitle();
	

	}
	
	/*@After
	public void closeDriver(){
		driver.close();
	}
	*/

}