package DemoA.Log4JDemo;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ReportGenerationTest {

	public String baseUrl = "https://en-gb.facebook.com/";
    String driverPath = "/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver1/chromedriver.exe";
    public WebDriver driver ;
    
    @BeforeTest
    public void launchBrowser() {
        Reporter.log("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void verifyTitle() {
    	String expectedURL = "Facebook – log in or sign up";
        String actualURL = driver.getTitle();
        Assert.assertEquals(actualURL, expectedURL);
        Reporter.log("tite is verified");
    }
    
    @Test
    public void verifyFirstNameField() {
  	  driver.findElement(By.id("email")).sendKeys("Kalpesh");
  	  Reporter.log("first name is verified");
    }
    
    @AfterTest
    public void closeBrowser()
    {
    	driver.close();
    }
  }
