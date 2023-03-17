package com.aliexpress.utilities;

import java.util.HashMap;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

/***
 * To initiate Browser Driver
 * 
 * @author Manikandamani
 *
 */
public class Driver {

	private static WebDriver driver;

	
	public static String str_BrowserType;

	/***
	 * To set the browser
	 * 
	 * @param Browser chrome or firefox
	 */
	public static void browserdriver(String Browser) {
		str_BrowserType = Browser;
	}

	/***
	 * To initiate driver based on browsertype
	 * 
	 * @return driver
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			switch (str_BrowserType) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":

				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				WebDriverManager.chromedriver().setup();

				ChromeOptions options = new ChromeOptions();
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.BROWSER, Level.ALL);
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\Test Results");

				options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				options.setExperimentalOption("useAutomationExtension", false);

				// options.addArguments("--start-fullscreen");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				options.addArguments("test-type");
				options.addArguments("allow-running-insecure-content");
				options.addArguments("disable-extensions");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("test-type=browser");

				options.setExperimentalOption("prefs", chromePrefs);

				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			}
		}
		return driver;
	}

	/***
	 * To quite the driver
	 */
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;

		}
	}

	/***
	 * 
	 */
	public static void quitDriver() {
		driver.close();
	}
}
