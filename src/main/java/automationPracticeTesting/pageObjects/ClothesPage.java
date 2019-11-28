package automationPracticeTesting.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClothesPage {
	
private WebDriver driver;
	
	public ClothesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getWomenBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 10);
	}
	
	public WebElement getDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 10);
	}
	
	public WebElement getTShirtsBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 10);
	}
	
	public WebElement getDressesDropDown() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), 10);
	}
	
	public WebElement getCasualDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), 10);
	}
	
	public WebElement getEveningDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), 10);
	}
	
	public WebElement getSummerDressesBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 10);
	}
	
	/**@param dressNum (value 1) */
	public WebElement getCasualDressProduct(int dressNum) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 10);	
	}
	
	/**@param dressNum (value 1) */
	public WebElement getEveningDressProduct(int dressNum) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 10);	
	}
	
	/**@param dressNum (values from 1 to 3) */
	public WebElement getSummerDressProduct(int dressNum) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 10);	
	}
	
	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
	
	}
}