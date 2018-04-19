package testscripts;


	import java.io.IOException;
	import java.lang.reflect.InvocationTargetException;
	import java.lang.reflect.Method;
	import org.testng.annotations.Test;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	@Test
	public class DriverSettings {
		public static ExtentTest logger;
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		
		
		public void IntialDriver() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException {
			String FF,IE,Chrome,testCase,RunStatus;
			
			String suitePath = System.getProperty("user.dir")+"\\src\\test\\java\\utility\\TestSuit.xls";
			String[][] recData = ReusableMethods.readDataFromXL(suitePath, "Sheet1");
			extent=ReusableMethods.startReport(System.getProperty("user.dir")+"/ExtentReport/ExtentReport.html");
			for (int i = 1; i < recData.length; i++) {
				testCase=recData[i][0];
				RunStatus=recData[i][1];
				FF=recData[i][2];
				IE=recData[i][4];
				Chrome=recData[i][3];
				System.out.println(testCase+" "+RunStatus+" "+FF+" "+IE+" "+Chrome);
				if(RunStatus.equalsIgnoreCase("y")) {
					if(FF.equalsIgnoreCase("y")){
						logger=ReusableMethods.createTestReport(testCase+" in firefox",extent);
						Method tc = AutomationScripts.class.getMethod(testCase,String.class);
						tc.invoke(new AutomationScripts(),"firefox");
					}
					if(Chrome.equalsIgnoreCase("y")){
						Thread.sleep(5000);
						logger=ReusableMethods.createTestReport(testCase+" in chrome",extent);
						Method tc = AutomationScripts.class.getMethod(testCase,String.class);
						tc.invoke(new AutomationScripts(),"chrome");
					}
					if(IE.equalsIgnoreCase("y")){
						logger=ReusableMethods.createTestReport(testCase+" in internet explorer",extent);
						Method tc = AutomationScripts.class.getMethod(testCase,String.class);
						tc.invoke(new AutomationScripts(),"ie");
					}
				}
			}
			
			ReusableMethods.endReport(extent);
			extent.flush();
		}
	}