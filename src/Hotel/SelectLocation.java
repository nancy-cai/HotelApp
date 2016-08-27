package Hotel;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import functions.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectLocation extends SharedUIMapTest{

//	public SharedUIMapTest setup;

	//public WebDriver driver;
	

	
	@Before
	
	public void setUp() throws Exception{
	
		startUpUI();
	}
	
	@Test
	public void testSelectLocation() throws Exception {
		
		int count= HA_GF_XLRowCount("./Datapool/Location.xls","location");
		for(int i =1; i < count; i++){
			driver.get("http://www.adactin.com/HotelApp/");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			enterUsername("");
			enterPassword( "");
			clickLogin();
			selectCity(i);
			
		}
	
		
	}

}
