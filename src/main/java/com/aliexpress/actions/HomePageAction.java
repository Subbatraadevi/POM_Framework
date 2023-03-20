package com.aliexpress.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.aliexpress.Pages.HomePage;
import com.aliexpress.utilities.BrowserUtils;
import com.aliexpress.utilities.Driver;
import com.aliexpress.utilities.Reporting;


/***
 * To write methods for Home page objects
 * 
 * @author Subbatraadevi
 *
 */

public class HomePageAction extends HomePage {

	Reporting report = new Reporting();

	/***
	 * To search product in home page
	 * 
	 * @param Product product need to search
	 * @throws Exception to check any failures
	 */
	public void fn_searchProduct(String Product) throws Exception {
		try {

			searchBox.sendKeys(Product);
			searchButton.click();
			
			Assert.assertEquals(Driver.getDriver().getTitle(), "Computer � Buy Computer with free shipping on AliExpress version");
			report.logPortalExtentreport(Driver.getDriver(), logger, "PASS", "Expected :Product should be searched successfully Actual:Product searched successfully ",
					"product search screen");

		} catch (Exception e) {
			e.printStackTrace();
			report.logPortalExtentreport(Driver.getDriver(), logger, "FAIL", "Product search failed",
					"product search screen");
		}
	}

	/***
	 * To close the intermediate popup dialogue box
	 */
	public void fn_closePopup() {
		try {
			
			if(Driver.getDriver().findElements(By.xpath("//a[text()='x']")).size()>0) {
			BrowserUtils.waitForVisibility(popcloseButton, 5);
			popcloseButton.click();
			}
			executionmode = true;

		} catch (NoSuchElementException e) {
			// e.printStackTrace();
			executionmode = false;
		}
	}

}
