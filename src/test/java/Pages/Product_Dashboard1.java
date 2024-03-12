package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import freemarker.log.Logger;

public class Product_Dashboard1 {

	static Logger log = Logger.getLogger(Product_Dashboard1.class.getName());
	
	WebDriver driver;
	
	public Product_Dashboard1(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for Cart Button
	private By CartButton = By.xpath("//*[@id='attach-view-cart-button-form']/span/span/input");
	//Locator to retrieve product details
	private By ProductDetails = By.xpath("//*[@id='sc-active-cart' and @data-name='Active Cart']");
	//Locator for sub total
	private By Sub_Total = By.xpath("//*[@id='sc-subtotal-amount-activecart']/span");
	//Locator for Proceed to Buy Button
	private By ProceedToBuy = By.xpath("//input[@name='proceedToRetailCheckout']");
	//Locator to verify address
	private By verifyAddress = By.xpath("//div[@class='a-row address-row list-address-selected']/span/div/label/span/span[2]");
	
	//Method to click on cart button
	public void clickOnCartButton()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			//wait.until(ExpectedConditions.presenceOfElementLocated(AddToCartButton));
			wait.until(ExpectedConditions.elementToBeClickable(CartButton));
			driver.findElement(CartButton).click();
		}
		catch(ElementNotInteractableException e)
		{
			System.out.println("Exception Occured: ElementNotInteractableException");
		}
	}
	//Method to retrieve product details
	public void verifyProductDetails()
	{
		String Product = driver.findElement(ProductDetails).getText();
		if(Product.contains("Shopping Cart"))
		{
			System.out.println("User is on shopping cart page" + Product);
		}
		else
		{
			System.out.println("User is not on shopping cart page" + Product);
		}
	}
	//Method to calculate GST% of sub total
	public void verifySubTotal()
	{
		try {
		String Total = driver.findElement(Sub_Total).getText();
		//String Total = "14499";
		int intNumber = Integer.parseInt(Total);
		if(intNumber > 0)
		{
			int sum = intNumber*(8/100);
			System.out.println(sum);
		}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Exception Occured: NumberFormatException");
		}
	//	else
	//	{
	//		System.out.println("GST% is not calculated");
	//	}
	}
	//Method to verify buy button
	public void BuyButton()
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(ProceedToBuy));
		driver.findElement(ProceedToBuy).click();
	}
	//Method to verify address in checkout page
	public void verifyAddress()
	{
		String Address = driver.findElement(verifyAddress).getText();
		Assert.assertEquals(Address, "B-509, Sri Gajanana Homes, Kompally, Hyderabad, Sri Gajanana Homes, Kompally, Hyderabad, Telangana, HYDERABAD, TELANGANA, 500100, India");
	}
}
