package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import freemarker.log.Logger;

public class Product_Dashboard {

	static Logger log = Logger.getLogger(Product_Dashboard.class.getName());
	
	WebDriver driver;
	
	public Product_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for Product
	private By Product1 = By.xpath("//div[@data-component-id='62']/div/div/span/div/div/div/div/div/div/div/span/a/div/img");
	//Locator for Product 2
	private By Product2 = By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a");
	//Locator for product 3
	private By Product3 = By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	//Locator for Add To Cart button
	//private By AddToCartButton = By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[37]/div[1]/span/span/span/span");
	private By AddToCartButton = By.xpath("//input[@id='add-to-cart-button' and @type='submit']");
	//Locator for slide button
	private By SlideButton = By.xpath("//*[@id='gw-desktop-herotator']/div/div/div/div[3]/a/i");
	//Locator for SlideButton2
	private By SlideButton2 = By.xpath("//*[@id='gw-desktop-herotator']/div/div/div/div[1]/a/i");						
	//Locator for scroll button
	private By ScrollButton = By.xpath("//*[@id='navBackToTop']/div/span");
	//Locator to verify product is added to cart
	private By ProductAddToCart = By.xpath("//*[@id='attachDisplayAddBaseAlert']/div/h4");
	
	//Method to switch Product Page
	public void switchToProduct()
	{
		Set<String> Product_Page = driver.getWindowHandles();
		System.out.println(Product_Page);
		for(String Product: Product_Page)
		{
			driver.switchTo().window(Product);
		}
	}
	//Method to click on product
	public void selectProduct1()
	{
		Actions action = new Actions(driver);
		WebElement Product = driver.findElement(Product1);
		action.clickAndHold(Product).build().perform();
		action.moveToElement(Product).build().perform();
		action.click(Product).build().perform();
	}
	//Method to click on product
	public void selectProduct2()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Product1));
		driver.findElement(Product1).click();
		log.info("Successfully clicked on the product");
	}
	//Method to click on product
	public void selectProduct3() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Product2).click();
	}
	//Method to click on product
	public void selectProduct4() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Product3).click();
	}
	//Method to click on add to cart button
	public void AddToCart()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			//wait.until(ExpectedConditions.presenceOfElementLocated(AddToCartButton));
			wait.until(ExpectedConditions.elementToBeClickable(AddToCartButton));
			driver.findElement(AddToCartButton).click();
		}
		catch(ElementNotInteractableException e)
		{
			System.out.println("Exception Occured: ElementNotInteractableException");
		}
	}
	//Method to verify that product is added to cart
	public void verifyProductAddedToCart()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ProductAddToCart));
		String var = driver.findElement(ProductAddToCart).getText();
		Assert.assertEquals(var, "Added to Cart");
	}
	//Method to click on slide button
	public void Slide()
	{
		for(int i=1; i<=3; i++)
		{
			if(i==2)
			{
				System.out.println(i);
				break;	
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SlideButton));
		driver.findElement(SlideButton).click();
	}
	//Method to click on slide button
	public void Slide2()
	{
		for(int i=1; i<=3; i++)
		{
			if(i==2)
			{
				System.out.println(i);
				break;	
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SlideButton2));
		driver.findElement(SlideButton2).click();
	}	
	//Method to click on scroll button
	public void ScrollButton1()
	{
		driver.findElement(ScrollButton).click();
	}
}
