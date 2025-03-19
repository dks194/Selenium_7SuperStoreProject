package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CategoryPage {
	WebDriver driver;
	GeneralUtilities utilities = new GeneralUtilities();
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@onclick,'click_button(1)')]")
	WebElement newButton;
	@FindBy(xpath="//input[@id='category']")
	WebElement categorytextBox;
	@FindBy(xpath="//li[@id='134-selectable']")
	WebElement discountGroup;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	WebElement caegoryCreationSuccessMesssage;
	
	
	/*
	 * public void addCategory(String categoryName,String filePath) {
	 * newButton.click(); String renadomCategoryName =
	 * categoryName+utilities.createRandomNumber_Utility();
	 * categorytextBox.sendKeys(renadomCategoryName); discountGroup.click();
	 * utilities.fileUpload(chooseFileButton, filePath);
	 * utilities.scrollIntoViewUsingJavaScriptExecutor(saveButton,driver );
	 * utilities.clickUsingJavaScriptExecutor(saveButton,driver);
	 * 
	 * }
	 */
	
	public void addCategory(String categoryName) {
		newButton.click();
		categorytextBox.sendKeys(categoryName);
		utilities.scrollIntoViewUsingJavaScriptExecutor(saveButton,driver );
		utilities.clickUsingJavaScriptExecutor(saveButton,driver);
		//saveButton.click();
		
		
	}
	
	public String successMessageAfterCategoryCreation() {
		return utilities.getTextOfElement(caegoryCreationSuccessMesssage);
	}
	
	
}
