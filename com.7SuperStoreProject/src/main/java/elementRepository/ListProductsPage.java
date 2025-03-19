package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ListProductsPage {
	
	WebDriver driver;
	GeneralUtilities utilities = new GeneralUtilities();
	
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchButton;
	
	@FindBy(xpath = "//input[@placeholder='Product Code']")
	WebElement productCodeTextBox;
	
	@FindBy(xpath = "//button[@name='Search']")
	WebElement productSearchButton;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	WebElement searchProductTitle;
	
	@FindBy(id = "cat_id")
	WebElement categoryDropdown;
	
	public ListProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void productSearch(String productCode) {
		utilities.clickOnAnElement(searchButton);	
		productCodeTextBox.sendKeys(productCode);
		utilities.clickOnAnElement(productSearchButton);
	}
	
	public void productSearchButtonClick() {
		utilities.clickOnAnElement(searchButton);	
		
	}
	
	
	
	public String getTextOfSearchedProduct() {
		return utilities.getTextOfElement(searchProductTitle);
	}
	
	public List<String> getAllOptionsFromCategoryDropdown(){
		return utilities.getAllOptions(categoryDropdown);
	}
	
	
	

}
