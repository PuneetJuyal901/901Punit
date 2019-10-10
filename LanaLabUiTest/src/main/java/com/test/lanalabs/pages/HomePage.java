package com.test.lanalabs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.LocalBrowserInitialzation;
import com.framework.helper.ActionHelper;
import com.framework.helper.JavaScriptHelper;
import com.framework.helper.WaitHelper;

public class HomePage {

	public HomePage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);

	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Choose a log')]")
	private WebElement landingPagePopUpHeader;

	@FindBy(how = How.ID, using = "mat-radio-2")
	private WebElement landingPagePopUpRadioButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Use selected')]")
	private WebElement landingPagePopUserSlectedButton;

	@FindBy(how = How.CSS, using = "a[class='introjs-button introjs-skipbutton']")
	private WebElement landingPageModeViewNextButton;

	@FindBy(how = How.ID, using = "addFilterMenuButton")
	private WebElement landingPageHorizontalBars;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Filter attributes')]")
	private WebElement landingPageFilterAttribute;

	@FindBy(how = How.CSS, using = "#mat-input-1")
	private WebElement filterAttriutbuteSerachFieldPopUp;

	@FindBy(how = How.XPATH, using = "//*[@id='mat-checkbox-6']//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	private WebElement filterAttriutbutePopUpCountryCheckBox;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	private WebElement filterAttriutbutePopUpSaveButton;

	@FindBy(how = How.XPATH, using = "//categorical-attribute-filter[1]//mat-card[1]//mat-card-header[1]")
	private WebElement FilterChartFirstHeaderValue;

	@FindBy(how = How.CSS, using = "app-shell.ng-star-inserted:nth-child(2) mat-sidenav-container.mat-drawer-container.mat-sidenav-container mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) div.content-wrapper:nth-child(2) div.filter-bar div.filter-container div.numeric-attribute-filter:nth-child(6) categorical-attribute-filter.ng-star-inserted mat-card.filter-card.mat-card mat-card-content.filter-card-content.mat-card-content div.chart-div.ng-star-inserted div.pie-div svg:nth-child(1) g:nth-child(1) > path:nth-child(2)")
	private WebElement firstSegmentOnPieChart;

	@FindBy(how = How.CSS, using = "app-shell.ng-star-inserted:nth-child(2) mat-sidenav-container.mat-drawer-container.mat-sidenav-container mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) div.content-wrapper:nth-child(2) div.filter-bar div.filter-container div.numeric-attribute-filter:nth-child(6) categorical-attribute-filter.ng-star-inserted mat-card.filter-card.mat-card mat-card-content.filter-card-content.mat-card-content div.chart-div.ng-star-inserted div.pie-div svg:nth-child(1) g:nth-child(1) > path")
	private List<WebElement> getAllSegmentPieChart;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'attrFilter-tooltip')]")
	private WebElement pieChartToolTip;

	@FindBy(how = How.XPATH, using = "//span[@class='ng-star-inserted']")
	private WebElement topRightCaseCountHeader;
	

	public String getLandingPagePopUpText() {

		WaitHelper.isvisible(landingPagePopUpHeader, LocalBrowserInitialzation.driver);
		return landingPagePopUpHeader.getText();
	}

	public HomePage clickOnLandingPagePopUpRadioButton() {
		WaitHelper.isClickable(landingPagePopUpRadioButton, LocalBrowserInitialzation.driver);
		this.landingPagePopUpRadioButton.click();
		return new HomePage(LocalBrowserInitialzation.driver);

	}

	public HomePage clickOnLandingPagePopUpSelectedButton() {
		WaitHelper.isClickable(landingPagePopUserSlectedButton, LocalBrowserInitialzation.driver);
		this.landingPagePopUserSlectedButton.click();
		return new HomePage(LocalBrowserInitialzation.driver);

	}

	public HomePage clickOnModalViewPopUp() {

		WaitHelper.isClickable(landingPageModeViewNextButton, LocalBrowserInitialzation.driver);
		this.landingPageModeViewNextButton.click();
		return new HomePage(LocalBrowserInitialzation.driver);

	}

	public HomePage clickOnLandingPageHorizontalBars() throws InterruptedException {
		Thread.sleep(3000);
		WaitHelper.isvisible(landingPageHorizontalBars, LocalBrowserInitialzation.driver);
		JavaScriptHelper.clickElement(landingPageHorizontalBars, LocalBrowserInitialzation.driver);
		return new HomePage(LocalBrowserInitialzation.driver);

	}

	public HomePage clickOnFilterAttribute() {
		WaitHelper.isvisible(landingPageFilterAttribute, LocalBrowserInitialzation.driver);
		JavaScriptHelper.clickElement(landingPageFilterAttribute, LocalBrowserInitialzation.driver);
		return new HomePage(LocalBrowserInitialzation.driver);
	}

	public HomePage clickOnFilterAttributeSerachFieldPopUp(String textToSerach) throws InterruptedException {
		WaitHelper.isClickable(filterAttriutbuteSerachFieldPopUp, LocalBrowserInitialzation.driver);
		this.filterAttriutbuteSerachFieldPopUp.sendKeys(textToSerach);
		return new HomePage(LocalBrowserInitialzation.driver);
	}

	public HomePage clickOnFilterAttributePopUpCountryCheckBox() throws InterruptedException {

		WaitHelper.isClickable(filterAttriutbutePopUpCountryCheckBox, LocalBrowserInitialzation.driver);

		this.filterAttriutbutePopUpCountryCheckBox.click();
		return new HomePage(LocalBrowserInitialzation.driver);
	}

	public HomePage clickOnfilterAttriutbutePopUpSaveButton() throws InterruptedException {
		WaitHelper.isClickable(filterAttriutbutePopUpSaveButton, LocalBrowserInitialzation.driver);
		this.filterAttriutbutePopUpSaveButton.click();
		return new HomePage(LocalBrowserInitialzation.driver);
	}

	public String getCountryFilterChartHeaderValue() {
		WaitHelper.isClickable(FilterChartFirstHeaderValue, LocalBrowserInitialzation.driver);
		return FilterChartFirstHeaderValue.getText();
	}

	public boolean getTotalSegmentsInCountryPieChart() {
		if (getAllSegmentPieChart.size() > 0) {
			return true;
		} else
			return false;
	}

	public HomePage clickOnFirstSegment() {
		WaitHelper.isClickable(firstSegmentOnPieChart, LocalBrowserInitialzation.driver);
		this.firstSegmentOnPieChart.click();
		return new HomePage(LocalBrowserInitialzation.driver);

	}

	public String getCountCaseOfBlueSegmentToolTip() {
		WaitHelper.isvisible(pieChartToolTip, LocalBrowserInitialzation.driver);
		String[] segmentCountCase = this.pieChartToolTip.getText().split("\\s");
		return segmentCountCase[1];

	}

	public String caseCountOnTopRightToVerify() {
		WaitHelper.isvisible(topRightCaseCountHeader, LocalBrowserInitialzation.driver);
		String[] countCaseOfTopValue = this.topRightCaseCountHeader.getText().split("\\s");
		return countCaseOfTopValue[1];
	}
	
	public String getUrlOfTheLoginPage() {
		WaitHelper.isvisible(landingPagePopUserSlectedButton, LocalBrowserInitialzation.driver);
		return LocalBrowserInitialzation.driver.getCurrentUrl();
	
	}
	

}
