package com.test.lanalabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.LocalBrowserInitialzation;
import com.framework.helper.WaitHelper;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//form[@name='cognitoSignInForm']//div//input[@placeholder='Email']")
	private WebElement emailField;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//form[@name='cognitoSignInForm']//div//input[@placeholder='Password']")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//input[@name='signInSubmitButton']")
	private WebElement signInSubmitButton;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//div[@class='modal-body']//div//div//div//div//p[@id='loginErrorMessage']")
	private WebElement loginErrorMessage;

	public LoginPage userEnterEmailAndPassword(String email, String password) {
		WaitHelper.isClickable(emailField, LocalBrowserInitialzation.driver);
		this.emailField.sendKeys(email);
		WaitHelper.isClickable(passwordField, LocalBrowserInitialzation.driver);
		this.passwordField.sendKeys(password);
		return new LoginPage(LocalBrowserInitialzation.driver);

	}

	public HomePage clickOnSignButton() {
		WaitHelper.isClickable(signInSubmitButton, LocalBrowserInitialzation.driver);
		this.signInSubmitButton.click();
		return new HomePage(LocalBrowserInitialzation.driver);

	}

	public String errorMessageWhileGivingInvalidDetails() {
		WaitHelper.isvisible(loginErrorMessage, LocalBrowserInitialzation.driver);
		return loginErrorMessage.getText();
	}
	

}