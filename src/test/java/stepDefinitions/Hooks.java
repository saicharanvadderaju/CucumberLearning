package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public TestContextSetup testcontextsteup;
	
	public Hooks(TestContextSetup testcontextsteup)
	{
		this.testcontextsteup=testcontextsteup;
	}
	
	@After
	public void tearDown() throws Exception
	{
		testcontextsteup.testbase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception
	{
	WebDriver driver=testcontextsteup.testbase.WebDriverManager();
		if(scenario.isFailed())
		{
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/png", "failed");
		}
	}
	

}
