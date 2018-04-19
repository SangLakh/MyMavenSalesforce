package testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReusableMethods {
	static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	/* 
	 * Name of the Method: enterText
	 * Brief Description:Enter text to text boxes
	 * Arguments: obj --> Object, textval --> test value to be entered, objName --> Name of the object
	 * Created By: Automation team
	 * Creation date: Mar 09 2018
	 * Last Modified By: sangeetha
	 * Last Modified Date: Mar 09 2018
	 * 
	 * This is called CMMI-V level coding
	 * 
	 * */
	public static void enterText(WebElement obj, String textVal, String objName) {
		if(obj.isDisplayed()) {
			obj.clear();
			obj.sendKeys(textVal);
			System.out.println("Pass:"+textVal+" is entered in "+objName +" field");
		}else {
			System.out.println("Fail: "+objName+" does not exist. Please check your application");
		}
	}
	/*Name of the Method: clickObject
	 * Brief Description: Click on Object
	 * Arguments: obj--->Object, objName---> name of object
	 * Created By : Automation team
	 * Creation date : Mar 09 2018
	 * Last Modified Date: Mar 09 2018
	 * Last Modified by: sangeetha
	 */
	public static void clickObject(WebElement obj, String objName) {
		if(obj.isDisplayed()) {
			obj.click();
			System.out.println("Pass:"+objName+" is clicked");
		}else {
			System.out.println("Fail: "+objName+" does not exist. Please check your application");
		}
	}
	/*Name of the Method: selectCheckbox
	 * Brief Description: checks the checkbox selection
	 * Arguments: obj--->Object, objName---> name of object
	 * Created By : Automation team
	 * Creation date : Mar 09 2018
	 * Last Modified Date: Mar 09 2018
	 * Last Modified by: sangeetha
	 */
	public static void selectCheckbox(WebElement obj,String objName) {
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				System.out.println("Pass:"+objName+" is already selected");
			}
			else {
				obj.click();
				System.out.println("Pass:"+objName+" is selected");
			}
		}else {
			System.out.println("Fail: "+objName+" is not displayed. Please check your application");
		}
	}
	
	/*Name of the Method: DeselectCheckbox
	 * Brief Description: checks the checkbox Deselection
	 * Arguments: obj--->Object, objName---> name of object
	 * Created By : Automation team
	 * Creation date : Mar 09 2018
	 * Last Modified Date: Mar 09 2018
	 * Last Modified by: sangeetha
	 */
	public static void DeselectCheckbox(WebElement obj,String objName) {
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				obj.click();
				System.out.println("Pass:"+objName+" is deselected");
			}
			else {
				System.out.println("Pass:"+objName+" is already deselected");
			}
		}else {
			System.out.println("Fail: "+objName+" is not displayed. Please check your application");
		}
	}
	/*Name of the Method: validateTextBoxContent
	 * Brief Description: checks whether entered text is an expected text
	 * Arguments: obj--->Object, eexpectedText---> xpected text, objName---> name of object
	 * Created By : Automation team
	 * Creation date : Mar 09 2018
	 * Last Modified Date: Mar 09 2018
	 * Last Modified by: sangeetha
	 */	
	public static void validateTextBoxContent(WebElement obj, String expectedText, String objName){
		if(obj.isDisplayed())
		{
			String actualText = obj.getAttribute("value");
			if(expectedText.equalsIgnoreCase(actualText)){
				System.out.println("Pass: " + " Expected text '" + expectedText + "' is matching with actual text.");
			}else{
				System.out.println("Fail: "+" Expected text '" + expectedText + "' is not matching with actual text '"+ actualText+ "'.");
			}
		}else{
			System.out.println("Fail :" + objName + " is not diplayed, please check your application");
		}
	}
	public static String[][] readDataFromXL(String dataTablePath,String sheetName) throws IOException {
			//String curDir=System.getProperty("user.dir");//gives the current app directory 
			File file=new File(dataTablePath);
			FileInputStream fsIn=new FileInputStream(file);
			HSSFWorkbook workbook=new HSSFWorkbook(fsIn);
			HSSFSheet sheet=workbook.getSheet(sheetName);
			int numRows=sheet.getLastRowNum()+1;
			int numCols=sheet.getRow(0).getLastCellNum();
			String str[][]=new String[numRows][numCols];
			for(int i=0;i<numRows;i++)
				for(int j=0;j<numCols;j++)
					str[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			return str;
		 }
	public static void checkWindowTitle(String Title) {
		if(driver.getTitle().contains(Title)) {
			System.out.println("Pass: "+Title+" Page launch");
		}else {
			System.out.println("Fail: "+Title+" Page launch");
		}
	}
		 public static void closePopup() throws InterruptedException, AWTException {
			//closing the popup
			Robot robo=new Robot();
			robo.keyPress(KeyEvent.VK_ESCAPE);
			robo.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(3000);

		 }
		 public static WebDriver launchBrowser(String name){
				if(name.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver","./src/test/java/utility/geckodriver.exe");
					driver=new FirefoxDriver();
				}
				else if(name.equalsIgnoreCase("chrome")){
					System.out.println("chrome entered");
					System.setProperty("webdriver.chrome.driver","./src/test/java/utility/chromedriver1.exe");
					driver=new ChromeDriver();
				}
				else if(name.equalsIgnoreCase("ie")){
					System.out.println("Internet Explorer entered");
					System.setProperty("webdriver.ie.driver","./src/test/java/utility/IEDriverServer.exe");
					driver=new InternetExplorerDriver();
				}
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
				return driver;
			}
		 public static void closeBrowser(WebDriver driver){
					driver.quit();
		 }
		 public static ExtentReports startReport(String reportPath){
		 		//System.getProperty("user.dir") +"/test-output/STMExtentReport.html"
		 		htmlReporter = new ExtentHtmlReporter(reportPath);
		 		extent = new ExtentReports ();
		 		extent.attachReporter(htmlReporter);
		 		extent.setSystemInfo("Host Name", "tekarch QA");
		 		extent.setSystemInfo("Environment", "Automation Testing");
		 		extent.setSystemInfo("User Name", "Divyashree");
		 		
		 		htmlReporter.config().setDocumentTitle("report status");
		 		htmlReporter.config().setReportName("customized report");
		 		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 		htmlReporter.config().setTheme(Theme.STANDARD);
		 		return extent;
		 	}
		 	
		 	public static ExtentTest createTestReport(String testName,ExtentReports extent){
		 		logger = extent.createTest(testName);
		 		return logger;
		 	}
		 	public static void endReport(ExtentReports extent){
		 		extent.flush();
		 	}
}
