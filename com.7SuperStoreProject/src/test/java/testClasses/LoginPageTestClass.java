package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProviders.DataProviderClass;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;

public class LoginPageTestClass extends BaseClass {
	
	LoginPage lp;
	DashboardPage dash; 
	@Test
	public void verifyTheExactPageIsOpenWhileHittingThe_URL() {

		LoginPage lp = new LoginPage(driver);
		/*
		 * String actual_Title=lp.getTitleOfLoginPage();
		 * System.out.println("Title of the page : "+lp.getTitleOfLoginPage());
		 * Assert.assertEquals(actual_Title, "Login | 7rmart supermarket");
		 */

		String actual_Title = lp.getTextOf7martHeading();
		Assert.assertEquals(actual_Title, "7rmart supermarket");
		System.out.println("Title of the page : " + actual_Title);

	}
	
	@Test
	public void verifySuccessfulLoginPage() {
		lp=new LoginPage(driver);
		dash=lp.login("admin", "admin");
		String actual_Result = dash.getTextOfAdmin();
		Assert.assertEquals(actual_Result, "Admin");
		System.out.println(actual_Result);
		
	}
	
	@Test(dataProviderClass = DataProviderClass.class,dataProvider = "unsuccessfulLogin")
	public void verifyUnsuccessfulLogin(String userN,String passwrd) {
		lp=new LoginPage(driver);
		lp.login(userN, passwrd);
		String actualResult = lp.getTextOferrorMessage();
		Assert.assertTrue(actualResult.contains("Invalid Username/Password"));
	}
	
	@Test
	public void verifyRememberMeCheckboxIsCheckedOrNotByDefault() {
		lp=new LoginPage(driver);
		boolean actual_Result = lp.isRememberMeCheckboxSelected();
		Assert.assertFalse(actual_Result);
		System.out.println("Remember Me Checkbox is checked by default : "+actual_Result );
	}

}
