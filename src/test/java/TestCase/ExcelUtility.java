package TestCase;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelUtility {

	static WebDriver driver;
	
	    void utility() throws IOException
	    {
	    	String Filename = "C:\\Selenium Temp\\Dumps\\Amazon.xlsx";
	    	XSSFWorkbook workbook = new XSSFWorkbook();
	    	XSSFSheet sheet = workbook.createSheet("Credentials");
	    	XSSFRow rowhead = sheet.createRow((int)0); 
	    	rowhead.createCell(0).setCellValue("Mobile Number");
	    	rowhead.createCell(1).setCellValue("Password");			
	    	XSSFRow row = sheet.createRow((int)1);
	    	row.createCell(0).setCellValue("1000098765");
        	row.createCell(1).setCellValue("Amazon");	
        	
        	String MobileNumber_Sheet = sheet.getRow(1).getCell(0).getStringCellValue();
        	System.out.println("MobileNumber_Sheet from the excel sheet is:" + MobileNumber_Sheet);
        	String Password_Sheet = sheet.getRow(1).getCell(1).getStringCellValue();
        	System.out.println("Password_Sheet from the excel sheet is:" + Password_Sheet);
        	//Enter first name in My Info from excel sheet
        	WebElement MobileNumber = driver.findElement(By.xpath("//input[@id='ap_email' and @name='email']"));
        	MobileNumber.clear();
        	MobileNumber.sendKeys(MobileNumber_Sheet);            
        	//Enter last name in My Info from excel sheet
        	WebElement Password = driver.findElement(By.xpath("//input[@id='ap_password' and @name='password']"));
        	Password.clear();
        	Password.sendKeys(Password_Sheet);                    	
		
			FileOutputStream fileOut = new FileOutputStream(Filename);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();				
	    }   
	}
	


