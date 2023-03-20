package com.aliexpress.Pages;

/***
 *  To initialize elements of Home Page identifier
 * @author Subbatraadevi
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aliexpress.identifiers.HomePageIdentifiers;
import com.aliexpress.testbase.TestBase;
import com.aliexpress.utilities.Driver;
/***
 * Home page
 * @author Subha
 *
 */
public class HomePage extends TestBase {

	public HomePage() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = HomePageIdentifiers.str_SearchboxIdentifier)
	public WebElement searchBox;

	@FindBy(xpath = HomePageIdentifiers.str_SearchbuttonIdentifier)
	public WebElement searchButton;

	@FindBy(xpath = HomePageIdentifiers.str_CategorieslistIdentifier)
	public WebElement categorieslist;

	@FindBy(xpath = HomePageIdentifiers.str_popupCloseIdentifier)
	public WebElement popcloseButton;
}
