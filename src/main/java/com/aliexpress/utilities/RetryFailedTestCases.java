package com.aliexpress.utilities;


import org.testng.ITestResult;
/***
 * To retry analyzer
 * @author Manikandamani
 *
 */
 interface IRetryAnalyzer {
 
  /**
   * Returns true if the test method has to be retried, false otherwise.
   *
   * @param result The result of the test method that just ran.
   * @return true if the test method has to be retried, false otherwise.
   */
  public boolean retry(ITestResult result);
}