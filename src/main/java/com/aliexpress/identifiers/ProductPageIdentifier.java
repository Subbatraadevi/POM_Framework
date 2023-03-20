package com.aliexpress.identifiers;

/***
 * To keep locators in Ali express Product Page
 * 
 * @author Subbatraadevi
 *
 */
public class ProductPageIdentifier {

	public static final String str_BuyNowButtonIdentifier = "(//button[text()='Buy Now'])[1]";
	public static final String str_AddtoCartButtonIdentifier = "(//button[text()='Add to Cart'])[last()]";
	public static final String str_MagnifierImageIdentifier = "//div[@class='image-view-magnifier-wrap']";
	public static final String str_ProductDescriptionIdentifier = "//div[@id='product-description']";

}
