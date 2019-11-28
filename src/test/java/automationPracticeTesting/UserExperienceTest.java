package automationPracticeTesting;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationPracticeTesting.pageObjects.AccountPage;
import automationPracticeTesting.pageObjects.CartFunctions;
import automationPracticeTesting.pageObjects.CartPage;
import automationPracticeTesting.pageObjects.ClothesPage;
import automationPracticeTesting.pageObjects.CreateAccountFormPage;
import automationPracticeTesting.pageObjects.CreateAccountPage;
import automationPracticeTesting.pageObjects.ShoppingPage;
import automationPracticeTesting.pageObjects.SignFormPage;



public class UserExperienceTest {

	private WebDriver driver;
	private Actions action;
	private ClothesPage clothes;
	private CartPage cart;
	private ShoppingPage shoppingActions;
	private CartFunctions summary;
	private SignFormPage signForm;
	private AccountPage account;
	private CreateAccountPage createAccount;
	private CreateAccountFormPage createAccountForm;

	
	@Parameters("browserSelect")
	
	@BeforeClass
	public void setup(String browserSelect) {
		
		try {
		
			if(browserSelect.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");	
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize(); 
			
			  }else if (browserSelect.equalsIgnoreCase("chrome")) { 
			 
				  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				  driver = new ChromeDriver();
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				
			  }
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
			}
		
		
		action = new Actions(driver);
		clothes = new ClothesPage(driver);
		cart = new CartPage(driver);
		shoppingActions = new ShoppingPage(driver);
		
		createAccount = new CreateAccountPage(driver);
		createAccountForm = new CreateAccountFormPage(driver);
		signForm = new SignFormPage(driver);
		summary = new CartFunctions(driver);
		account = new AccountPage(driver);

		String url = "http://automationpractice.com/index.php";
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void tearDown() {
		account.getAccountLogout().click();
		driver.quit();
	}

	@Test(priority = 1)
	public void selectProduct() {
		
		Assert.assertTrue(clothes.getDressesBtn().isDisplayed());

		action.moveToElement(clothes.getDressesBtn()).perform();

		Assert.assertTrue(clothes.getSummerDressesBtn().isDisplayed());
		Assert.assertTrue(clothes.getCasualDressesBtn().isDisplayed());
		Assert.assertTrue(clothes.getEveningDressesBtn().isDisplayed());

		action.moveToElement(clothes.getSummerDressesBtn()).perform();
		clothes.getSummerDressesBtn().click();

		Assert.assertTrue(clothes.getSummerDressProduct(1).isDisplayed());
		Assert.assertTrue(clothes.getSummerDressProduct(2).isDisplayed());
		Assert.assertTrue(clothes.getSummerDressProduct(3).isDisplayed());
		Assert.assertEquals(clothes.getDressesCount().size(), 3);
		
	}

	@Test(priority = 2)
	public void addProductToCart() {
		
		JavascriptExecutor PageDown = (JavascriptExecutor) driver;
		PageDown.executeScript("window.scrollBy(0,500)", "");
		
		action.moveToElement(clothes.getSummerDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartBtn()).perform();

		Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());

		action.click(shoppingActions.getAddToCartBtn()).build().perform();
		action.click(shoppingActions.getContinueShopingBtn()).build().perform();

		Assert.assertTrue(shoppingActions.getContinueShopingBtn().isDisplayed());
		
		JavascriptExecutor PageUp = (JavascriptExecutor) driver;
		PageUp.executeScript("window.scrollBy(0,-500)", "");

		action.moveToElement(cart.getCartTab()).perform();

		Assert.assertEquals(cart.getCartProductsQty().size(), 1);
		
	}

	@Test(priority = 3)
	public void performCheckout() {
		
		action.moveToElement(cart.getCartTab()).perform();
		action.moveToElement(cart.getCartTabCheckOutBtn()).perform();

		Assert.assertTrue(cart.getCartTabCheckOutBtn().isDisplayed());

		action.click(cart.getCartTabCheckOutBtn()).build().perform();

	}

