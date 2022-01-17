package DemoA.Log4JDemo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jLogging 
{
    public static void main( String[] args )
    {
    	System.setProperty ("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver1/chromedriver.exe" );
    	WebDriver driver = new ChromeDriver(); 
    	
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    	
    	Logger log = Logger.getLogger(Log4jLogging.class);
    	
    	PropertyConfigurator.configure("C:\\Users\\kalpe\\eclipse-workspace\\Log4JDemo\\Resources\\log4j.properties");
    	
    	driver.get("https://en-gb.facebook.com/" );
    	log.debug("Open Website");
    	
    	driver.manage().window().maximize();
    	log.info("Maximize the window");
    	
    	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kalpesh");
    	log.warn("Entering Username");
    	
    	driver.findElement(By.id("pass")).sendKeys("kalpesh123");
    	log.fatal("Entering password");
    	
    	driver.findElement(By.xpath("//a[starts-with(@id,'u_0_2')]")).click();
    	log.error("Click on sign-in button");
    	
    	driver.close();
    	log.info("closing browser");
    }
}
