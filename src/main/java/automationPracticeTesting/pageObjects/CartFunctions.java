package automationPracticeTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartFunctions {
	
private WebDriver driver;
	
	public CartFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartSummaryTable() {
		return Utils.waitForElementPresence(driver, By.id("cart_summary"), 10);
	}
	
	public WebElement getCartSummUnitPrice(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price special-price\"]"), 10);
	}
	
	public WebElement getCartSummSpecialUnitPrice(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//span[@class=\"price\"]/span[@class=\"price special-price\"]"), 10);
	}
	
	public WebElement getCartSummQtyInput(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//input[@type=\"text\"]"), 10);
	}
	
	public void setCartSummQtyInput(int numOfProduct, String qty) {
		WebElement customerFirstNameField = this.getCartSummQtyInput(numOfProduct);
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(qty);
	}
	
	public WebElement getCartSummQtyMinus(int numOfProduct) {
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Subtract\"]"), 10);
	}
	
	public WebElement getCartSummQtyPlus(int numOfProduct) {
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//a[@title=\"Add\"]"), 10);
	}
	
	public WebElement getCartSummTotalPrice(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Total\"]/span[@class=\"price\"]"), 10);
	}
	
	public WebElement getCartSummDeleteBtn(int numOfProduct) {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@id=\"cart_summary\"]/tbody/tr[" + numOfProduct + "]//td[@data-title=\"Delete\"]"), 10);
	}
	
	public WebElement getCartSummTotalProductsPrice() {
		return Utils.waitForElementPresence(driver, By.id("total_product"), 10);
	}
	
	public WebElement getCartSummTotalShipping() {
		return Utils.waitForElementPresence(driver, By.id("total_shipping"), 10);
	}
	
	public WebElement getCartSummWithoutTax() {
		return Utils.waitForElementPresence(driver, By.id("total_price_without_tax"), 10);
	}
	
	public WebElement getCartSummaryTotalPrice() {
		return Utils.waitForElementPresence(driver, By.id("total_price"), 10);
	}
	
	public WebElement getCartEmptyMessage() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Your shopping cart is empty.\")]"), 10);
	}
	
	public WebElement getCartProceedBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"), 10);
	}
	
	public WebElement getCartProceedPreviousBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Previous\"]"), 10);
	}
	
	public WebElement getCartProceedBtnTwo() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"Proceed to checkout\")]"), 10);
	}
	
	public WebElement getCartSummBillingAdressName() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_firstname address_lastname\"]"), 10);
	}
	
	public WebElement getCartSummBillingAdressCompany() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_company\"]"), 10);
	}
	
	public WebElement getCartSummBillingAdressOne() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_address1 address_address2\"]"), 10);
	}	
	
	public WebElement getCartSummBillingAdressCityState() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_city address_state_name address_postcode\"]"), 10);
	}
	
	public WebElement getCartSummBillingAdressCountry() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_country_name\"]"), 10);
	}
	
	public WebElement getCartSummBillingAdressHomePhone() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone\"]"), 10);
	}
	
	public WebElement getCartSummBillingAdressMobile() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul[@id=\"address_invoice\"]/li[@class=\"address_phone_mobile\"]"), 10);
	}
	
	public WebElement getCartSummTermsOfServiceCheck() {
		return Utils.waitForElementPresence(driver, By.id("cgv"), 10);
	}
	
	public WebElement getCartSummTermsOfServiceDialog() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"You must agree to the terms of service before continuing.\")]"), 10);
	}
	
	public WebElement getCartSummTermsOfServiceDialogClose() {
		return Utils.waitForElementPresence(driver, By.xpath("//a[@class=\"fancybox-item fancybox-close\"]"), 10);
	}
	
	public WebElement getCartSummPayByBankWire() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by bank wire\"]"), 10);
	}
	
	public WebElement getCartSummPayByCheck() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Pay by check.\"]"), 10);
	}
	
	public WebElement getCartSummPayByBankWireConfirm() {
		return Utils.waitForElementPresence(driver, By.xpath("//h3[contains(text(), \"Bank-wire payment.\")]"), 10);
	}
	
	public WebElement getCartSummPayByCheckConfirm() {
		return Utils.waitForElementPresence(driver, By.xpath("//h3[contains(text(), \"Check payment\")]"), 10);
	}
	
	public WebElement getCartSummConfirmOrderBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@type=\"submit\"]/span[contains(text(), \"I confirm my order\")]"), 10);
	}
	
	public WebElement getCartSummOtherPaymentMethods() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=order&step=3\"]"), 10);
	}
	
	public WebElement getCartSummSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Your order on My Store is complete.\")]"), 10);
	}
	
	public List<WebElement> getCartSummTotalProductsNum() {
		return driver.findElements(By.xpath("//table[@id=\"cart_summary\"]/tbody/tr"));
	}

}