	@Test(priority = 4)
	public void cartContentsCheck() {
		
		Assert.assertTrue(summary.getCartSummaryTable().isDisplayed());
		Assert.assertEquals(summary.getCartSummTotalProductsNum().size(), 1);
		
		Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$28.98");
		Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$30.98");
		Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");
		
		summary.getCartProceedBtn().click();
		
	}

	@Test(priority = 5)
	public void clientRegistration() {
		
		Assert.assertTrue(createAccount.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountEmailField().isDisplayed());
		Assert.assertTrue(createAccount.getCreateAccountBtn().isDisplayed());
		Assert.assertTrue(signForm.getSignInForm().isDisplayed());
		
		String email = "mrfraga" + RandomStringUtils.randomNumeric(7) + "@email.com";
		createAccount.setCreateAccountEmailField(email);
		createAccount.getCreateAccountBtn().click();
		
		createAccountForm.setCustomerFirstNameField("M.");
		createAccountForm.setCustomerLastNameField("Fraga");
		createAccountForm.setCustomerEmailField(email);
		createAccountForm.setCustomerPasswordField("testing123");
		createAccountForm.selectCustomerDateOfBirthDay("10");
		createAccountForm.selectCustomerDateOfBirthMonth("11");
		createAccountForm.selectCustomerDateOfBirthYear("1999");
		createAccountForm.setAddressField("Some Street");
		createAccountForm.setCityField("Some City");
		createAccountForm.selectState("9");
		createAccountForm.setPostalCodeField("77777");
		createAccountForm.setHomePhoneField("00000");
		createAccountForm.setMobilePhoneField("99999");
		createAccountForm.setAddressAliasField("My Address");
		
		createAccountForm.getRegisterBtn().click();
		
	}

	@Test(priority = 6)
	public void addressContentCheck() {
		
		Assert.assertEquals(summary.getCartSummBillingAdressName().getText(), "M. Fraga");
		Assert.assertEquals(summary.getCartSummBillingAdressOne().getText(), "Some Street");
		Assert.assertEquals(summary.getCartSummBillingAdressCityState().getText(), "Some City, Florida 77777");
		Assert.assertEquals(summary.getCartSummBillingAdressCountry().getText(), "United States");
		Assert.assertEquals(summary.getCartSummBillingAdressHomePhone().getText(), "00000");
		Assert.assertEquals(summary.getCartSummBillingAdressMobile().getText(), "99999");
		
		summary.getCartProceedBtnTwo().click();
		
	}

	@Test(priority = 7)
	public void termsOfServiceCheck() {
		
		summary.getCartSummTermsOfServiceCheck().click();
		summary.getCartProceedBtnTwo().click();
		
	}

	@Test(priority = 8)
	public void shoppingPriceCheck() {
		
		Assert.assertTrue(summary.getCartSummaryTable().isDisplayed());
		Assert.assertEquals(summary.getCartSummTotalProductsNum().size(), 1);
		
		Assert.assertEquals(summary.getCartSummTotalProductsPrice().getText(), "$28.98");
		Assert.assertEquals(summary.getCartSummaryTotalPrice().getText(), "$30.98");
		Assert.assertEquals(summary.getCartSummTotalShipping().getText(), "$2.00");
		
	}

	@Test(priority = 9)
	public void payment() {
		
		summary.getCartSummPayByBankWire().click();
		Assert.assertEquals(summary.getCartSummPayByBankWireConfirm().getText(), "BANK-WIRE PAYMENT.");

		summary.getCartSummOtherPaymentMethods().click();
		
		summary.getCartSummPayByCheck().click();
		Assert.assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");
		
	}

	@Test(priority = 10)
	public void confirmOrder() {
		
		summary.getCartSummConfirmOrderBtn().click();

		Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");
		
	}
	
}