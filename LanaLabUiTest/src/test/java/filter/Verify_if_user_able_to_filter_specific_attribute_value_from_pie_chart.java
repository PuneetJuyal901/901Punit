package filter;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.base.JsonReader;
import com.framework.base.LocalBrowserInitialzation;
import com.framework.helper.AssertionHelper;
import com.test.lanalabs.base.TestBase;
import com.test.lanalabs.pages.LoginPage;
import com.test.lanalabs.pages.HomePage;

import bsh.ParseException;

public class Verify_if_user_able_to_filter_specific_attribute_value_from_pie_chart extends TestBase{
	
	@Test(priority=0,dataProvider="Testdata_For_Filter_Scenarios")
	public void verify_if_country_filter_is_applied(String userName,String password,String textInSerachField,String countryFilterText) throws InterruptedException {
		
		LoginPage homePage =new LoginPage(LocalBrowserInitialzation.driver);
		HomePage landingPage= new HomePage(LocalBrowserInitialzation.driver);
		
		homePage.userEnterEmailAndPassword(userName,password).clickOnSignButton().clickOnLandingPagePopUpRadioButton().
		clickOnLandingPagePopUpRadioButton().clickOnLandingPagePopUpSelectedButton().clickOnModalViewPopUp().clickOnLandingPageHorizontalBars()
		.clickOnFilterAttribute().clickOnFilterAttributeSerachFieldPopUp(textInSerachField).clickOnFilterAttributePopUpCountryCheckBox()
		.clickOnfilterAttriutbutePopUpSaveButton().clickOnFirstSegment();
		
			
		
		AssertionHelper.softAssertToCompareString(landingPage.getCountCaseOfBlueSegmentToolTip(),
				landingPage.caseCountOnTopRightToVerify(),
				"Segment case count not matching");		
		
		
}
	
	
	@DataProvider(name = "Testdata_For_Filter_Scenarios")
	public Object[][] passData() throws IOException, ParseException {
		return JsonReader.getdata(
				System.getProperty("user.dir") + "//TestData//"
						+ "//Test_Data_For_Tc_02_Verify_Filter_Scenario.json",
				"Test_Data_For_Filter_Scenarios", 1, 4);

	}
	
	


}



