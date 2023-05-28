package Utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;

	public WebDriver WebDriverManager() throws Exception {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAUrl");
		
		//Browser will be picked up from global properties file
		String browser_properties=prop.getProperty("browser");
		
		//Broswer will be picked up based on the browser we pass in maven command line
		String browser_maven=System.getProperty("browser");
		
		//Java Ternary condition to call broser based on the browser condition we select
		String browser=browser_maven!=null?browser_maven:browser_properties;
		
       
		if(driver==null)
		{
		if(browser.equalsIgnoreCase("chrome")) 
			{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
			
		if(browser.equalsIgnoreCase("firefox")) 
			{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
			
			
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		return driver;

	}
}
