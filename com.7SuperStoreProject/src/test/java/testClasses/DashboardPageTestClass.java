package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.ListProductsPage;
import elementRepository.LoginPage;

public class DashboardPageTestClass extends BaseClass {

	LoginPage lp;
	DashboardPage dash;
	ListProductsPage listProducts;

	@Test
	public void VerifyAllTilesInDashboardPageAreDisplayed() {
		lp = new LoginPage(driver);
		dash = lp.login("admin", "admin");
		boolean actualResult = dash.isAllTilesDisplayed();
		Assert.assertTrue(actualResult);
		System.out.println(actualResult);

	}
	
	@Test
	public void verifyTheListProductsPageIsOpenedWhileClickingOn_ManageProducts() {
		lp = new LoginPage(driver);
		dash = lp.login("admin", "admin");
		dash = new DashboardPage(driver);
		listProducts=dash.clickOnManageProducts();	 
		Assert.assertEquals(driver.getCurrentUrl(), "https://groceryapp.uniqassosiates.com/admin/list-product");
		System.out.println("List Product page URL : "+driver.getCurrentUrl());
	}
}
