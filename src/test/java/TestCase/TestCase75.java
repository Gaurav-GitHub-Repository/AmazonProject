package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Product_Dashboard;
import Pages.Search_Dashboard;
import freemarker.log.Logger;

@Listeners(Utility.class)
@SuppressWarnings("deprecation")

public class TestCase75 {

static Logger log = Logger.getLogger(TestCase75.class.getName());
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@Test(priority=1)
	public void initializeBrowser(String browser)
	{
		if(browser.equals("EdgeBrowser"))
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
			log.error("Browser is not launched");
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
	public void functionaltest() throws InterruptedException
	{
		//Method to call Search_Dashboard
		Search_Dashboard dahboard = new Search_Dashboard(driver);
		dahboard.searchProduct("Mobile");
		dahboard.selectProduct1();
		//Method to call Product_Dashboard
		Product_Dashboard Product = new Product_Dashboard(driver);
		Product.switchToProduct(); 
		dahboard.scroll();
		Product.AddToCart();	
	}
	@Test(priority=4)
	public void logout()
	{
		driver.quit();
		log.error("Exception Occured: Java Socket Exception");
	}	
	
}
