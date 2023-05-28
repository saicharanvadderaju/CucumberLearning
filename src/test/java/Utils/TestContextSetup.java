package Utils;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingpageproductname;
	public PageObjectManager pageObjectManager;
	public TestBase testbase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws Exception
	{
		testbase=new TestBase();
		this.pageObjectManager=new PageObjectManager(testbase.WebDriverManager());
		this.genericUtils=new GenericUtils(testbase.WebDriverManager());
	}

}
