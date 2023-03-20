package com.aliexpress.actions;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import com.aliexpress.Pages.ProductPage;
import com.aliexpress.utilities.BrowserUtils;
import com.aliexpress.utilities.Driver;
import com.aliexpress.utilities.Reporting;

/***
 * To write methods for product page objects
 * 
 * @author Subbatraadevi
 *
 */

public class ProductPageAction extends ProductPage {

	Reporting report = new Reporting();

	/***
	 * To verify product description
	 * 
	 * @throws Exception any failures
	 */
	public void fn_productDescription() throws Exception {
		try {
			BrowserUtils.waitForPageToLoad(15);
			JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
			js.executeScript("scroll(0, 700)");
			// js.executeScript("arguments[0].scrollIntoView(true);", Productdesc);
			Thread.sleep(501);
			BrowserUtils.waitForVisibility(Productdesc, 25);
			boolean bo_display = Productdesc.isDisplayed();
			if (bo_display)
				report.logPortalExtentreport(Driver.getDriver(), logger, "PASS",
						"Expected :Product description should be displayed successfully  Actual Product description displayed successfully : ", "product description search screen");

		} catch (Exception e) {
			e.printStackTrace();
			report.logPortalExtentreport(Driver.getDriver(), logger, "FAIL",
					"Product description displayed successfully", "product description search screen");
		}
	}

	/***
	 * To verify Product Image
	 * 
	 * @throws Exception any failures
	 */
	public void fn_productImage() throws Exception {
		try {

			boolean bo_display = MagnifierImage.isDisplayed();
			if (bo_display)
				report.logPortalExtentreport(Driver.getDriver(), logger, "PASS", "Expected  : Product image should be  displayed successfully  Actual: Product image displayed successfully",
						"product image search screen");

		} catch (Exception e) {
			e.printStackTrace();
			report.logPortalExtentreport(Driver.getDriver(), logger, "FAIL", "Product image displayed successfully",
					"product image search screen");
		}
	}

	/***
	 * To place the order
	 * 
	 * @throws Exception any failure
	 */
	public void fn_buynow() throws Exception {
		try {

			BuyNow.click();
			
			 ArrayList<String> tabs_windows = new ArrayList<String> (Driver.getDriver().getWindowHandles());
			 Driver.getDriver().switchTo().window(tabs_windows.get(1));
			report.logPortalExtentreport(Driver.getDriver(), logger, "PASS", " Expected :Order Buy Now should be performed successfully   Actual: Order Buy Now  performed successfully ",
					"Order Buy Now screen");

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			report.logPortalExtentreport(Driver.getDriver(), logger, "FAIL", "Order Buy Now  not performed",
					"Order Buy Now screen");
		}
	}

}
