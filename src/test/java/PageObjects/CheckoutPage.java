package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By carticon=By.xpath("//img[@alt='Cart']");
	By Proceedtocheckoutbutton=By.xpath("//button[normalize-space(text())='PROCEED TO CHECKOUT']");
	By ApplyPromoButton=By.cssSelector("button.promoBtn");
    By PlaceOrderBUtton=By.xpath("//button[normalize-space(text())='Place Order']");
    By ProductTable=By.cssSelector("tbody tr td:nth-child(2)");
	
	public void checkoutItems()
	{
		
		driver.findElement(carticon).click();
		driver.findElement(Proceedtocheckoutbutton).click();
	}
	
	public boolean verifyPromoBtn()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ApplyPromoButton));
		
		return driver.findElement(ApplyPromoButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrderBtn()
	{
		return driver.findElement(PlaceOrderBUtton).isDisplayed();
	}
	
	public String getProductNameInProductTable() throws Exception
	{
		//Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTable));
		return driver.findElement(ProductTable).getText().split("-")[0].trim();
	}
	
}
