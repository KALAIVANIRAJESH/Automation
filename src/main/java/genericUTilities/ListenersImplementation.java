package genericUTilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//@Test - method
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName +" --- Test Execution started --- ");
		
		test = report.createTest(methodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName +" --- Test pass --- ");
		
		test.log(Status.PASS, methodName +" --- Test pass --- ");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName +" --- Test Fail --- ");
		System.out.println(result.getThrowable());
		
		test.log(Status.FAIL, methodName +" --- Test Fail --- ");
		test.log(Status.INFO, result.getThrowable());
		
		//Capture Screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodName+"-"+j.getSystemDate();
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName +" --- Test Skip --- ");
		System.out.println(result.getThrowable());
		
		test.log(Status.SKIP, methodName +" --- Test Skip --- ");
		test.log(Status.INFO, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("--- suite execution started ---");
		
		ExtentSparkReporter htmlrep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlrep.config().setDocumentTitle("Execution Report");
		htmlrep.config().setReportName("Vtiger Report");
		htmlrep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("--- suite execution finished ---");
		
		report.flush();
		
	}
	
	

}
