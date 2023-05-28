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
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OfferPageStepDefinition {

	public String offerpageproductname;
	TestContextSetup testcontextsetup;
	
	
	public OfferPageStepDefinition(TestContextSetup testcontextsetup)
	{
		
		this.testcontextsetup=testcontextsetup;
	}
	
	public void switchToOfferPage()
	{
	
		 LandingPage landingpage=testcontextsetup.pageObjectManager.getLandingpage();
         landingpage.clickTopDeals();
         testcontextsetup.genericUtils.switchToWindow();
		
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_the_product_exists(String ShortName) {
	  
		switchToOfferPage();
		
		OffersPage offerspage=testcontextsetup.pageObjectManager.getOffersPage();
		offerspage.searchItem(ShortName);
		
		testcontextsetup.genericUtils.waitForVisibilityofElement();
		
		 offerpageproductname=offerspage.getProductNameinOfferPage();
		 
		 System.out.println(offerpageproductname + "is the offerpage productname");
			
	}
	
	@And("validate productname in offerspage matches with landing page")
	public void validate_productname_in_offerspage_matches_with_landing_page()
	{
		Assert.assertEquals(testcontextsetup.landingpageproductname, offerpageproductname);
	}

}
