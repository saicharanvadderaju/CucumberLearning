package Utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToWindow() {

		Set<String> S1 = driver.getWindowHandles();

		Iterator<String> i1 = S1.iterator();
		String parentwindow = i1.next();
		String childwindow = i1.next();

		driver.switchTo().window(childwindow);
	}
	
	public void waitForVisibilityofElement()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr td:nth-child(1)")));
	}

}
