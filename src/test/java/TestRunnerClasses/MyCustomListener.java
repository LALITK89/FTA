package TestRunnerClasses;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyCustomListener implements ITestListener
{

 
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test Passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test Failed: " + result.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("All tests finished. Total tests: " + context.getAllTestMethods().length);
	    }
	}
