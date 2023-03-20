package com.aliexpress.managers;

import com.aliexpress.actions.HomePageAction;
import com.aliexpress.actions.ProductPageAction;
import com.aliexpress.actions.SearchPageAction;

/***
 * Creating Object for each class in the action package
 * 
 * @author Subbatraadevi
 *
 */
public class PageObjectmanager {
	 
	private HomePageAction homePage;
	private ProductPageAction productPage;
	private SearchPageAction searchPage;

	public HomePageAction getHomePage() {
		return (homePage == null) ? homePage = new HomePageAction() : homePage;

	}
	public ProductPageAction getProductPage() {
		return (productPage == null) ? productPage = new ProductPageAction() : productPage;

	}
	
	public SearchPageAction getSearchPage() {
		return (searchPage == null) ? searchPage = new SearchPageAction() : searchPage;

	}
	/***
	 *  To make page object to null
	 */
	public void reset() {
		homePage= null;
		productPage=null;
		searchPage=null;
	}
}
