package pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestPage extends BasePage {

	WebDriver driver;

	public TestPage(WebDriver driver) {
		this.driver = driver;
	}
@FindBy(how = How.CSS, using ="input[name='categorydata']") WebElement addCategory;
@FindBy(how = How.CSS, using ="input[name='submit'][value='Add category']") WebElement addCategoryButton;
@FindBy(how = How.XPATH, using ="//span[contains(text(),'newAutomation')]") WebElement addCategoryButtonDisplayed;
@FindBy(how = How.XPATH, using ="//body[contains(text(),'The category you want to add already exists:')]") WebElement addCategoryAlreadyCreated;
@FindBy(how = How.XPATH, using ="//a[contains(text(),'Yes')]") WebElement addCategoryButtonColor;
@FindBy(how = How.XPATH, using ="//select[@name='due_month']") WebElement dropDownForMonths;
	

public void addinNewCategory() {
	addCategory.sendKeys("newAutomation");
	addCategoryButton.click();
	Assert.assertTrue(addCategoryButtonDisplayed.isDisplayed(), "New category button is displayed");
}

public void addcategoryAlreadyExists() {
	addCategory.sendKeys("newAutomation");
	addCategoryButton.click();
	Assert.assertTrue(addCategoryAlreadyCreated.isDisplayed());
	addCategoryButtonColor.click();
}

public void selectAllOptionFromDropDown() {
	Select sel = new Select(dropDownForMonths);
	List <WebElement>options = sel.getOptions();
	List <String>list = new ArrayList<String>();
	for (WebElement e  : options) {
		list.add(e.getText());
	}
	if(options.size()==list.size()) {
		Assert.assertTrue(true, "All the moth drop down options are available");
	}else {
		Assert.assertTrue(false, "All the moth drop down options are available");
	}
}
}
