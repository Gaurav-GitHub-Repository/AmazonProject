package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import freemarker.log.Logger;

public class Login {

	static Logger log = Logger.getLogger(Login.class.getName());
	
	WebDriver driver; 
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for SignIn
	private By SignIn = By.xpath("//div[@id='navbar']/div/div[3]/div/a[2]");
	//Locator for Email
	private By MobileNumber = By.xpath("//input[@id='ap_email' and @name='email']");
	//Locator for Password
	private By Password = By.xpath("//input[@id='ap_password' and @name='password']");
	//Locator for continue button
	private By ContinueButton = By.xpath("//input[@id='continue' and @class='a-button-input']");
	//Locator for SignIn Button
	private By SignInButton = By.xpath("//input[@id='signInSubmit' and @class='a-button-input']");
	//Locator for OTP
	private By OTP = By.xpath("//input[@id='continue' and @class='a-button-input']");
	//Locator for OTP number
	private By OTPNumber = By.xpath("//*[@id='cvf-input-code' and @class='a-input-text a-span12 cvf-widget-input cvf-widget-input-code']");
	//Locator for OTP Continue Button
	private By OTPButton = By.xpath("//*[@id='cvf-submit-otp-button']/span/input");
	
	//Method to click on sign in
	public void SignIn() throws InterruptedException
	{
	 try {
		 	driver.findElement(SignIn).click();
		 	Actions action = new Actions(driver);
		 	WebElement SignIn = driver.findElement(By.xpath("//div[@id='navbar']/div/div[3]/div/a[2]"));
		 	action.moveToElement(SignIn).build().perform();
		 	driver.findElement(By.xpath("//*[@id='nav-signin-tooltip']/a/span")).click();
	     }
	 catch(NoSuchElementException e)
	 {
		 log.info("Exception Occured: NoSuchElementException");
	 }
	}
	//Method to verify sign in page
	public void verifySignInPage()
	{
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	//Method to enter login details
	public void number(String value) throws InterruptedException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileNumber));
			driver.findElement(MobileNumber).sendKeys(value);
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			log.info("Exception Occured: NoSuchElementException");
		}
	}
	//Method to enter password
	public void password(String value) throws InterruptedException
	{
		driver.findElement(Password).sendKeys(value);
		log.info("Password is entered");
		Thread.sleep(2000);		
	}
	//Method to click on login button
	public void continuebutton() throws InterruptedException
	{
		driver.findElement(ContinueButton).click();
		log.info("Successfully clicked on continue button");
		Thread.sleep(2000);
	}
	//Method to click on signin button
	public void SignInButton() throws InterruptedException
	{
		driver.findElement(SignInButton).click();
		log.info("Successfully clicked on sign in button");
		Thread.sleep(2000);
	}
	//Method to click on OTP button
	public void OTPButton(String value) throws InterruptedException
	{
		driver.findElement(OTP).click();
		Thread.sleep(6000);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(), "Authentication required");
	}
}