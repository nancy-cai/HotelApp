package Hotel;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectHotel {
	public WebDriver driver;
	public Select location;
	WebElement currentHotelRow;
	
	public void selectLocation(WebDriver driver){
		location = new Select(driver.findElement(By.name("location")));
		location.selectByValue("Sydney");
		driver.findElement(By.cssSelector("#Submit")).click();
	}
	
	/*public void selectHotelByName(String hotelName){
		String hotelXpath = String.format("//*[contains(text(), '%s')]", hotelName);
		
		//find all hotels with name: Hotel Creek
		List<WebElement> matchingHotels = driver.findElements(By.xpath(hotelXpath));
		
		for ( WebElement hotel: matchingHotels) { 
	        //get the parent row
			WebElement parentRow = hotel.findElement(By.xpath("../.."));
			
			//get the radio button and select
			parentRow.findElement(By.xpath("/td/input")).click();
	    }
	}
	*/
	
	public void findHotelByName(String hotelName){

		

		for(int i=2; i<6; i++){
			
			//String hotelXpath = String.format("//*[@id='select_form']/table/tbody/tr[2]/td/table/tbody/tr[%s]", i);
			String hotelXpath = "//*[@id='select_form']/table/tbody/tr[2]/td/table/tbody/tr[" + i + "]";
			//String parentRow = hotelXpath +"/../..";
			String name = driver.findElement(By.xpath(hotelXpath +"/td[2]/input")).getAttribute("value");
				
		
			if(name.equalsIgnoreCase(hotelName)) {
				System.out.println("haha");
				driver.findElement(By.xpath(hotelXpath+"/td[1]/input")).click();
				break;
			}
        }	
		
	}
	
	@Before
	public void startUp(){
		driver = new FirefoxDriver();
		driver.get("http://www.adactin.com/HotelApp/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception{
		Hotelloging obj = new Hotelloging();
		obj.login(driver);
		selectLocation(driver);
		
		//selectHotelByName("Hotel Creek");
		findHotelByName("Hotel Cornice");
	}
	
	/*@After
	public void closeDriver(){
		driver.close();
	}*/

}
