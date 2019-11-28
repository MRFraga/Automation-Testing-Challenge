package automationPracticeTesting.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountFormPage {

private WebDriver driver;
	
	public CreateAccountFormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAccountCreationForm() {
		return Utils.waitForElementPresence(driver, By.id("account-creation_form"), 10);
	}
	
	public WebElement getCustomerTitleMr() {
		return Utils.waitToBeClickable(driver, By.id("uniform-id_gender1"), 10);
	}
	
	public WebElement getCustomerTitleMrs() {
		return Utils.waitToBeClickable(driver, By.id("uniform-id_gender2"), 10);
	}
	
	public WebElement getCustomerFirstNameField() {
		return Utils.waitForElementPresence(driver, By.id("customer_firstname"), 10);
	}
	
	public WebElement getCustomerLastNameField() {
		return Utils.waitForElementPresence(driver, By.id("customer_lastname"), 10);
	}
	
	public WebElement getCustomerEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email"), 10);
	}
	
	public WebElement getCustomerPasswordField() {
		return Utils.waitForElementPresence(driver, By.id("passwd"), 10);
	}
	
	public Select selectCustomerDateOfBirthDay() {
		WebElement dayOfBirth = Utils.waitForElementPresence(driver, By.id("days"), 10);
		return new Select(dayOfBirth);
	}
	
	public Select selectCustomerDateOfBirthMonth() {
		WebElement monthOfBirth = Utils.waitForElementPresence(driver, By.id("months"), 10);
		return new Select(monthOfBirth);
	}
	
	public Select selectCustomerDateOfBirthYear() {
		WebElement yearOfBirth = Utils.waitForElementPresence(driver, By.id("years"), 10);
		return new Select(yearOfBirth);
	}
	
	public WebElement getFirstNameField() {
		return Utils.waitForElementPresence(driver, By.id("firstname"), 10);
	}
	
	public WebElement getLastNameField() {
		return Utils.waitForElementPresence(driver, By.id("lastname"), 10);
	}
	
	public WebElement getCompanyField() {
		return Utils.waitForElementPresence(driver, By.id("company"), 10);
	}
	
	public WebElement getAddressField() {
		return Utils.waitForElementPresence(driver, By.id("address1"), 10);
	}
	
	public WebElement getAddressFieldTwo() {
		return Utils.waitForElementPresence(driver, By.name("address2"), 10);
	}
	
	public WebElement getCity() {
		return Utils.waitForElementPresence(driver, By.id("city"), 10);
	}

	public Select selectCountry() {
		WebElement country = Utils.waitForElementPresence(driver, By.id("id_country"), 10);
		return new Select(country);
	}
	

	public Select selectState() {
		WebElement state = Utils.waitForElementPresence(driver, By.id("id_state"), 10);
		return new Select(state);
	}
	
	public WebElement getPostalCodeField() {
		return Utils.waitForElementPresence(driver, By.id("postcode"), 10);
	}
	
	public WebElement getAdditionalInformationField() {
		return Utils.waitForElementPresence(driver, By.id("other"), 10);
	}
	
	public WebElement getHomePhoneField() {
		return Utils.waitForElementPresence(driver, By.id("phone"), 10);
	}
	
	public WebElement getMobilePhoneField() {
		return Utils.waitForElementPresence(driver, By.id("phone_mobile"), 10);
	}
	
	public WebElement getAddressAliasField() {
		return Utils.waitForElementPresence(driver, By.id("alias"), 10);
	}
	
	public WebElement getRegisterBtn() {
		return Utils.waitToBeClickable(driver, By.id("submitAccount"), 10);
	}
	
	public WebElement successfullyCreatedAccount() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 10);
	}

	
	
	/****** SETTERS ******/
	
	
	public void setCustomerTitleMr() {
		this.getCustomerTitleMr().click();
	}
	
	public void setCustomerTitleMrs() {
		this.getCustomerTitleMrs().click();
	}
	
	public void setCustomerFirstNameField(String firstName) {
		WebElement customerFirstNameField = this.getCustomerFirstNameField();
		customerFirstNameField.clear();
		customerFirstNameField.sendKeys(firstName);
	}
	
	public void setCustomerLastNameField(String lastName) {
		WebElement customerLastNameField = this.getCustomerLastNameField();
		customerLastNameField.clear();
		customerLastNameField.sendKeys(lastName);
	}
	
	public void setCustomerEmailField(String email) {
		WebElement customerEmailField = this.getCustomerEmailField();
		customerEmailField.clear();
		customerEmailField.sendKeys(email);
	}
	
	public void setCustomerPasswordField(String password) {
		WebElement customerPasswordField = this.getCustomerPasswordField();
		customerPasswordField.clear();
		customerPasswordField.sendKeys(password);
	}
	
	public void selectCustomerDateOfBirthDay(String day) {
		Select dayOfBirth = this.selectCustomerDateOfBirthDay();
		dayOfBirth.selectByValue(day);
	}
	
	public void selectCustomerDateOfBirthMonth(String month) {
		Select monthOfBirth = this.selectCustomerDateOfBirthMonth();
		monthOfBirth.selectByValue(month);
	}
	
	public void selectCustomerDateOfBirthYear(String year) {
		Select yearOfBirth = this.selectCustomerDateOfBirthYear();
		yearOfBirth.selectByValue(year);
	}
	
	public void setCompanyField(String company) {
		WebElement companyField = this.getCompanyField();
		companyField.clear();
		companyField.sendKeys(company);
	}
	
	public void setAddressField(String address) {
		WebElement addressField = this.getAddressField();
		addressField.clear();
		addressField.sendKeys(address);
	}
	
	public void setAddressFieldTwo(String addresTwo) {
		WebElement addresField = this.getAddressFieldTwo();
		addresField.clear();
		addresField.sendKeys(addresTwo);
	}
	
	public void setCityField(String city) {
		WebElement cityField = this.getCity();
		cityField.clear();
		cityField.sendKeys(city);
	}
	
	public void selectState(String state) {
		Select selectState = this.selectState();
		selectState.selectByValue(state);
	}
	
	public void setPostalCodeField(String zip) {
		WebElement postalCode = this.getPostalCodeField();
		postalCode.clear();
		postalCode.sendKeys(zip);
	}
	
	public void selectCountry(String country) {
		Select selectCountry = this.selectCountry();
		selectCountry.selectByVisibleText(country);
	}
	
	public void setAdditionalInfo(String info) {
		WebElement additionalInfo = this.getAdditionalInformationField();
		additionalInfo.clear();
		additionalInfo.sendKeys(info);
	}
	
	public void setHomePhoneField(String phone) {
		WebElement homePhone = this.getHomePhoneField();
		homePhone.clear();
		homePhone.sendKeys(phone);
	}
	
	public void setMobilePhoneField(String phone) {
		WebElement mobilePhone = this.getMobilePhoneField();
		mobilePhone.clear();
		mobilePhone.sendKeys(phone);
	}
	
	public void setAddressAliasField(String alias) {
		WebElement addressAlias = this.getAddressAliasField();
		addressAlias.clear();
		addressAlias.sendKeys(alias);
	}
	
	
	/****** ERRORS ******/
	
	
	public WebElement getErrorPanel() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"You must register\")]/../.."), 10);
	}
	
	public WebElement getPhoneNumberError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"You must register at least one phone number.\")]"), 10);
	}
	
	public WebElement getHomePhoneInvalidError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone\")]"), 10);
	}
	
	public WebElement getMobilePhoneInvalidError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone_mobile\")]"), 10);
	}
	
	public WebElement getLastNameError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"lastname\")]"), 10);
	}
	
	public WebElement getLastNameInvalidError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"lastname\")]"), 10);
	}
	
	public WebElement getFirstNameError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"firstname\")]"), 10);
	}
	
	public WebElement getFirstNameInvalidError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"firstname\")]"), 10);
	}
	
	public WebElement getEmailRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"lastname\")]"), 10);
	}
	
	public WebElement getEmailInvalidError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"email\")]"), 10);
	}
	
	public WebElement getEmailBeenRegistered() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this\")]"), 10);
	}
	
	public WebElement getPasswordRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"passwd\")]"), 10);
	}
	
	public WebElement getPasswordInvalidError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"passwd\")]"), 10);
	}
	
	public WebElement getCountryRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"id_country\")]"), 10);
	}
	
	public WebElement getAddressAliasRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"alias\")]"), 10);
	}
	
	public WebElement getAddressRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"address1\")]"), 10);
	}
	
	public WebElement getCityRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//b[contains(text(), \"city\")]"), 10);
	}
	
	public WebElement getCountryUnselectedError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Country is invalid\")]"), 10);
	}
	
	public WebElement getStateRequredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"This country requires you to choose a State.\")]"), 10);
	}
	
	public WebElement getPostalCodeError() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"The Zip/Postal code you\")]"), 10);
	}
	
	
	/****** HIGHLIGHTED ERRORS ******/
	
	
	public WebElement getFirstNameHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_firstname\"]"), 10);
	}
	
	public WebElement getFirstNameHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_firstname\"]"), 10);
	}
	
	public WebElement getLastNameHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_lastname\"]"), 10);
	}
	
	public WebElement getLastNameHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_lastname\"]"), 10);
	}
	
	public WebElement getEmailHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"email\"]"), 10);
	}
	
	public WebElement getEmailHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"email\"]"), 10);
	}
	
	public WebElement getPasswordHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required password form-group form-ok\"]//input[@id=\"passwd\"]"), 10);
	}
	
	public WebElement getPasswordHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"required password form-group form-error\"]//input[@id=\"passwd\"]"), 10);
	}
	
	
}
