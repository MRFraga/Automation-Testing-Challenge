package automationPracticeTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAccountBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"View my customer account\"]"), 10);
	}
	
	public WebElement getAccountLogout() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 10);
	}
	
	public WebElement getAccountOrderHistoryBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Order history and details\")]"), 10);
	}
	
	public WebElement getAccountOrderListTable() {
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"order-list\"]"), 10);
	}
	
	public List<WebElement> getAccountOrdersLis() {
		return driver.findElements(By.xpath("//table[@id=\"order-list\"]/tbody/tr"));
	}

}
