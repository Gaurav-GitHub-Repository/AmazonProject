package TestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility2 {

	WebDriver driver;
	
	public Utility2(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Button = By.xpath("//*[@id='navBackToTop']/div/span");
	
	//Method to scroll
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}	
	//Method to scroll to the element
	public void scroll(String value)
	{
		WebElement Element = driver.findElement(Button);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	//Method to take screenshot
	public void takeScreenshot() throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Selenium Temp\\BDD_Cucumber\\AmazonProject\\screenshots\\Screenshot1.png"); 
		FileUtils.copyFile(source, target);
	}
	//Method to upload file
	public void uploadFile() throws AWTException
	{
	       Robot robot = new Robot();
	       robot.setAutoDelay(3000);
	       StringSelection stringselection = new StringSelection("C:\\Users\\Gaurav\\Desktop\\File.txt");  //File Upload
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
	       robot.setAutoDelay(3000);
	       robot.keyPress(KeyEvent.VK_CONTROL);
	       robot.keyPress(KeyEvent.VK_V);
	       robot.keyRelease(KeyEvent.VK_CONTROL);
	       robot.keyRelease(KeyEvent.VK_V);
	       robot.setAutoDelay(3000);
	       robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
