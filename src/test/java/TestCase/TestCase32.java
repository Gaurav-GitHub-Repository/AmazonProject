package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AddAddress;
import Pages.Login;
import freemarker.log.Logger;

@Listeners(Utility.class)
@SuppressWarnings("deprecation")

public class TestCase32 {

	static Logger log = Logger.getLogger(TestCase32.class.getName());
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@Test(priority=1)
	public void initializeBrowser(String browser)
	{
		if(browser.equals("FirefoxBrowser"))
		{
			System.setProperty("WebDriver.gecko.Driver", "C:\\Selenium Temp\\BDD_Cucumber\\AmazonProject\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.info("Firefox Browser is launched");		
		}
		else
		{
			log.info("Firefox Browser is not launched");
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
		AddAddress address = new AddAddress(driver);
		address.addAddress();
		address.addresslink();
		address.addressButton();
		address.verifyAddressPage();
		address.selectCountry();
		address.enterFullName("P.Gaurav");
		address.enterMobileNumber("8919876100");
		address.enterPincode("500100");
		address.address("B-509, Sri Gajanana Homes, Kompally, Hyderabad");
		address.city("Hyderabad");
		address.enterLandmark("Opposite to shantiniketan");
		address.selectState();
		address.saveAdddress();
	}
	@Test(priority=4)
	public void logout()
	{
		driver.quit();
		log.error("Exception Occured: Java Socket Exception");
	} 
}
