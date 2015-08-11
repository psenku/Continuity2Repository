package lmsdemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
        System.out.println("After creating the driver..");
        System.setProperty("webdriver.ie.driver", "C:\\Users\\venkatragavan\\git\\ltc\\LTC\\drivers\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    	capabilities.setCapability("ignoreZoomSetting", true);
    	capabilities.setCapability("ignoreProtectedModeSettings" , true);
    	driver = new InternetExplorerDriver(capabilities);
    	driver.get("http://192.168.3.16:201/Login.aspx");
    	WebElement usrNameTxt = driver.findElement(By.id("txtUsername"));
    	usrNameTxt.clear();
    	usrNameTxt.sendKeys("vasanthica");
    	WebElement pwdTxt = driver.findElement(By.id("txtPassword"));
    	pwdTxt.clear();
    	pwdTxt.sendKeys("dsrc1234");
    	WebElement btnSignIn = driver.findElement(By.id("btnSignIn"));
    	btnSignIn.click();
    	
    	//txtUsername
    	//txtPassword
    	//btnSignIn
    	}
    	catch (Exception e) {
    		System.out.println("Inside exception catch block");
    		e.printStackTrace();
    	}
        //driver = new ChromeDriver();
       /* 
        System.setProperty("webdriver.ie.driver", "C:\\Users\\venkatragavan\\git\\ltc\\LTC\\drivers\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    	capabilities.setCapability("ignoreZoomSetting", true);
    	capabilities.setCapability("ignoreProtectedModeSettings" , true);
    	driver = new InternetExplorerDriver(capabilities);
    	*/
    	driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
    }

@Test
    public void addCourse() throws Exception {
  	  
 	  try {
 		
 		  Thread.sleep(2000);
 		  String currURL = driver.getCurrentUrl();
 		  String currPageTitle = driver.getTitle();
 		  String currWinHandle = driver.getWindowHandle();
 		  System.out.println("Current URL : " + currURL + " "+ "Current Page Title : "+currPageTitle+" " + "Current Window Handle : " + currWinHandle);
 		  
 		  
 		  //
 			 //
 		  
 		 
  		 
 		 
 	} catch (Exception e) {
 		// TODO Auto-generated catch block
 		System.out.println("Current URL : ");
 		e.printStackTrace();
 	}
 	  
    }

    @AfterTest(alwaysRun = true)
    public void tearDown()
    {
    	System.out.println("Inside after test..");
        driver.close();
        driver.quit();
    }

  
 }
