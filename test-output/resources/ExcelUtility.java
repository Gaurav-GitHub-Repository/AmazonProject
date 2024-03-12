import ExcelUtility.FileOutputStream;
import ExcelUtility.WebElement;
import ExcelUtility.XSSFRow;
import ExcelUtility.XSSFSheet;
import ExcelUtility.XSSFWorkbook;

public class ExcelUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Filename = "C:\\Selenium Temp\\Dumps\\OrangeHRM.xlsx";
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Credentials");
	    XSSFRow rowhead = sheet.createRow((int)0); 
	    rowhead.createCell(0).setCellValue("First Name");
	    rowhead.createCell(1).setCellValue("Last Name");			
	    XSSFRow row = sheet.createRow((int)1);
	    row.createCell(0).setCellValue("@Test");
	    row.createCell(1).setCellValue("Auto_5408995");			
	    String First_NameSheet = sheet.getRow(1).getCell(0).getStringCellValue();
	    System.out.println("First Name from the excel sheet is:" + First_NameSheet);
	    String Last_NameSheet = sheet.getRow(1).getCell(1).getStringCellValue();
	    System.out.println("Last Name from the excel sheet is:" + Last_NameSheet);

	    
	    
	    //Enter first name in My Info from excel sheet
	    WebElement First_Name = driver.findElement(By.xpath("//input[@name='firstName' and @placeholder='First Name']"));
	    First_Name.clear();
	    First_Name.sendKeys(First_NameSheet);            
	    //Enter last name in My Info from excel sheet
	    WebElement Last_Name = driver.findElement(By.xpath("//input[@name='lastName' and @placeholder='Last Name']"));
	    Last_Name.clear();
	    Last_Name.sendKeys(Last_NameSheet);                    
	    //Close workbook
		FileOutputStream fileOut = new FileOutputStream(Filename);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();				
	
	}
}
