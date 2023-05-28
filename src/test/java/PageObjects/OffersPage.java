package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By searchinofferspage=By.xpath("//input[@type='search']");
	By productnameinOfferspage=By.cssSelector("tr td:nth-child(1)");
	
	
	
	public void searchItem(String name)
	{
		driver.findElement(searchinofferspage).sendKeys(name);;
	}
	
	public String getProductNameinOfferPage()
	{
		return driver.findElement(productnameinOfferspage).getText();
	}

}
