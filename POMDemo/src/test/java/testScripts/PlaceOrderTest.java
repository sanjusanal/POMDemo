package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.ProductListPage;
import pages.CartPage;
import pages.CheckoutPage;

public class PlaceOrderTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckoutPage ckPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver= TestBase.getDriver();
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		ckPage = new CheckoutPage(driver);
	}
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
		loginPage.loginIntoApp("standard_user", "secret_sauce");
	}
	@Test(priority = 1)
	
    public void validLogin() {
			Assert.assertTrue(listPage.isOnProducts());
		}
	@Test(priority = 2)
	
	public void addItem() {
		listPage.addToCart();
		listPage.viewCart();
		Assert.assertTrue(cartPage.isItemAdded());
	}
	@Test(priority = 3)
	public void removeItem() {
		cartPage.remove();
	}
	@Test(priority = 4)
	public void checkoutTest() {
		cartPage.checkoutItems();
		
	}
	@Test(priority = 5)
	public void information() {
		ckPage.information("Sanju", "Sanal", "123345");
		Assert.assertTrue(ckPage.isOrderSuccess());
		
	}
	
	
	

}
