package com.aliexpress.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aliexpress.managers.PageObjectmanager;
import com.aliexpress.utilities.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static boolean executionmode;
	PageObjectmanager pages = new PageObjectmanager();

	/***
	 * To invoke browser and environment , delete test result folder
	 */
	@BeforeSuite(alwaysRun = true)
	public void presetup() {
		loadconfig();
		Driver.browserdriver(prop.getProperty("browser"));
		Driver.getDriver().get(prop.getProperty("url"));
		deleteDirectory(new File("./Test Resutls"));
	}
	
	@BeforeMethod
	public void closepopup() {
		
		pages.getHomePage().fn_closePopup();
		
	}

	/***
	 * To setup the extent report
	 */
	@BeforeClass(alwaysRun = true)
	public void classsetup() {
		extent = new ExtentReports("./Test Resutls/AliExpress_flow.html", true);
		extent.loadConfig(new File("extent-config.xml"));
		logger = extent.startTest("AliExpress Flow Validaton");
	}

	/***
	 * To delete previous run result
	 * 
	 * @param dir folder directory
	 * @return deletion status
	 */
	public static boolean deleteDirectory(File dir) {
		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (int i = 0; i < children.length; i++) {
				boolean status = deleteDirectory(children[i]);
				if (!status)
					return false;
			}
		}

		return dir.delete();
	}

	/***
	 * To Load properties value
	 */
	public static void loadconfig() {
		File file = new File("./TestData/EnvironmentData.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***
	 * To flush the extent report,close the drivers and pages reset
	 */
	@AfterSuite(alwaysRun = true)
	public void teardown() {
		Driver.closeDriver();
		extent.flush();
		pages.reset();
	}

}
