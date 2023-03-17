package aliexpress.tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
/***
 * To setup runnar jar file
 * @author Manikandamani
 *
 */
public class Runner {
	/***
	 * To Create Runnable /Executable jar
	 * @param args
	 */
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { AliExpressWorkflow.class });
		testng.addListener(tla);
		testng.run();
		}
}
