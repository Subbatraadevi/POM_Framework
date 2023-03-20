package com.aliexpress.actions;

import java.util.ArrayList;

import com.aliexpress.Pages.SearchPage;
import com.aliexpress.utilities.Driver;
import com.aliexpress.utilities.Reporting;

/***
 *  To Write methods for Search page objects
 * @author Subbatraadevi
 *
 */


public class SearchPageAction extends SearchPage {
	
	Reporting report = new Reporting();
	/***
	 * To verify search result count
	 * @return search result  value
	 * @throws Exception any error
	 */
	public String fn_searchResultcount() throws Exception {
		try {

			String count =BreadCrum.getText();
			if(count != null) 
		
			report.logPortalExtentreport(Driver.getDriver(), logger, "PASS", "Expectd :search result should be displayed successfully  Actual :search result displayed successfully and values is  "+count, "search result  screen");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			report.logPortalExtentreport(Driver.getDriver(), logger, "FAIL", "search result not displayed " , "seach result  screen");
			return null;
		}
	}
/***
 * To select first product in search result page
 * @throws Exception any failures
 */
	public void fn_selectfirstproduct() throws Exception {
		try {

			firstproduct.click();
			
			 ArrayList<String> tabs_windows = new ArrayList<String> (Driver.getDriver().getWindowHandles());
			 Driver.getDriver().switchTo().window(tabs_windows.get(1));
		
			report.logPortalExtentreport(Driver.getDriver(), logger, "PASS", "Expected :First product should be selected successfully  Actual : First product selected successfully", "first product");
			
		} catch (Exception e) {
			e.printStackTrace();
			report.logPortalExtentreport(Driver.getDriver(), logger, "FAIL", "first product selected not selected " , "first product");
			
		}
	}

	
}
