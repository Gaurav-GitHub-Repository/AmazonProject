package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import freemarker.log.Logger;

public class Logout {

	static Logger log = Logger.getLogger(Logout.class.getName());
	
	WebDriver driver; 
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
	}	
	
	private By SignIn = By.xpath("//div[@id='navbar']/div/div[3]/div/a[2]");
	
	private By logout = By.xpath("//div[@id='nav-al-container']/div[3]/a[15]");
	
	public void logout()
	{
		 try {
			 	driver.findElement(SignIn).click();
			 	Actions action = new Actions(driver);
			 	WebElement login = driver.findElement(By.xpath("//div[@id='navbar']/div/div[3]/div/a[2]"));
			 	action.moveToElement(login).build().perform();
			 	action.clickAndHold(login).build().perform();
			 	driver.findElement(logout).click();
		     }
		 catch(NoSuchElementException e)
		 {
			 e.printStackTrace();
			 log.info("Exception Occured: NoSuchElementException");
		 }
	}
	
}
