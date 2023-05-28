package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search=By.xpath("//input[@type='search']");
	By productname=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By increment=By.cssSelector("[class='increment']");
	By AddtoCart=By.xpath("//button[normalize-space(text())='ADD TO CART']");
	
	public void searchItem(String name)
	{
		
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productname));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(productname));
		
		return driver.findElement(productname).getText();
	}
	
	public void clickTopDeals()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	public void incrementQuantity(int Quantity) throws Exception
	{
		int i=Quantity-1;
		while(i>0)
		{
			
	     //Thread.sleep(1000);
			/*
			 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(70));
			 * wait.until(ExpectedConditions.presenceOfElementLocated(increment));
			 * 
			 * driver.findElement(increment).click();
			 */
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(increment));
			i--;
		}
	}
	
	public void clickAddToCartBtn()
	{
		driver.findElement(AddtoCart).click();
	}

}
