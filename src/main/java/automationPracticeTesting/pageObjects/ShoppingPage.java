package automationPracticeTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingPage {
	
private WebDriver driver;
	
	public ShoppingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAddToCartBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"), 10);
	}
	
	public WebElement getAddedToCartModal() {
		return Utils.waitForElementPresence(driver, By.id("layer_cart"), 10);
	}
	
	public WebElement getContinueShopingBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[@title=\"Continue shopping\"]"), 10);
	}
	
	public WebElement getProceedToCheckoutBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Proceed to checkout\")]"), 10);
	}
	
	public WebElement getSuccessfullyAddedMessage() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"), 10);

    }
}	
