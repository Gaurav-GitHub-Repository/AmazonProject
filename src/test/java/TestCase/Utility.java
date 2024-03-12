package TestCase;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Utility implements ITestListener{

	
	public void OnTestStart(ITestResult result)
	{
		if(result.getStatus()==ITestResult.STARTED)
		{
			System.out.println("onTestStart");
		}
		else 
		{
			System.out.println("OnTestStart method is failed");
		}
	}
	public void onTestSuccess(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{	
			System.out.println("onTestSuccess");
		}
		else
		{
			System.out.println("onTestSuccess method is failed");
		}
	}
	public void onTestFailure(ITestResult result, WebDriver driver1)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
				try {
						TakesScreenshot screenshot = (TakesScreenshot)driver1;
						File SourceFile = screenshot.getScreenshotAs(OutputType.FILE);
						File TargetFile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\TestCase.png");
						FileUtils.copyFile(SourceFile, TargetFile);
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
		}
		else
		{
			System.out.println("Test Case is failed");
		}
	}
	public void onTestSkipped(ITestResult result)
	{
	if(result.getStatus()==result.SKIP)
	{
		System.out.println("onTestSkipped");
	}
	else
	{
		System.out.println("onTestSkipped method is failed");
	}
	}
}
