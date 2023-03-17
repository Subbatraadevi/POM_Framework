package com.aliexpress.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/***
 * To log the TestNG ItestListener
 * @author manikandamani
 *
 */
public class Listener implements ITestListener {

	 @Override		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub	
		 
		 System.out.println("TestNg finished ");		
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	    	System.out.println("TestNg  started");		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult tr) {					
	        // TODO Auto-generated method stub	
	    	System.out.println("The name of the testcase failed is :"+tr.getName());					
	        		
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult tr) {					
	        // TODO Auto-generated method stub				
	    	System.out.println("The name of the testcase Skipped is :"+tr.getName());   		
	    }		

	    @Override		
	    public void onTestStart(ITestResult arg0) {					
	        // TODO Auto-generated method stub	
	    	
	    	System.out.println("TestNg Test cases started");
	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	    	System.out.println("TestNg Test cases completed");		
	    }	

}
