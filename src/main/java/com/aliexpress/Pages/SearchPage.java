package com.aliexpress.Pages;

/***
 *  To initialize elements of Home Page identifier
 * @author Manikandamani
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aliexpress.identifiers.SearchPageIdentifiers;
import com.aliexpress.testbase.TestBase;
import com.aliexpress.utilities.Driver;

public class SearchPage extends TestBase {

	public SearchPage() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = SearchPageIdentifiers.str_BreadCrumResutIdentifier)
	public WebElement BreadCrum;

	@FindBy(xpath = SearchPageIdentifiers.str_displaySizecheckboxIdentifier)
	public WebElement Displaysize;

	@FindBy(xpath = SearchPageIdentifiers.str_FirstProductIdentifier)
	public WebElement firstproduct;

}
