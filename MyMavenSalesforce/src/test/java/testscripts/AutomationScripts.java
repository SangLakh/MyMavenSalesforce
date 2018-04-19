package testscripts;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationScripts extends ReusableMethods{
	static WebDriver driver;
	public static void Login_Error_Message(String BrowserNM) {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		/*Launch URL*/
		driver.get("https://login.salesforce.com");
		
		System.out.println("Salesforce application is launched");
		/*Enter UN in user name field..*/
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		enterText(un, "User@gmail.com", "UserName");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(un, "User@gmail.com", "UserName");
			
		/*Enter PWD in password field..*/
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(pwd, "", "Password");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(pwd, "", "Password");

		/*Click login button*/
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObject(loginButton, "Login Button");
		
		String actualText=driver.findElement(By.xpath("//*[@id='error']")).getText();
		String expString="Please enter your password.";
		if(actualText.equalsIgnoreCase(expString))
			System.out.println("Pass:error message verification");
		else
			System.out.println("Fail:Error message verification");
		
		driver.close();
		System.out.println("Browser closed..");
	}
	
	public static void Login_To_SalesForce(String BrowserNM) {
		driver=ReusableMethods.launchBrowser(BrowserNM);
	
		/*Launch URL*/
		driver.get("https://login.salesforce.com");
		if(driver.getTitle().contains("Salesforce")) {
			System.out.println("Pass:Salesforce application launch");
		}else {
			System.out.println("Fail:Salesforce application launch");
		}

		/*Enter UN in user name field..*/
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		enterText(un, "sang.lakh@Gmail.com", "UserName");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(un, "sang.lakh@gmail.com", "UserName");

		/*Enter PWD in password field..*/
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(pwd, "admin2018", "Password");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(pwd, "admin2018", "Password");

		/*Click login button*/
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObject(loginButton, "Login Button");
		
		String homeTiltle=driver.getTitle();
		if(homeTiltle.contains("Home Page"))
			System.out.println("Pass:home page verification");
		else
			System.out.println("Fail:home page verification");
		
		driver.close();
		System.out.println("Browser closed..");
	
	}
	public static void Check_RemeberMe(String BrowserNM) throws InterruptedException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		
		/*Launch URL*/
		driver.get("https://login.salesforce.com");
		if(driver.getTitle().contains("Salesforce")) {
			System.out.println("Pass:Salesforce application launch");
		}else {
			System.out.println("Fail:Salesforce application launch");
		}

		/*Enter UN in user name field..*/
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		enterText(un, "sang.lakh@Gmail.com", "UserName");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(un, "sang.lakh@gmail.com", "UserName");

		/*Enter PWD in password field..*/
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(pwd, "admin2018", "Password");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(pwd, "admin2018", "Password");

		/*Select Check remember me */
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		selectCheckbox(checkBox, "Remember me check box");

		/*Click login button*/
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObject(loginButton, "Login Button");
		Thread.sleep(5000);
		
		WebElement userMenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObject(userMenu,"User Menu");
		Thread.sleep(5000);
		WebElement logout=driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		//Thread.sleep(5000);
		clickObject(logout,"Log out option");
		
		String actID=driver.findElement(By.xpath("//*[@id='idcard-identity']")).getText();
		if(actID.equalsIgnoreCase("sang.lakh@gmail.com"))
			System.out.println("Pass:Email Id verification");
		else
			System.out.println("Fail:Email Id verification");
		
		driver.close();
		System.out.println("Browser closed..");
	}
	
	public static void Forgot_Password_A(String BrowserNM) throws InterruptedException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		
		/*Launch URL*/
		driver.get("https://login.salesforce.com");
		if(driver.getTitle().contains("Salesforce")) {
			System.out.println("Pass:Salesforce application launch");
		}else {
			System.out.println("Fail:Salesforce application launch");
		}
		
		//clicks on the password link
		WebElement pwdLink=driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
		clickObject(pwdLink,"Password Link");
		
		if(driver.getTitle().contains("Forgot your password")) {
			System.out.println("Pass:Forgot Password Page Displayed");
		}else {
			System.out.println("Fail:Forgot Password Page Displayed");
		}
		//Enter usernm in the username field
		WebElement userNM=driver.findElement(By.xpath("//*[@id='un']"));
		enterText(userNM, "sang.lakh@gmail.com", "UserName");
		
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(userNM, "sang.lakh@gmail.com", "UserName");
		Thread.sleep(5000);
		
		WebElement contButton=driver.findElement(By.xpath("//*[@id='continue']"));
		clickObject(contButton,"Continue Button");
		
		String actText=driver.findElement(By.xpath("//*[@id='forgotPassForm']/div/p[1]")).getText();
		String expString="We’ve sent you an email with a link to finish resetting your password.";
		if(actText.equalsIgnoreCase(expString))
			System.out.println("reset message verified");
		else
			System.out.println("reset message is not verified");
		
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void Forgot_Password_B(String BrowserNM) {
		driver=ReusableMethods.launchBrowser(BrowserNM);
	/*Launch URL*/
		driver.get("https://login.salesforce.com");
		if(driver.getTitle().contains("Salesforce")) {
			System.out.println("Pass:Salesforce application launch");
		}else {
			System.out.println("Fail:Salesforce application launch");
		}
		
		System.out.println("Salesforce application is launched");
		/*Enter UN in user name field..*/
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		enterText(un, "123", "UserName");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(un, "123", "UserName");

		/*Enter PWD in password field..*/
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(pwd, "22131", "Password");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(pwd, "22131", "Password");

		/*Click login button*/
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObject(loginButton, "Login Button");
		
		driver.close();
		System.out.println("Browser closed..");
		
	}	
	public static void TC05(String BrowserNM) throws InterruptedException{
		driver=ReusableMethods.launchBrowser(BrowserNM);
	
		LoginSalesForce();//Logging into salesforce		
		List<String> expMenu= new ArrayList<String>(Arrays.asList("My Profile","My Settings","Developer Console","Logout"));
		WebElement userMenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObject(userMenu,"User Menu");
		List<WebElement> menuOptions=driver.findElements(By.xpath(".//*[@id='userNav-menuItems']/a"));
		List<String> actualMenu=new ArrayList<String>();
		for (WebElement we : menuOptions) {
			actualMenu.add(we.getText());
		}
		if(actualMenu.containsAll(expMenu)) {
			System.out.println("menu options verified");
		}
		else
		{
			System.out.println("menu options verification is failed");
		}
		Thread.sleep(5000);
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void TC06(String BrowserNM) throws InterruptedException{
		driver=ReusableMethods.launchBrowser(BrowserNM);
	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		System.out.println("Firefox browser is launched");
		LoginSalesForce();//Logging into salesforce
		
		WebElement userMenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObject(userMenu,"User Menu");
		
		WebElement menuProfile=driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]"));
		clickObject(menuProfile, "Profile Menu");
		
		
		WebElement  Edit=driver.findElement(By.xpath("//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		clickObject(Edit, "Edit Profile");
		
		driver.switchTo().frame("contactInfoContentId");
		//error
		WebElement  About=driver.findElement(By.xpath("//*[@id='aboutTab']/a"));
		clickObject(About, "About Tab");
		
		WebElement  LastNM=driver.findElement(By.xpath("//*[@id='lastName']"));
		enterText(LastNM,"seedalla", "Last Name");
		validateTextBoxContent(LastNM, "seedalla", "Last Name");
		
		WebElement  SaveAll=driver.findElement(By.xpath(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
		clickObject(SaveAll, "Save Profile");
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		WebElement  Post=driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']/span[1]"));
		clickObject(Post, "Post tab");
		Thread.sleep(3000);

		WebElement frame=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.switchTo().frame(frame);
		System.out.println("switched");
		Thread.sleep(1000);
		System.out.println("tag html?  "+driver.findElements(By.xpath("//html/body")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body")));
		WebElement postMessage=driver.findElement(By.xpath("/html/body"));
		postMessage.sendKeys("This is using Automation");
		driver.switchTo().defaultContent();
	
		
		WebElement  btnShare=driver.findElement(By.xpath("//*[@id='publisherAttachTextPost']/span[1]"));
		clickObject(btnShare, "Share button");
		
		WebElement  tabFile=driver.findElement(By.xpath("//*[@id='profileFeed']/div/div[1]/ul/li[2]"));
		clickObject(tabFile, "File Tab");
		
		WebElement  btnUpload=driver.findElement(By.xpath("//*[@id='chatterUploadFileAction']"));
		clickObject(btnUpload, "Upload a file from computer");
		
		//WebElement  btnBrowse=driver.findElement(By.xpath(".//*[@id='chatterFile']"));
		//clickObject(btnBrowse, "Browse button");

		WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterFile']")));
		browse.sendKeys("C:\\Users\\SatSang\\Desktop\\test.txt");
		
		WebElement share=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='publishersharebutton']")));
		share.click();
		Thread.sleep(5000);
		//Add photo
		
		Actions mousehoover=new Actions(driver);
		mousehoover.moveToElement(driver.findElement(By.xpath("//*[text()='Moderator']"))).perform();;
		WebElement addPhoto=driver.findElement(By.xpath(".//*[@id='uploadLink']"));
		addPhoto.click();
		Thread.sleep(5000);
		WebElement photoframe=driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(photoframe);
		WebElement browsePhoto=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadInputFile']")));
	
		browsePhoto.sendKeys("C:\\Users\\SatSang\\Desktop\\photo.jpg");
	
		WebElement savePhoto=driver.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadBtn']"));
		savePhoto.click();
		
		driver.switchTo().defaultContent();		
		
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void TC07(String BrowserNM) throws InterruptedException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement userMenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObject(userMenu,"User Menu");
		
		WebElement menuSettings=driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		clickObject(menuSettings, "Settings Menu");
		
		WebElement linkPersonal=driver.findElement(By.xpath("//*[@id='PersonalInfo']/a"));
		clickObject(linkPersonal,"Personal Link");
		
		WebElement linkLogHistory=driver.findElement(By.xpath("//*[@id='LoginHistory_font']"));
		clickObject(linkLogHistory, "Login History");
		
		WebElement linkdownloadLog=driver.findElement(By.xpath("//*[@id='RelatedUserLoginHistoryList_body']/div/a"));
		clickObject(linkdownloadLog, "Download Login History");
		
		WebElement linkDisplay=driver.findElement(By.xpath("//*[@id='DisplayAndLayout']/a"));
		clickObject(linkDisplay, "Display & Layout");
		
		WebElement linkCustomize=driver.findElement(By.xpath("//*[@id='CustomizeTabs_font']"));
		clickObject(linkCustomize, "Customize the tabs");
		
		WebElement comboCustomApp=driver.findElement(By.xpath("//*[@id='p4']"));
		clickObject(comboCustomApp, "CustomApp Combo box");
		Select select=new Select(comboCustomApp);
		select.selectByVisibleText("Salesforce Chatter");//selects by the text
		WebElement account=driver.findElement(By.xpath(".//*[@id='p4']/option[9]"));
		Actions action =new Actions(driver);
		action.moveToElement(account).build().perform();
		
		WebElement listAvail=driver.findElement(By.xpath(".//*[@id='duel_select_0']"));
		Select selectRep=new Select(listAvail);
		selectRep.selectByVisibleText("Reports");//selects by the text
		
		WebElement imgAdd=driver.findElement(By.xpath(".//*[@id='duel_select_0_right']/img"));
		clickObject(imgAdd, "Add");
		
		WebElement linkMail= driver.findElement(By.xpath("//*[@id='EmailSetup']/a"));
		clickObject(linkMail, "EMail");
		
		WebElement linkMailSet =driver.findElement(By.xpath("//*[@id='EmailSettings_font']"));
		clickObject(linkMailSet, "My EMail Settings");
		
		WebElement emailNM=driver.findElement(By.xpath(".//*[@id='sender_name']"));
		enterText(emailNM, "sangeetha", "Email Name");
		validateTextBoxContent(emailNM, "sangeetha", "Email Name");
		
		WebElement emailAdd=driver.findElement(By.xpath(".//*[@id='sender_email']"));
		enterText(emailAdd, "sang.lakh@gmail.com", "Email Address");
		validateTextBoxContent(emailAdd, "sang.lakh@gmail.com", "Email Address");

		WebElement radioBCC=driver.findElement(By.xpath(".//*[@id='auto_bcc1']"));
		clickObject(radioBCC, "Automatic BCC");
		
		WebElement btnSave=driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
		clickObject(btnSave, "Save");
		Thread.sleep(3000);
		
		WebElement linkCal=driver.findElement(By.xpath(".//*[@id='CalendarAndReminders']/a"));
		clickObject(linkCal, "Calendar & remainders");
		
		WebElement linkRemain=driver.findElement(By.xpath(".//*[@id='Reminders_font']"));
		clickObject(linkRemain, "Activity Remainders");
		
		driver.close();
		System.out.println("Browser closed..");
	}

	public static void TC08(String BrowserNM) throws InterruptedException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement userMenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObject(userMenu,"User Menu");
		
		WebElement linkDev=driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
		clickObject(linkDev, "Developer Console");
		driver.close();
		System.out.println("Browser closed..");
	}

	public static void TC09(String BrowserNM) throws InterruptedException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement userMenu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		clickObject(userMenu,"User Menu");
		
		WebElement linkLogout=driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
		clickObject(linkLogout, "Log out");
		
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void CreateAccount(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabAccount=driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickObject(tabAccount,"Accounts Tab");
		ReusableMethods.closePopup();
		Thread.sleep(2000);
		
		WebElement btnNew=driver.findElement(By.name("new"));
		clickObject(btnNew, "New button");
		
		WebElement accountNM=driver.findElement(By.name("acc2"));
		enterText(accountNM, "Bank", "Account Name");
		validateTextBoxContent(accountNM, "Bank", "Account Name");
		
		WebElement btnSave=driver.findElement(By.name("save"));
		clickObject(btnSave, "Save Button");
		
		driver.close();
		System.out.println("Browser closed..");	
	}
	
	public static void Createnewview(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabAccount=driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickObject(tabAccount,"Accounts Tab");
		ReusableMethods.closePopup();
		Thread.sleep(3000);
		
		WebElement btnNewView=driver.findElement(By.xpath(".//*[@id='filter_element']/div/span/span[2]/a[2]"));
		clickObject(btnNewView, "New view Link");
		
		WebElement viewNM=driver.findElement(By.name("fname"));
		enterText(viewNM, "View1", "View Name");
		validateTextBoxContent(viewNM, "View1", "View Name");
		
		WebElement viewUniqueNM=driver.findElement(By.name("devname"));
		enterText(viewUniqueNM, "ViewUnique1", "View Unique Name");
		validateTextBoxContent(viewUniqueNM, "ViewUnique1", "View Unique Name");
		
		WebElement btnSave=driver.findElement(By.name("save"));
		clickObject(btnSave, "Save Button");
		Thread.sleep(3000);
		
		driver.close();
		System.out.println("Browser closed..");
	}
	
	public static void Editview(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabAccount=driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickObject(tabAccount,"Accounts Tab");
		Thread.sleep(3000);
		
		//closing the popup
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_ESCAPE);
		robo.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);

		WebElement comboView=driver.findElement(By.name("fcf"));
		clickObject(comboView, "CustomApp Combo box");
		Select select=new Select(comboView);
		select.selectByVisibleText("View");//selects by the text
		WebElement view=driver.findElement(By.xpath(".//*[@name='fcf']/option[8]"));
		Actions action =new Actions(driver);
		action.moveToElement(view).build().perform();
		Thread.sleep(3000);
		
		WebElement btnEdit=driver.findElement(By.xpath(".//*[@id='filter_element']/div/span/span[2]/a[1]"));//*[@id='00B6A000005Nuti_filterLinks']/a[1]"));//error
		clickObject(btnEdit, "Edit Button");
		
		WebElement viewNM=driver.findElement(By.name("fname"));
		enterText(viewNM, "View", "View Name");
		validateTextBoxContent(viewNM, "View", "View Name");
		
		WebElement AccountName=driver.findElement(By.id("fcol1"));
		clickObject(AccountName, "Filter Field");
		Select selectAcc=new Select(AccountName);
		selectAcc.selectByVisibleText("Account Name");
		WebElement selAccount=driver.findElement(By.xpath(".//*[@id='fcol1']/option[2]"));
		Actions action1=new Actions(driver);
		action1.moveToElement(selAccount).build().perform();
		Thread.sleep(2000);
		
		WebElement Operator=driver.findElement(By.id("fop1"));
		clickObject(Operator, "Filter Field");
		Select selectOp=new Select(Operator);
		selectOp.selectByVisibleText("contains");
		WebElement selOp=driver.findElement(By.xpath(".//*[@id='fop1']/option[5]"));
		Actions actionOP=new Actions(driver);
		actionOP.moveToElement(selOp).build().perform();
		Thread.sleep(2000);
		
		WebElement value=driver.findElement(By.id("fval1"));
		enterText(value, "a", "Value");
		validateTextBoxContent(value, "a", "Value");
		
		WebElement LastActivity=driver.findElement(By.xpath(".//*[@id='colselector_select_0']/option[30]"));
		clickObject(LastActivity, "Last Activity Option");
		
		WebElement imgAdd=driver.findElement(By.xpath(".//*[@id='colselector_select_0_right']/img"));
		clickObject(imgAdd, "Add Button");
		
		WebElement btnSave=driver.findElement(By.name("save"));
		clickObject(btnSave, "Save Button");
		Thread.sleep(1000);
	
		driver.close();
		System.out.println("Browser closed..");
		
	}
	
	public static void MergeAccounts(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabAccount=driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickObject(tabAccount,"Accounts Tab");
		ReusableMethods.closePopup();
		Thread.sleep(4000);
		
		WebElement linkMergeAcc=driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		clickObject(linkMergeAcc, "Merge Accounts");
		
		WebElement txtSearch=driver.findElement(By.name("srch"));
		enterText(txtSearch, "bank", "Find Account Textbox");
		validateTextBoxContent(txtSearch, "bank", "Find Account Textbox");
	
		WebElement btnSearch=driver.findElement(By.name("srchbutton"));
		clickObject(btnSearch, "Search Button");
		Thread.sleep(3000);
		
		List<WebElement> listAccounts=driver.findElements(By.name("cid"));
		//selected accounts
		if(listAccounts.size()>2) {
			for(int i=0;i<2;i++)
				clickObject(listAccounts.get(i),"List of Accounts");
			WebElement btnNext=driver.findElement(By.name("goNext"));
			clickObject(btnNext, "Next Button");
			
			WebElement btnSave=driver.findElement(By.name("save"));
			clickObject(btnSave, "Merge");
		}
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void TC14(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		System.out.println();
		LoginSalesForce();//Logging into salesforce
		Thread.sleep(2000);
		
		WebElement tabAccount=driver.findElement(By.xpath(".//*[@id='Account_Tab']/a"));
		clickObject(tabAccount,"Accounts Tab");
		Thread.sleep(3000);
		
		ReusableMethods.closePopup();
		
		WebElement linkReport=driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		clickObject(linkReport, "Accounts with last activity > 30 days");
		Thread.sleep(5000);
		
		WebElement dateCol=driver.findElement(By.xpath(".//*[@id='ext-gen148']"));
		clickObject(dateCol, "Date Field");
		Thread.sleep(5000);
		
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_ENTER);

//		WebElement CreatedDate=driver.findElement(By.xpath(".//*[@id='ext-gen264']/div[3]"));
//		clickObject(CreatedDate, "Created Date Option");
		Thread.sleep(3000);
		WebElement FromDateimg=driver.findElement(By.xpath(".//*[@id='ext-gen152']"));
		clickObject(FromDateimg, "From Date field");
		
		//title=Today
		//.//*[@id='ext-gen310']/tbody/tr[2]/td/table ----inner table xpath
		//id="ext-gen310"----outer table xpath
		//Current Date xpath//*[@title='Today']/a/em/span
		//current date value---- //*[@title='Today']//text()
		//current month and year ----.//button[@id='ext-gen272']//text()
		
		WebElement FromDt=driver.findElement(By.name("startDate"));
		enterText(FromDt,LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy")),"From Date");
		validateTextBoxContent(FromDt,LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy")),"From Date");
		
		
		WebElement ToDateImg=driver.findElement(By.xpath(".//*[@id='ext-gen154']"));
		clickObject(ToDateImg, "To Date Field");
		
		WebElement ToDt=driver.findElement(By.name("endDate"));
		enterText(ToDt,LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy")),"To Date");
		validateTextBoxContent(ToDt,LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yyyy")),"To Date");
		
		WebElement btnSave=driver.findElement(By.id("ext-gen49"));
		clickObject(btnSave, "Save Button");
		
//		Alert alert=driver.switchTo().alert();
//		alert.sendKeys("Sales1");
//		alert.accept();
		Thread.sleep(4000);
		WebElement reportName=driver.findElement(By.id("saveReportDlg_reportNameField"));
		enterText(reportName, "Sales"+LocalDate.now(), "Report Name");
		validateTextBoxContent(reportName, "Sales"+LocalDate.now(), "Report Name");
		
		WebElement reportUnName=driver.findElement(By.id("saveReportDlg_DeveloperName"));
		enterText(reportUnName, "SalesUniqueReport"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("Mdyyyy_HHmmss")), "Report Unique Name");
		validateTextBoxContent(reportUnName, "SalesUniqueReport"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("Mdyyyy_HHmmss")), "Report Unique Name");
		String strRepName=reportName.getAttribute("value");
		System.out.println("report name"+strRepName);
//		WebElement reportDesc=driver.findElement(By.xpath(".//*[@id='ext-comp-1067']"));
//		enterText(reportDesc, "Sales Description", "Report Description");
//		validateTextBoxContent(reportDesc, "Sales Description", "Report Description");
		
		
		//WebElement btnSave1=driver.findElement(By.cssSelector("#ext-gen280"));
		//WebElement btnSave1=driver.findElement(By.xpath(".//*[contains(text(),'Save and Run Report')]"));
		//WebElement btnSave1=driver.findElement(By.xpath("//*[starts-with(@id,'ext-gen')]"));//*[starts-with(@id,'')]
		//WebElement btnSave1=(new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(),'Save and Run Report')]"))));
		//WebElement btnSave1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(),'Save and Run Report')]")));
		Thread.sleep(8000);
		//WebElement btnSave1=driver.findElement(By.className("x-btn-text"));
		WebElement btnSave1=driver.findElement(By.xpath("//button[text()='Save and Run Report']"));
		Thread.sleep(8000);
		System.out.println("Before save click");
		btnSave1.click();
		System.out.println("save button clicked");
		//Thread.sleep(5000);
		//clickObject(btnSave1, "Save and Run Report Button");
//		if (btnSave1.isEnabled()){
//			//Thread.sleep(2000);
//			//clickObject(btnSave1, "Save and Run Report Button");
//			btnSave1.click();
//		}

		Thread.sleep(5000);
		WebElement reportHeader=driver.findElement(By.xpath(".//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1"));
		if(reportHeader.getText().equalsIgnoreCase("Sales13"))
			System.out.println("The report name is matching");
		else
			System.out.println("The report name is not matching");	
		driver.close();
		System.out.println("Browser closed..");
		
	}
	public static void TC15(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabOpp=driver.findElement(By.id("Opportunity_Tab"));
		clickObject(tabOpp,"Opportunities Tab");
		Thread.sleep(3000);
		ReusableMethods.closePopup();
		WebElement comboFCF=driver.findElement(By.id("fcf"));
		clickObject(comboFCF, "view combo");
		Thread.sleep(5000);
		
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void TC16(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabOpp=driver.findElement(By.id("Opportunity_Tab"));
		clickObject(tabOpp,"Opportunities Tab");
		Thread.sleep(3000);
		ReusableMethods.closePopup();
		WebElement tabNew=driver.findElement(By.name("new"));
		clickObject(tabNew,"New Opportunities Button");
		WebElement OpName=driver.findElement(By.id("opp3"));
		enterText(OpName, "Cashier", "");
		validateTextBoxContent(OpName, "Cashier","");
		WebElement AccName=driver.findElement(By.id("opp4"));
		enterText(AccName, "Bank", "Accoount Name");
		validateTextBoxContent(AccName, "Bank","Accoount Name");
		WebElement closeDate=driver.findElement(By.id("opp9"));
		enterText(closeDate, LocalDate.now().toString(), "Close Date");
		validateTextBoxContent(closeDate, LocalDate.now().toString(),"Close Date");
		WebElement Stage=driver.findElement(By.id("opp11"));
		Select selStage=new Select(Stage);
		selStage.selectByIndex(0);
		WebElement Probability=driver.findElement(By.id("opp12"));
		enterText(Probability, "2", "Probability");
		validateTextBoxContent(Probability, "2","Probability");
		WebElement LeadSource=driver.findElement(By.id("opp6"));
		Select selLeadSource=new Select(LeadSource);
		selLeadSource.selectByIndex(0);
		WebElement Campaign=driver.findElement(By.id("opp17"));
		enterText(Campaign, "", "Primary Campaign Source");
		validateTextBoxContent(Campaign, "","Primary Campaign Source");
		WebElement btnSave=driver.findElement(By.name("save"));
		
		driver.close();
		System.out.println("Browser closed..");
		
	}
	public static void TC17(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabOpp=driver.findElement(By.id("Opportunity_Tab"));
		clickObject(tabOpp,"Opportunities Tab");
		Thread.sleep(3000);
		ReusableMethods.closePopup();
		WebElement linkPipe=driver.findElement(By.linkText("Opportunity Pipeline"));
		clickObject(linkPipe,"Opportunity Pipeline Link");
		checkWindowTitle("Pipeline");
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void TC18(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabOpp=driver.findElement(By.id("Opportunity_Tab"));
		clickObject(tabOpp,"Opportunities Tab");
		Thread.sleep(3000);
		ReusableMethods.closePopup();
		WebElement linkStuck=driver.findElement(By.linkText("Stuck Opportunities"));
		clickObject(linkStuck,"Stuck Opportunities Link");
		checkWindowTitle("Stuck");
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed..");
	}
	//Current FQ,Next FQ and Include such as All,Open or closed Opportunities
	public static void TC19(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		
		WebElement tabOpp=driver.findElement(By.id("Opportunity_Tab"));
		clickObject(tabOpp,"Opportunities Tab");
		Thread.sleep(3000);
		ReusableMethods.closePopup();
		WebElement quarter=driver.findElement(By.id("quarter_q"));
		Select selQuarter=new Select(quarter);
		selQuarter.selectByIndex(0);
		WebElement include=driver.findElement(By.id("open"));
		Select selInclude=new Select(include);
		selQuarter.selectByIndex(0);
		WebElement btnReport=driver.findElement(By.name("go"));
		clickObject(btnReport, "Run Report");
		checkWindowTitle("Report");
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed..");
	}
	public static void leadsTab(String BrowserNM) throws InterruptedException, AWTException {
		driver=ReusableMethods.launchBrowser(BrowserNM);
		LoginSalesForce();//Logging into salesforce
		checkWindowTitle("Salesforce");
		WebElement tabOpp=driver.findElement(By.id("Lead_Tab"));
		clickObject(tabOpp,"Leads Tab");
		ReusableMethods.closePopup();
		Thread.sleep(3000);
		checkWindowTitle("Leads");
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed..");
	}
		
	//Logging into sales force
	public static void LoginSalesForce() throws InterruptedException {
		/*Launch URL*/
		driver.get("https://login.salesforce.com");
		System.out.println("Salesforce application is launched");

		/*Enter UN in user name field..*/
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		enterText(un, "sang.lakh@Gmail.com", "UserName");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(un, "sang.lakh@gmail.com", "UserName");

		/*Enter PWD in password field..*/
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(pwd, "admin2018", "Password");
		/*Check user name is displayed in user name field*/
		validateTextBoxContent(pwd, "admin2018", "Password");

		/*Click login button*/
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObject(loginButton, "Login Button");
		Thread.sleep(5000);
		
	}
}

