package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int initialRetryCount=0;//this applied when a testcase fail
	private static final int maxRetryCount=3;  //how many times we want to rerun
	
	
	@Override
	public boolean retry(ITestResult result) {
		if (initialRetryCount  <maxRetryCount) {
			initialRetryCount++;
			return true;
		}
		return false;
	}
  
}
