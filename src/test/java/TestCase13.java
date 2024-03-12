import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Product_Dashboard;
import Pages.Search_Dashboard;
import TestCase.Utility;
import freemarker.log.Logger;

@Listeners(Utility.class)
@SuppressWarnings("deprecation")

public class TestCase13 {

static Logger log = Logger.getLogger(TestCase13.class.getName());
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@Test(priority=1)
	public void initializeBrowser(String browser)
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
			log.error("Browser is not launched");
		}
	}
	@Test(priority=2)
	public void login() throws InterruptedException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.SignIn();
		login.verifySignInPage();
		login.number("8919876100");
		login.continuebutton();
		login.password("AmazonGaurav");
		login.SignInButton(); 
	}  
	@Test(priority=3)
	public void functionaltest() throws InterruptedException
	{
		Search_Dashboard dahboard = new Search_Dashboard(driver);
		dahboard.searchProduct("Mobile");
		dahboard.selectProductPrice("1000");
		dahboard.selectProductPrice1("10000");
		dahboard.selectProductPrice2();
		Product_Dashboard product = new Product_Dashboard(driver);
		product.selectProduct2();
	}
	@Test(priority=4)
	public void logout()
	{
		driver.quit();
		log.error("Exception Occured: Java Socket Exception");
	}	 	
}
