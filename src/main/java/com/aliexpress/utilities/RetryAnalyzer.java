package com.aliexpress.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 /***
  * To Implement Rerun for failed cases
  * @author Admin
  *
  */
public class RetryAnalyzer implements IRetryAnalyzer {
 
 int counter = 0;
 int retryLimit = 4;
 
 
 /***
  * This method decides how many times a test needs to be rerun.
  */
 @Override
 public boolean retry(ITestResult result) {
 
 if(counter < retryLimit)
 {
 counter++;
 return true;
 }
 return false; }
}
