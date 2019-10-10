package login;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.framework.base.JsonReader;
import com.framework.base.LocalBrowserInitialzation;
import com.framework.helper.AssertionHelper;
import com.test.lanalabs.base.TestBase;
import com.test.lanalabs.pages.LoginPage;
import com.test.lanalabs.utility.ConfigReader;

import bsh.ParseException;

public class Verify_Login_Scenario extends TestBase {
    
	ConfigReader reader= new ConfigReader();
	@Test(priority = 0, dataProvider = "Testdata_For_Invalid_UserName")
	public void verify_if_user_get_the_error_message_with_invalid_username(String userName,
			String password, String ErrorMessage) {

		LoginPage loginPage = new LoginPage(LocalBrowserInitialzation.driver);
		loginPage.userEnterEmailAndPassword(userName, password).clickOnSignButton();

		AssertionHelper.softAssertToCompareString(loginPage.errorMessageWhileGivingInvalidDetails(), ErrorMessage,
				"verify_if_user_get_the_error_message_with_invalid_username fail for testdata =" + userName
						+ "and password=" + password);
		}
	
	@Test(priority = 1, dataProvider = "Testdata_For_Invalid_CaseSensative_Password")
	public void verify_if_user_get_the_error_message_with_invalid_caseSensative_password(String userName,
			String password, String ErrorMessage) {

		LoginPage loginPage = new LoginPage(LocalBrowserInitialzation.driver);
		loginPage.userEnterEmailAndPassword(userName, password).clickOnSignButton();

		AssertionHelper.softAssertToCompareString(loginPage.errorMessageWhileGivingInvalidDetails(), ErrorMessage,
				"verify_if_user_get_the_error_message_with_invalid_username fail for testdata =" + userName
						+ "and password=" + password);
		}
	
	  @Test(priority = 2, dataProvider = "Testdata_For_Valid_CaseSensativeEmail")
	  public void verify_if_user_able_to_login_with_CaseSensativeEmail(String email,String password, String homePageUrl) { 
		 LoginPage loginPage = new LoginPage(LocalBrowserInitialzation.driver);
	  
	  AssertionHelper.softAssertToCompareString(loginPage.userEnterEmailAndPassword(email,
	  password).clickOnSignButton().getUrlOfTheLoginPage(), homePageUrl,
	  "HomePage Url  not matching for testdata username="+email +"and password="+password);
	  
	  
	  }
	 

	
	  @Test(priority = 3, dataProvider = "Testdata_For_Valid_Credentials")
	  public void verify_if_user_able_to_login_with_valid_credentials(String email,  String password, String homePageUrl) { 
	  LoginPage loginPage = new LoginPage(LocalBrowserInitialzation.driver);
	  AssertionHelper.softAssertToCompareString(loginPage.userEnterEmailAndPassword(email,
	  password).clickOnSignButton().getUrlOfTheLoginPage(), homePageUrl, "HomePage Url  not matching for testdata username="+email
	  +"and password="+password);
	  
	  
	  }
	 

	@DataProvider(name = "Testdata_For_Invalid_UserName")
	public Object[][] passData1() throws IOException, ParseException {
		return JsonReader.getdata(System.getProperty("user.dir")+reader.getLoginSceanrioTestDataJSONPath(),
				reader.getLoginSceanrioTestDataValueForInvalidUserName(), 1, 3);

	}
	
	@DataProvider(name = "Testdata_For_Invalid_CaseSensative_Password")
	public Object[][] passData2() throws IOException, ParseException {
		return JsonReader.getdata(System.getProperty("user.dir")+reader.getLoginSceanrioTestDataJSONPath(),reader.getLoginSceanrioTestDataValueForValidCaseSensativePassword(),
				1, 3);

	}
	
	@DataProvider(name = "Testdata_For_Valid_CaseSensativeEmail")
	public Object[][] passData3() throws IOException, ParseException {
		return JsonReader.getdata(System.getProperty("user.dir")+reader.getLoginSceanrioTestDataJSONPath(),
				reader.getLoginSceanrioTestDataValueForValidCaseSensativeUserName(), 1, 3);

	}
	
	@DataProvider(name = "Testdata_For_Valid_Credentials")
	public Object[][] passData4() throws IOException, ParseException {
		return JsonReader.getdata(System.getProperty("user.dir") + 
				reader.getLoginSceanrioTestDataJSONPath(),reader.getLoginSceanrioTestDataValueForValidCredentials(), 1, 3);

	}
	
	

	
}