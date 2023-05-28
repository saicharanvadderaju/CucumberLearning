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

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.OffersPage;
import Utils.TestBase;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingpageproductname;
	public CheckoutPage checkoutpage;
	public OffersPage offerspage;;

	TestContextSetup testcontextsetup;

	public CheckoutPageStepDefinition(TestContextSetup testcontextsetup) {

		this.testcontextsetup = testcontextsetup;
		this.checkoutpage = testcontextsetup.pageObjectManager.getCheckoutPage();
		this.offerspage=testcontextsetup.pageObjectManager.getOffersPage();
	}

	@Then("^user proceeds to checkout and validate (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_tom_items_in_checkout_page(String name) throws Exception {
		checkoutpage.checkoutItems();
		
		
		String ProductinProductTable=checkoutpage.getProductNameInProductTable().substring(0,3);
		
		Assert.assertEquals(name, ProductinProductTable);
	}

	@Then("verify user has the ability to apply promocode and place the order")
	public void verify_user_has_the_ability_to_apply_promocode_and_place_the_order() {

	
		Assert.assertTrue(checkoutpage.verifyPromoBtn());
		Assert.assertTrue(checkoutpage.verifyPlaceOrderBtn());
		
		

	}

}
