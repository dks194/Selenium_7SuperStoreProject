package testClasses;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.ListProductsPage;
import elementRepository.LoginPage;

public class ListProductsTestClass extends BaseClass {

	LoginPage lp;
	DashboardPage dash;
	ListProductsPage listProducts;

	@Test
	public void verifyTheSearchProductIsPresentInTheList() {
		lp = new LoginPage(driver);
		dash = lp.login("admin", "admin");
		
		//dash = new DashboardPage(driver);not required
		listProducts = dash.clickOnManageProducts();
		// ListProductsPage listProducts = new ListProductsPage(driver);not required
		listProducts.productSearch("454");
		String actual_Result = listProducts.getTextOfSearchedProduct();
		Assert.assertTrue(actual_Result.contains("Harpic Powerplus Original Toilet Cleaner") && actual_Result.contains("454"));
		// Assert.assertEquals(actual_Result, "Harpic Powerplus Original Toilet Cleaner,200 ml P454");
		System.out.println("Title of the product : " + actual_Result);

	}
	
	@Test
	public void verifyAllOptionFromTheCategoryDropdown() {
		lp = new LoginPage(driver);
		dash = lp.login("admin", "admin");
		listProducts = dash.clickOnManageProducts();
		listProducts.productSearchButtonClick();
		List<String> actual_options=listProducts.getAllOptionsFromCategoryDropdown();
		List<String> expected = Arrays.asList("Select", "veggies", "Accessories", "Fresh_fruits", "Toys", "Vegetables", "burger", "Kala", "Electronics", "non veg", "Beetroot", "Pen130125063755kp", "Have a nice day", "biscuit", "DriedFruitsm", "Edited211224025455", "Rose", "Mary", "Card070125075222", "Card070125075324", "Card070125075525", "Card070125075616", "iphone", "Beetroot", "Icecream", "avcmmmmmmmmmmmm", "Card070125080848","Card080125083926", "Card080125115306", "Card080125115422", "MacBook", "Card080125120246", "Card080125015229", "Electronic_Device090125091347"," Card090125015659", "DriedFruits120125114847", "Card120125065324kp", "phone120125075428", "test", "Pen120125102413kp", "SamSung_S24_Ultra_8281SamSung_S24_Ultra_New", "qwertyu", "Private JOBS", "bagsling bag120325105433MobileMobileMobile"," Mobile120325050407MobileMobileMobileMobile"," Mobile", "sling bag130325073249", "sling bag130325104504Mobile010170053000", "Mobile130325110520010170053000Mobile010170053000Mobile010170053000Mobile010170053000", "Mobile010170053000Mobile010170053000", "Mobile010170053000", "jewels", "BeautyProducts", "Private JOBS", "Private JOBS", "Private JOBS", "Pen130125124333kp", "jewellery140125075343", "Laysgree", "Pen150125082812new", "SamSung_S24_Ultra_8281_New", "jewellery160125100552", "SamSung_S24_Ultra_8281_New", "Pen220125060613new", "Fashion190225032014", "Fashion010325113025", "HandBagsMobile010170053000", "IT JOBS");
		System.out.println("Count : "+expected.size());
		Assert.assertEquals(actual_options, expected);
		System.out.println(listProducts.getAllOptionsFromCategoryDropdown());
	}
}
