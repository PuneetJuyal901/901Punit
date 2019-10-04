package login;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.base.JsonReader;
import com.framework.base.LocalBrowserInitialzation;
import com.framework.helper.AssertionHelper;
import com.test.lanalabs.base.TestBase;
import com.test.lanalabs.pages.LoginPage;

import bsh.ParseException;

public class Verify_Login_Scenario extends TestBase {

	@Test(priority = 0, dataProvider = "Testdata_Invalid_Email_Password")
	public void verify_if_user_get_the_error_message_with_invalid_username_and_password(String userName,
			String password, String ErrorMessage) {

		LoginPage homepage = new LoginPage(LocalBrowserInitialzation.driver);
		homepage.userEnterEmailAndPassword(userName, password).clickOnSignButton();

		AssertionHelper.softAssertToCompareString(homepage.errorMessageWhileGivingInvalidDetails(), ErrorMessage,
				"verify_if_user_get_the_error_message_with_invalid_username fail");
	}

	@Test(priority = 1, dataProvider = "Testdata_Valid_Email_And_Case_Sensative_Password")
	public void verify_if_user_not_able_to_login_when_password_is_case_sensitve(String userName, String password,
			String errorMessage) {

		LoginPage homepage = new LoginPage(LocalBrowserInitialzation.driver);
		homepage.userEnterEmailAndPassword(userName, password).clickOnSignButton();
		AssertionHelper.softAssertToCompareString(homepage.errorMessageWhileGivingInvalidDetails(), errorMessage,
				"verify_if_user_not_able_to_login_when_password_is_case_sensitve fail");

	}

	@Test(priority = 2, dataProvider = "Testdata_Valid_Passsword_And_Case_Sensative_Email")
	public void verify_if_user_able_to_login_when_email_is_case_sensitive(String email, String password,
			String landingPagePopText) {

		LoginPage homepage = new LoginPage(LocalBrowserInitialzation.driver);
		AssertionHelper.softAssertToCompareString(
				homepage.userEnterEmailAndPassword(email, password).clickOnSignButton().getLandingPagePopUpText(),
				landingPagePopText, "LandingPage popup text not matching for casesSensative email");
	}

	@Test(priority = 3, dataProvider = "Testdata_For_Valid_Email_Password")
	public void verify_if_user_able_to_login_with_valid_credentials(String email, String password,
			String landingPagePopText) {

		LoginPage homepage = new LoginPage(LocalBrowserInitialzation.driver);
		AssertionHelper.softAssertToCompareString(
				homepage.userEnterEmailAndPassword(email, password).clickOnSignButton().getLandingPagePopUpText(),
				landingPagePopText, "LandingPage popup text not matching");

	}

	@DataProvider(name = "Testdata_Invalid_Email_Password")
	public Object[][] passData1() throws IOException, ParseException {
		return JsonReader.getdata(
				System.getProperty("user.dir") + "//TestData//"
						+ "//Test_Data_For_Tc_01_Verify_Login_Scenario_invalid_user_and_password.json",
				"TestData_for_invalid_username_password", 1, 3);

	}

	@DataProvider(name = "Testdata_Valid_Email_And_Case_Sensative_Password")
	public Object[][] passData2() throws IOException, ParseException {
		return JsonReader.getdata(System.getProperty("user.dir") + "//TestData//"
				+ "//Test_Data_For_Tc_01_Verify_Login_Scenario_with_valid_email_but_case_Sesative_password.json",
				"TestData_For_Valid_email_case_sensative_password", 1, 3);

	}

	@DataProvider(name = "Testdata_Valid_Passsword_And_Case_Sensative_Email")
	public Object[][] passData3() throws IOException, ParseException {
		return JsonReader.getdata(System.getProperty("user.dir") + "//TestData//"
				+ "//Test_Data_For_Tc_01_Verify_Login_Scenario_With_Valid_Password_And_Case_Sensative_Email.json",
				"TestData_For_Valid_Password_But_Case_Sensative_Email", 1, 3);

	}

	@DataProvider(name = "Testdata_For_Valid_Email_Password")
	public Object[][] passData4() throws IOException, ParseException {
		return JsonReader.getdata(
				System.getProperty("user.dir") + "//TestData//"
						+ "//Test_Data_For_Tc_01_Verify_Login_Scenario_Valid_User_And_Password.json",
				"TestData_for_valid_username_password", 1, 3);

	}
}
