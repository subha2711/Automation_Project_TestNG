package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TestPage;
import util.BrowserFactory;

public class AddingCategoryTest {

	WebDriver driver;
	TestPage tp;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.init();
		tp = PageFactory.initElements(driver, TestPage.class);
	}

	@Test(priority=1)
	public void validateUserIsableToAddCategoryAndItisDisplayed() {
		tp.addinNewCategory();
	}
@Test(priority=2)
public void validAddCategoryAlreadyExists() {
	tp.addcategoryAlreadyExists();
}

@Test(priority=3)
public void validateAllOptionsFromMonthDropDown() {
	tp.selectAllOptionFromDropDown();
}
	 @AfterMethod
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}
}
