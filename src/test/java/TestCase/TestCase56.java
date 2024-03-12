package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import freemarker.log.Logger;

@Listeners(Utility.class)
@SuppressWarnings("deprecation")

public class TestCase56 {

	static Logger log = Logger.getLogger(TestCase56.class.getName());
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@Test(priority=1)
	public void initializeBrowser(String browser)
	{
		if(browser.equals("EdgseBrowser"))
		{
		 System.setProperty("WebDriver.edge.Driver", "C:\\Selenium Temp\\BDD_Cucumber\\AmazonProject\\drivers\\msedgedriver.exe");
		 driver=new EdgeDriver();
		 driver.get("https://www.amazon.in/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 log.info("Microsoft Edge Browser is launched");		
		}
		else
		{
			log.info("Browser is not launched");
		}
	}
	@Test(priority=2)
	public void login() throws InterruptedException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.SignIn();
		login.number("1000000000"); 
		login.continuebutton();
		login.OTPButton("100100");
		login.verifySignInPage();
	}
	public void logout()
	{
		driver.quit();
		log.error("Exception Occured: Java Socket Exception");
	}
}