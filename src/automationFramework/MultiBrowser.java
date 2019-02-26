package automationFramework;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

public class MultiBrowser {

	public WebDriver driver;

  

  

  // Passing Browser parameter from TestNG xml
  @BeforeClass 
  @Parameters("brows")
  public void beforeTest(String browser) {

  // If the browser is Firefox, then do this

  if(browser.equalsIgnoreCase("firefox")) {
	 
	  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette",true);
	  driver = new FirefoxDriver(capabilities);
	 
  // If browser is IE, then do this	  

  }else if (browser.equalsIgnoreCase("ie")) { 

	  // Here I am setting up the path for my IEDriver

	  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Resources\\IEDriverServer.exe");
	  DesiredCapabilities capabilities = new DesiredCapabilities();   
	  capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
	  driver = new InternetExplorerDriver(capabilities);

  } else if (browser.equalsIgnoreCase("chrome")) { 

	  // Here I am setting up the path for my IEDriver

	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
	  DesiredCapabilities capabilities = new DesiredCapabilities();   
	  capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
	 
      driver = new ChromeDriver(capabilities);
 
  } 
  }

  // Once Before method is completed, Test method will start

  @Test 
  public void login()  {
	  driver.get("http://rcswhmsqatest.rcsoncloud.com:8080/RCS/login.jsf");
	 // driver.get("http://rcswhmsqatest.rcsoncloud.com:8080/RCS/login.jsf");
	  driver.getTitle();
	  Assert.assertEquals(driver.getTitle(), "Retail Classification System");
	}  
  
  @Test 
  public void logout()  {
	  driver.get("http://rcswhmsqatest.rcsoncloud.com:8080/RCS/login.jsf");
	 // driver.get("http://rcswhmsqatest.rcsoncloud.com:8080/RCS/login.jsf");
	  driver.getTitle();
	  Assert.assertEquals(driver.getTitle(), "Retail Classification System");
	}  
  
  @AfterClass 
  public void afterTest() {
		driver.quit();

	}

}
