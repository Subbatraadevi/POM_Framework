package com.aliexpress.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/***
 * To set e Extent report
 * 
 * @author Subbatraadevi
 *
 */
public class Reporting {

	/***
	 *  To log the extent report
	 * @param driver  driver info
	 * @param logger logger info
	 * @param status  status of the test cases
	 * @param message  message need to write
	 * @param fileName  screenshot filename
	 * @throws Exception any failures
	 */
	public void logPortalExtentreport(WebDriver driver, ExtentTest logger, String status, String message,
			String fileName) throws Exception {

		switch (status) {

		case "PASS":
			String screenShotPath = null;
			try {
				screenShotPath = getScreenShotForPortal(driver, fileName);
				logger.log(LogStatus.PASS, message);
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath));

			break;

		case "FAIL":

			screenShotPath = null;
			try {
				screenShotPath = getScreenShotForPortal(driver, fileName);
				logger.log(LogStatus.FAIL, message);
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShotPath));

			break;

		case "INFO":
			logger.log(LogStatus.INFO, message);

			break;

		case "SKIP":
			logger.log(LogStatus.SKIP, message);

			break;

		case "WARNING":
			logger.log(LogStatus.WARNING, message);

			break;
		default:
			break;
		}

	}

	/***
	 *  To take screen shot
	 * @param driver  driver info
	 * @param screenShotName screenshot name
	 * @return  screenshot
	 * @throws Exception any failures
	 * 
	 */
	public String getScreenShotForPortal(WebDriver driver, String screenShotName) throws Exception {

		// this.mapData=MedHOKProperties.getProperties(0);
		String destination, screenshotDestination;

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("MM_dd_YYYY_HH_mm");
		Date dt = new Date();
		Calendar c = Calendar.getInstance();

		c.setTime(dt);
		c.add(Calendar.DATE, 0);
		c.add(Calendar.MINUTE, 0);
		dt = c.getTime();
		String date1 = formatter.format(dt);

		// String report=mapData.get("Report_Path");
		// String currentPath=System.getProperty(".");

		String Screenshotpath = "./Test Resutls";

		destination = Screenshotpath + "/" + screenShotName + date1 + ".png";
		screenshotDestination = "./" + screenShotName + date1 + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return screenshotDestination;
	}

	/***
	 *  To teardown the extent report
	 * @param extent extent report
	 * @param TestName test name
	 */
	public static void endExtentTest(ExtentReports extent, ExtentTest TestName) {

		extent.endTest(TestName);
		extent.flush();

	}

}
