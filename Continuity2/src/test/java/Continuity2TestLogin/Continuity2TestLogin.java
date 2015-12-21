package Continuity2TestLogin;

import java.io.File;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
*/



public class Continuity2TestLogin {
	
	public WebDriver driver;
    public String baseUrl = "http://192.168.3.154:403";
    public String expected = null;
    public String actual = null;
    
    
  @BeforeTest
    public void setUp() {
	  	System.out.println("Inside setUp()");
	//	This is driver version for 32
	// 	System.setProperty("webdriver.ie.driver","C:\\Users\\senthilkumar.p\\Desktop\\IEDriverServer.exe");
	  			
	  	
	  		
	 // 	System.setProperty("webdriver.ie.driver","C:\\Users\\senthilkumar.p\\IEDriverServer.exe");
	 // 	driver = new InternetExplorerDriver(); 
	  	
	  	
	  	/*
	  	File file =new File("C:/Users/senthilkumar.p/IEDriverServer.exe");
	  	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	  	WebDriver driver=new InternetExplorerDriver(); 
	  	*/
	  	
	  	
	  	
	  	System.setProperty("webdriver.ie.driver","C:\\Users\\senthilkumar.p\\Desktop\\IEDriverServer.exe");
	  	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings" , true);
        driver = new InternetExplorerDriver(capabilities); 
       

	    driver.get(baseUrl);
	    System.out.println("Inside setUp()");
  }
      
  @Test
  public void tC1LoginSuccess() {
	 
	  	System.out.println("Inside tC1LoginSuccess()");
		  WebElement userName=driver.findElement(By.id("userName"));
		  userName.sendKeys("senthilc2");
		        		
		  WebElement passWord=driver.findElement(By.id("password"));
		  passWord.sendKeys("Heather1905");
		  
		  driver.findElement(By.id("logInButton")).click();
		  expected = "Admin";
		  actual=driver.getTitle();
		  Assert.assertEquals(actual, expected);
				  
		  
		  driver.close();
		  driver.quit();
	  
  }
  	    
}


