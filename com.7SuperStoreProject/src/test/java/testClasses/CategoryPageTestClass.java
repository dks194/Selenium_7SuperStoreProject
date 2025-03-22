package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProviders.DataProviderClass;
import elementRepository.CategoryPage;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.RandomDataUtility;

public class CategoryPageTestClass extends BaseClass {
	
	LoginPage lp;
	DashboardPage dash;
	CategoryPage categoryPage;
	
	 @Test(dataProviderClass = DataProviderClass.class,dataProvider = "successfulLogIn",groups={"Group1"})
	 
 
	 public void verifyTheAddCategoryFunctionality(String uName,String pW) {
		  lp = new LoginPage(driver);
		  dash = lp.login(uName, pW);
		  categoryPage = dash.navigateToCategoryPage();
		  String rancategoryName =RandomDataUtility.getCategoryName();
		  System.out.println("Random category name : "+rancategoryName);
		  categoryPage.addCategory(rancategoryName);
		  
		  //categoryPage.addCategory("mouse","C:\\Users\\REKHA PM\\Desktop\\ComputerMouse.jpeg");//change
		  String actual_SuccessMessage = categoryPage.successMessageAfterCategoryCreation();
		  System.out.println("Message After category Creation:" +actual_SuccessMessage);
		  Assert.assertTrue(actual_SuccessMessage.contains("Category Created Successfully"));
		  
	  }
}
