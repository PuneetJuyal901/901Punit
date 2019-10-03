package filter;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.base.JsonReader;
import com.framework.base.LocalBrowserInitialzation;
import com.framework.helper.AssertionHelper;
import com.test.lanalabs.base.TestBase;
import com.test.lanalabs.pages.HomePage;
import com.test.lanalabs.pages.LandingPage;

import bsh.ParseException;


public class Verify_If_Selected_Filter_Is_Applied extends TestBase{
	
	@Test(priority=0,dataProvider="Testdata_For_Filter_Scenarios")
	public void verify_if_country_filter_is_applied(String userName,String password,String textInSerachField,String countryFilterText) throws InterruptedException {
		
		HomePage homePage =new HomePage(LocalBrowserInitialzation.driver);
		LandingPage landingPage= new LandingPage(LocalBrowserInitialzation.driver);
		
		homePage.userEnterEmailAndPassword(userName,password).clickOnSignButton().clickOnLandingPagePopUpRadioButton().
		clickOnLandingPagePopUpRadioButton().clickOnLandingPagePopUpSelectedButton().clickOnModalViewPopUp().clickOnLandingPageHorizontalBars()
		.clickOnFilterAttribute().clickOnFilterAttributeSerachFieldPopUp(textInSerachField).clickOnFilterAttributePopUpCountryCheckBox()
		.clickOnfilterAttriutbutePopUpSaveButton();
		
		AssertionHelper.verifyTrue(landingPage.getTotalSegmentsInCountryPieChart());
		AssertionHelper.softAssertToCompareString(landingPage.getCountryFilterChartHeaderValue(),countryFilterText,
				"CountryFilterNotApplied");		
		
		
}
	
	
	@DataProvider(name = "Testdata_For_Filter_Scenarios")
	public Object[][] passData() throws IOException, ParseException {
		return JsonReader.getdata(
				System.getProperty("user.dir") + "//TestData//"
						+ "//Test_Data_For_Tc_02_Verify_Filter_Scenario.json",
				"Test_Data_For_Filter_Scenarios", 1, 4);

	}
	
	


}
