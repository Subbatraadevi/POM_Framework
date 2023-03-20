package com.aliexpress.Pages;

/***
 *  To initialize elements of Home Page identifier
 * @author Subbatraadevi
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aliexpress.identifiers.ProductPageIdentifier;
import com.aliexpress.testbase.TestBase;
import com.aliexpress.utilities.Driver;
/***
 * product page
 * @author Subha
 *
 */
public class ProductPage extends TestBase {

	public ProductPage() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = ProductPageIdentifier.str_BuyNowButtonIdentifier)
	public WebElement BuyNow;

	@FindBy(xpath = ProductPageIdentifier.str_AddtoCartButtonIdentifier)
	public WebElement AddtoCart;

	@FindBy(xpath = ProductPageIdentifier.str_MagnifierImageIdentifier)
	public WebElement MagnifierImage;

	@FindBy(xpath = ProductPageIdentifier.str_ProductDescriptionIdentifier)
	public WebElement Productdesc;

}
