package retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class RetryListener implements IAnnotationTransformer {
	
  @Override
  public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod) {
	  annotation.setRetryAnalyzer(RetryAnalyzer.class);
	  //ITestAnnotation -- to represent @Test annotations
	  //Class  --- to represent test classes
	  //Constructor --- to represent test constructor,null if test constructor is not present,its optional
	  //Method --------to get the details of test methods
	  //IAnnotationTransformer ---- testNg Listener which is used to apply automatic retry mechanism globally
	  
  }
}
