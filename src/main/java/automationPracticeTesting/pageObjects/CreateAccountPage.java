package automationPracticeTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationPracticeTesting.pageObjects.Utils;

public class CreateAccountPage {
	
private WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return Utils.waitForElementPresence(driver, By.id("create-account_form"), 10);
	}
	
	public WebElement getCreateAccountEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email_create"), 10);
	}
	
	public WebElement getCreateAccountBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 10);
	}
	
	public void setCreateAccountEmailField(String email) {
		WebElement element = this.getCreateAccountEmailField();
		element.clear();
		element.sendKeys(email);
	}
	
	/****** ERRORS ******/
	
	public WebElement getEmailFieldHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]"), 10);
	}
	
	public WebElement getEmailFieldHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]"), 10);
	}
	
	public WebElement getEmailErrorMessage() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 10);
	}
	
	public WebElement getEmailBeenRegistered() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 10);
	}

}
