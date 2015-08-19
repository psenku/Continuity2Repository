package lmsdemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import VRS.DemoLMS.ReadExcel;

public class LMSTest extends TestListenerAdapter
{
    protected WebDriver driver;

 
    @BeforeTest(alwaysRun=true)
    public void setUp()
    {
    	
    	
        //driver = new HtmlUnitDriver();
    	try {
        System.out.println("Inside set up....");
        
       // driver = new FirefoxDriver();
      /*
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatragavan\\git\\ltc\\LTC\\drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    	driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    */
        System.out.println("After creating the driver..");
        System.setProperty("webdriver.ie.driver", "C:\\Users\\venkatragavan\\git\\ltc\\LTC\\drivers\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
    	//DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
    	
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    	capabilities.setCapability("ignoreZoomSetting", true);
    	capabilities.setCapability("ignoreProtectedModeSettings" , true);
    	//driver = new FirefoxDriver();
    	driver = new InternetExplorerDriver(capabilities);
    	driver.get("http://192.168.3.16:201/Login.aspx");
    	//List <WebElement> elements = driver.findElements(By.cssSelector("*"));
    	/*
    	ReadExcel.setExcelFile("C:\\Users\\venkatragavan\\git\\lms\\DemoLMS\\testdata\\tdata.xls", "login");
    	System.out.println("before reading xcel");
    	ReadExcel.getCellData(1,0);
    	ReadExcel.getCellData(1,1);
    	*/
    	WebElement usrNameTxt = driver.findElement(By.id("txtUsername"));
    	//WebElement usrNameTxt = driver.findElement(By.xpath("//input[contains(@id,'txtUserName')]"));
    	usrNameTxt.clear();
    	usrNameTxt.sendKeys("vasanthica");
    	WebElement pwdTxt = driver.findElement(By.id("txtPassword"));
    	pwdTxt.clear();
    	pwdTxt.sendKeys("dsrc1234");
    	WebElement btnSignIn = driver.findElement(By.id("btnSignIn"));
    	btnSignIn.click();
    	Thread.sleep(4000);
    	
    	//ReadExcel.setCellData("C:\\Users\\venkatragavan\\git\\lms\\DemoLMS\\testdata\\tdata.xls", "FAIL",1,2);
    	//reading cell values from table
    	WebElement table = driver.findElement(By.id("ctl00_tblcphKlassAktLMS"));
    	List<WebElement> tableRows = table.findElements(By.tagName("tr"));
    	System.out.println("List size : " + tableRows.size());
    	
    	for (WebElement row : tableRows) {
    		
    		List<WebElement> cells = row.findElements(By.tagName("td"));
    		
    		for (WebElement cell : cells) {
    			//System.out.println("Cell value : " + cell.getText() + "Cell class : " + cell.getClass() + "Cell tag : " + cell.getTagName());
    			System.out.println("Cell value : " + cell.getText());
    			if (cell.getText().equalsIgnoreCase("Dabbawala")) {
    				System.out.println("Found..added by Veenu");
    				break;
    			}
    		}
    	}
    	
    	
  /*  	
    	WebElement table = driver.findElement(By.id("ctl00_tblcphKlassAktLMS"));
    	List <WebElement> noOfRows = table.findElements(By.tagName("tr"));
    	System.out.println("No. of rows : " + noOfRows.size());
    	
    	int numOfCol = driver.findElements(By.xpath("//*[@id='ctl00_tblcphKlassAktLMS']/tbody/tr[1]/td")).size();
    	System.out.println("No. of columns : " + numOfCol);
    	
    	List <WebElement> columnNames = driver.findElements(By.xpath("//*[@id='ctl00_tblcphKlassAktLMS']/tbody/tr[1]/td"));
    	for (WebElement columnName : columnNames) {
    	
    		System.out.println("Column Name : " + columnName.getText());
    	}
    */
    	/*
    	List<WebElement> tdlist = driver.findElements(By.cssSelector("table[id='ctl00_tblcphKlassAktLMS'] tr td"));
    	
    	System.out.println("No. of CSS : " + tdlist.size());
    	
    	for (WebElement el: tdlist) {
    		System.out.println(el.getText());
    	}
    	*/
    	/*
    	//WebElement ele1 = driver.findElement(By.id("ctl00_RoleBased_AdminRole"));
    	WebElement mainMenu = driver.findElement(By.partialLinkText("Admin"));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(mainMenu).click().perform();
    	Thread.sleep(2000);
    	WebElement subMenu = driver.findElement(By.partialLinkText("Manage users"));
    	builder.moveToElement(subMenu).click().perform();
    	Thread.sleep(4000);
    	WebElement subMenu2 = driver.findElement(By.partialLinkText("Manage batches"));
    	builder.moveToElement(subMenu2).click().perform();
    	Thread.sleep(4000);
    	
    	WebDriverWait wait = new WebDriverWait(driver,120);
    	
    	
    	
    	Select sel1 = new Select(driver.findElement(By.id("ctl00_cphKlassAktLMS_acPane1_content_SearchPanel_ddlCategory")));
    
    	//sel1.selectByVisibleText("Business");
    	List oSize = sel1.getOptions();
    	int listSize = oSize.size();
    	System.out.println("Select size : " + listSize);
    	
    	for (int i =0;i<listSize;i++) {
    		
    		String sValue = sel1.getOptions().get(i).getText();
    		System.out.println("Value in the list : " + sValue);
    	}
    	
    	sel1.selectByIndex(10);
    	*/
    	//List <WebElement> tableEleList = driver.findElements(By.xpath("//*[@id='ctl00_tblcphKlassAktLMS']"));
    	
    	//txtUsername
    	//txtPassword
    	//btnSignIn
    	}
    	catch (Exception e) {
    		System.out.println("Inside exception catch block..");
    		e.printStackTrace();
    	}
       
    }

@Test(groups={"smoke"})
    public void addCourse() throws Exception {
  	  
 	  try {
 		
 		  Thread.sleep(2000);
 		  
 		  String currURL = driver.getCurrentUrl();
 		  String currPageTitle = driver.getTitle();
 		  String currWinHandle = driver.getWindowHandle();
 		  System.out.println("Current URL : " + currURL + " "+ "Current Page Title : "+currPageTitle+" " + "Current Window Handle.. : " + currWinHandle);
 		 
 	} catch (Exception e) {
 		// TODO Auto-generated catch block
 		System.out.println("Current URL : ");
 		e.printStackTrace();
 	}
 	  
    }

@Test(groups={"windows.regression"})
public void updateCourse() throws Exception {
	  
	  try {
		
		  Thread.sleep(2000);
		  System.out.println("Update Course..");
		    Assert.assertTrue(false);
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
}

@Test(groups={"linux.regression"})
public void deleteCourse() throws Exception {
	  
	  try {
		
		  Thread.sleep(2000);
		  System.out.println("Delete Course..");
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
}


@AfterTest(alwaysRun=true)
public void tearDown()    {
    	
		System.out.println("Inside after test..");
        driver.close();
        driver.quit();
}

  
 }

