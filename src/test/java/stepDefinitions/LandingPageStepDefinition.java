package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LandingPage;
import Utils.TestBase;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingpageproductname;
    public LandingPage landingpage;
	TestContextSetup testcontextsetup;
	
	public LandingPageStepDefinition(TestContextSetup testcontextsetup)
	{
		
		this.testcontextsetup=testcontextsetup;
		this.landingpage=testcontextsetup.pageObjectManager.getLandingpage();
	}
	
	
	@Given("user is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() throws Exception {
		
	  Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
	}
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) {
		
		landingpage=testcontextsetup.pageObjectManager.getLandingpage();
		landingpage.searchItem(ShortName);
		
		testcontextsetup.landingpageproductname=landingpage.getProductName().split("-")[0].trim();
		System.out.println(testcontextsetup.landingpageproductname + "is the extracted productname");
	 
	}

	@And("added {string} items of the selected product to the cart")
	public void added_items_of_the_selected_product_to_the_cart(String Quantity) throws Exception {

		landingpage.incrementQuantity(Integer.parseInt(Quantity));
		landingpage.clickAddToCartBtn();
		
	}

}
