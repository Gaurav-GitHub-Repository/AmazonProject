package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Search_Dashboard;
import freemarker.log.Logger;

@Listeners(Utility.class)
@SuppressWarnings("deprecation")

public class TestCase9 {

	static Logger log = Logger.getLogger(TestCase9.class.getName());
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@Test(priority=1)
	public void InitializeBrowser(String browser)
	{
		if(browser.equals("ChromeBrowser"))
		{
		  System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\BDD_Cucumber\\AmazonProject\\drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  log.info("Chrome Browser is launched");		
		}
		else
		{
			log.info("Chrome Browser is not launched");
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
		login.password("Amazon");
		login.SignInButton(); 
		login.verifySignInPage();
	} 
	@Test(priority=3)
	public void FunctionalTest() throws InterruptedException
	{
		Search_Dashboard dashboard = new Search_Dashboard(driver);
		dashboard.selectCategory();
		dashboard.logo();
	}
	@Test(priority=4)
	public void logout()
	{
		driver.quit();
		log.error("Exception Occured: Java Socket Exception");
	}	
}
