package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import freemarker.log.Logger;

public class AddAddress {

	static Logger log = Logger.getLogger(AddAddress.class.getName());
	
	WebDriver driver;
	
	public AddAddress(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator to click on add address
	private By AddAddress = By.xpath("//div[@id='nav-belt']/div[1]/div[2]/span/a/div[2]/span");
	//Locator for Add Address Link
	private By AddAddressLink = By.xpath("//div[@class='a-popover-inner']/div/div[2]/div/div[2]/div/span[2]/a");
	//Locator for Address Button
	private By AddressButton = By.xpath("//div[@class='a-section']/div[1]/div[2]/div/div/a/div/div/h2");
	//Locator for full name
	private By Fullname = By.xpath("//input[@id='address-ui-widgets-enterAddressFullName' and @name='address-ui-widgets-enterAddressFullName']");
	//Locator for mobile number
	private By MobileNumber = By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber' and @name='address-ui-widgets-enterAddressPhoneNumber']");
	//Locator for pincode
	private By Pincode = By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode' and @name='address-ui-widgets-enterAddressPostalCode']");
	//Locator for apartment
	private By Apartment = By.xpath("//input[@id='address-ui-widgets-enterAddressLine1' and @name='address-ui-widgets-enterAddressLine1']");
	//Locator for Town/City
	private By City = By.xpath("//input[@id='address-ui-widgets-enterAddressLine1' and @name='address-ui-widgets-enterAddressLine1']");
	//Locator for landmark
	private By landmark = By.xpath("//input[@id='address-ui-widgets-landmark' and @name='address-ui-widgets-landmark']");
	//Locator for add address button
	private By AddAddressButton = By.xpath("//*[@id='address-ui-widgets-location-detection-error-ok-button']/span/input");
	
	//Method to click on Add Address
	public void addAddress() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(AddAddress).click();
	}
	//Method to click on add address link
	public void addresslink() throws InterruptedException
	{
		try {
		 driver.findElement(AddAddressLink).click();
		}
		catch(NoSuchElementException e)
		{
			log.error("Exception Occured: NoSuchElementException");
		}
	}
	//Method to click on address button
	public void addressButton() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(AddressButton).click();
	}
	//Method to verify address page
	public void verifyAddressPage()
	{
		Assert.assertEquals(driver.getTitle(), "Your Addresses");;
	}
	//Method to select country
	public void selectCountry()
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@name='address-ui-widgets-countryCode']")));
		select.selectByVisibleText("India");
		List<WebElement> var = select.getOptions();
		for(WebElement country: var)
		{
			if(country.equals("India"))
			{
				log.info("Country is selected");
				break;
			}
		}
	}
	//Method to enter full name
	public void enterFullName(String value) throws InterruptedException
	{
		driver.findElement(Fullname).sendKeys(value);
		log.info("Full name is entered");
		Thread.sleep(2000);
	}
	//Method to enter mobile number
	public void enterMobileNumber(String value) throws InterruptedException
	{
		driver.findElement(MobileNumber).sendKeys(value);
		log.info("Mobile Number is entered");
		Thread.sleep(2000);
	}
	//Method to enter pincode
	public void enterPincode(String value) throws InterruptedException
	{
		driver.findElement(Pincode).sendKeys(value);
		log.info("Pincode is entered");
		Thread.sleep(2000);
	}
	//Method to enter address
	public void address(String value) throws InterruptedException
	{
		driver.findElement(Apartment).sendKeys(value);
		log.info("Address is entered");
		Thread.sleep(2000);
	}
	//Method to enter city
	public void city(String value) throws InterruptedException
	{
		driver.findElement(City).sendKeys(value);
		log.info("City is entered");
		Thread.sleep(2000);
	}
	//Method to enter landmark
	public void enterLandmark(String value)
	{
		driver.findElement(landmark).sendKeys(value);
	}
	//Method to select country
	public void selectState()
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@name='address-ui-widgets-enterAddressStateOrRegion']")));
		select.selectByVisibleText("TELANGANA");
		List<WebElement> var = select.getOptions();
		for(WebElement country: var)
		{
			if(country.equals("TELANGANA"))
			{
				log.info("State is selected");
				break;
			}
		}
	}
	//Method to save address
	public void saveAdddress()
	{
		driver.findElement(AddAddressButton).click();;
		log.info("Address is saved");
	}
	//Method to verify address is saved
	public void verifySaveAddress()
	{
		String Address = driver.findElement(AddAddressButton).getText();
		Assert.assertEquals(Address, "Address is saved");
	}
}
