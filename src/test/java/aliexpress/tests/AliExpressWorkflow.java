package aliexpress.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aliexpress.managers.PageObjectmanager;
import com.aliexpress.testbase.TestBase;
import com.aliexpress.utilities.BrowserUtils;
import com.aliexpress.utilities.Driver;
import com.aliexpress.utilities.ExcelUtils;

/***
 * To validate aliexpress functionalities
 * 
 * @author Admin
 *
 */
public class AliExpressWorkflow extends TestBase {

	public String str_count;

	PageObjectmanager pages = new PageObjectmanager();
	ExcelUtils excelutils = new ExcelUtils("./TestData/Product_TestData.xls", "Input");

	/***
	 * To search a product
	 * 
	 * @throws Exception
	 */
	@Test(priority = 0, groups = { "regression", "smoke" })
	public void searchproduct() throws Exception {
		try {
			pages.getHomePage().fn_closePopup();
			pages.getHomePage().fn_searchProduct(excelutils.getCellData(1, 0));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * Close the popup which occurs randomly
	 */
	@Test(invocationCount=10,priority = 1)
	public void closepopup() {
		pages.getHomePage().fn_closePopup();
	}

	/***
	 * To validate search result count
	 * 
	 * @throws Exception any failures
	 */
	
	@Test(priority = 1, dependsOnMethods = { "searchproduct" }, groups = { "regression", "smoke" },retryAnalyzer = com.aliexpress.utilities.RetryAnalyzer.class)
	public void searchresultpagevalidation() throws Exception {
		
		str_count = pages.getSearchPage().fn_searchResultcount();
		System.out.println(str_count);

	}

	/***
	 * To validate product page
	 * 
	 * @throws Exception any failures
	 */
	@Test(priority = 2, dependsOnMethods = { "searchresultpagevalidation" }, groups = { "regression", "smoke" })
	public void productpagevalidation() throws Exception {

		
		pages.getSearchPage().fn_selectfirstproduct();
		BrowserUtils.waitForPageToLoad(15);
		pages.getProductPage().fn_productDescription();
		pages.getProductPage().fn_productImage();

	}

	/***
	 * To order the product
	 * 
	 * @throws Exception any failures
	 */
	@Test(priority = 4, dependsOnMethods = { "productpagevalidation" }, groups = { "regression", "smoke" })
	public void Buytheproductproductpagevalidation() throws Exception {
		//pages.getHomePage().fn_closePopup();
		pages.getProductPage().fn_buynow();

	}

	/***
	 * To verify product image
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5, dependsOnMethods = { "productpagevalidation" }, groups = { "regression" })
	public void verifyproductimage() throws Exception {
		pages.getHomePage().fn_closePopup();
		pages.getProductPage().fn_productImage();

	}

}
