package Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.sjavac.Log;

public class Search_Dashboard {

	WebDriver driver;
	
	public Search_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for product category
	private	By ProductCategory = By.xpath("//select[@id='searchDropdownBox']");
	//Locator for search
	private	By Search = By.xpath("//*[@id='twotabsearchtextbox']");
	//Locator for amazon logo
	private By Amazon_Logo = By.xpath("//a[@href='/ref=nav_logo']");
	//Locator for delivery day
//	By Delivery_Day = By.xpath("//div[@id='s-refinements']/div/div/ul/span/span[2]/li/span/a/div/label/input");
	private By Delivery_Day = By.xpath("//*[@id='p_90/6741118031']/span/a/div/label/input");
	//Locator for Brands 
	private By Brands = By.xpath("//span[text()='Brand']");
	//Locator for Price
	private By price = By.xpath("//span[text()='Price']");
	//Locator for product
	private By Product = By.xpath("//div[@id='s-refinements']/div/div[4]/ul/span/span[4]/li/span/a/div/label/i");
	//Locator for min price
	private By Min_Price = By.xpath("//div[@id='s-refinements']/div/div[5]/ul/span/span[6]/li/span/span/form/input[7]");
	//Locator for max price
	private By Max_Price = By.xpath("//div[@id='s-refinements']/div/div[5]/ul/span/span[6]/li/span/span/form/input[8]");
	//Locator for price button
	private By Price_Button = By.xpath("//div[@id='s-refinements']/div[1]/div[5]/ul/span/span[6]/li/span/span/form/span/span/input");
	//Locator for samsung product
	private By Product1 = By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	//Locator for Product2
	private By Product2 = By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	//Locator for Product3
	private By Product3 = By.xpath("//*[contains(@href,'Oneplus')]");
	//Locator for One Plus Brand
	private By OnePlusBrand = By.xpath("//*[@id='p_89/OnePlus']/span/a/span");
	
	//Method to select product category
	public void selectCategory()
	{
		  Select select = new Select(driver.findElement(ProductCategory));
		  select.selectByVisibleText("Amazon Devices");
		  List<WebElement> var = select.getOptions();
		  for(WebElement options: var)
		  {
			  if(options.getText().equals("Amazon Devices"))
			  {
				  System.out.println("Product dropdown is selected");
				  break;
			  }	 
		  }
	}
	//Method to scroll
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}	
	//Method to scroll to Element
	public void scrollToElement()
	{
		WebElement Element = driver.findElement(Product2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}	
	//Method to enter product in search
	public void searchProduct(String value) throws InterruptedException
	{
		driver.findElement(Search).sendKeys(value);
		Thread.sleep(2000);
		driver.findElement(Search).sendKeys(Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	//Method to click on amazon logo
	public void logo() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Amazon_Logo).click();
	}
	//Method to select delivery day
	public void selectProductFilter1() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='s-refinements']/div/div/ul/span/span[2]/li/span/a/div/label/i")).click();
	}
	//Method to select product
	public void selectProduct()
	{
		WebElement Element = driver.findElement(Brands);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Product));
		driver.findElement(Product).click();
	}
	//Method to click on price button
	public void selectProductPrice(String value)
	{
		WebElement Element = driver.findElement(price);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(Min_Price));
		driver.findElement(Min_Price).sendKeys(value);
	}
	//Method to click on price button
	public void selectProductPrice1(String value1) throws InterruptedException
	{
		driver.findElement(Max_Price).sendKeys(value1);
		Thread.sleep(2000);
		driver.findElement(Max_Price).sendKeys(Keys.TAB);
	}
	//Method to click on price button
	public void selectProductPrice2()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(Price_Button));
		driver.findElement(Price_Button).click();
	}
	//Method to click on sort by filter
	public void ProductFilter()
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
		select.selectByVisibleText("Price: High to Low");
		List<WebElement> var = select.getOptions();
		for(WebElement SortByFilter: var)
		{
			if(SortByFilter.equals("Price: High to Low"))
			{
				System.out.println("Product filter is selected");
				Log.error("Unable to select product filter");
				break;
			}
		}
	}
	//Method to click on sort by filter
	String value1 = "Price: Low to High";
	public void ProductFilter(String value1)
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
		select.selectByVisibleText("Price: Low to High");
		List<WebElement> var = select.getOptions();
		for(WebElement SortByFilter: var)
		{
			if(SortByFilter.equals(value1))
			{
				System.out.println("Product filter is selected");
				Log.error("Unable to select product filter");
				break;
			}
		}
	}
	//Method to select Product3
	public void verifyProduct()
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(Product1));
		String variable  = driver.findElement(Product1).getText();
		String Product = "Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Gray, 12GB, 1TB Storage)";
		if(variable.equals(Product))
		{
			//driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
			driver.findElement(Product1).click();
		}
		else
		{
			System.out.println("Product is not selected");
		}
	} 	
	//Method to select Product3
	String value = "Oneplus Open (Emerald Dusk, 16GB RAM, 512GB Storage)";
	public void verifyProduct(String value)
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(Product2));
		String variable = driver.findElement(Product2).getText();
		if(variable.equals(value))
		{
			//driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
			driver.findElement(Product2).click();
		}
		else
		{
			System.out.println("Product is not selected");
		}
	} 	
	//Method to select product
	public void selectProduct(String value) throws InterruptedException
	{
		//Thread.sleep(2000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.presenceOfElementLocated(OnePlusBrand));
			driver.findElement(OnePlusBrand).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Exception Occured: NoSuchElementException");
		}
		catch(TimeoutException e)
		{
			System.out.println("Exception Occured: TimeoutException");
		}
	}
	//Method to select Product
	public void selectOnePlusProduct()
	{
		Actions action = new Actions(driver);
		WebElement Product = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));
		action.moveToElement(Product).build().perform();
		action.clickAndHold(Product).build().perform();
		action.click(Product).build().perform();
	}
	//Method to select Product
	public void selectProduct1()
	{
		Actions action = new Actions(driver);
		WebElement Product = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));
		action.moveToElement(Product).build().perform();
		action.clickAndHold(Product).build().perform();
		action.click(Product).build().perform();
	}
}
