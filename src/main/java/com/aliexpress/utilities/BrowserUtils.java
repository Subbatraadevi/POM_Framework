package com.aliexpress.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 *  To keep Browser related resuable metthod
 * @author manikandamani
 *
 */
public class BrowserUtils {
	
	
	/***
	 *  Action move to element and do right click
	 * @param targetElement  webelement
	 */
	public static void moveToElementandContextClick(WebElement targetElement)
	{
		Actions action =new Actions(Driver.getDriver());
		action.moveToElement(targetElement).contextClick().build().perform();
	}

	/***
	 *  Action move to element and do  click
	 * @param targetElement
	 */
	public static void moveToElementandClick(WebElement targetElement)
	{
		Actions action=new Actions(Driver.getDriver());
		action.moveToElement(targetElement).click().build().perform();
		System.out.println("clicked");
	}
	
	
	/***
	 *  Action move to element 
	 * @param element
	 */
	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}

	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return list
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

		/***
	 *  To wait for visibility of element
	 * @param element
	 * @param timeToWaitInSec
	 * @return 
	 */
	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
		try {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			return null;
		}
	}
	/***
	 *  To wait fore element to be clickable
	 * @param element
	 * @param timeout
	 * @return
	 */
	public  WebElement waitForClickablility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

		/***
	 *  To wait for page to load completetly
	 * @param timeOutInSeconds
	 */
	public static void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
		//	System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println(
					"Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		}
	}

		

		
	
}
