package listeners;

import annotations.FrameworkAnnotation;
import org.testng.*;
import reports.ExtentReport;
import reports.FrameworkLogger;
import utils.Log;

import java.util.Arrays;

import static enums.LogType.*;

public class ListenerClass implements ITestListener, ISuiteListener {

    /**
     * This method is invoked before the SuiteRunner starts.
     *
     * @param suite
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();

    }

    /**
     * This method is invoked after the SuiteRunner has run all
     * the test suites.
     *
     * @param suite
     */
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    /**
     * Invoked each time before a test will be invoked.
     * The <code>ITestResult</code> is only partially filled with the references to
     * class, method, start millis and status.
     *
     * @param result the partially filled <code>ITestResult</code>
     * @see ITestResult#STARTED
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .category());
        Log.info(result.getMethod().getMethodName() +" test is starting.");
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        //ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
        FrameworkLogger.log(PASS,result.getMethod().getMethodName() +" is passed");
        Log.info(result.getMethod().getMethodName() + "test is succeed.");
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    @Override
    public void onTestFailure(ITestResult result) {
        FrameworkLogger.log(FAIL,result.getMethod().getMethodName() +" is failed");
        FrameworkLogger.log(FAIL,result.getThrowable().toString());
        Log.error(result.getMethod().getMethodName() + "test is failed.");
        //FrameworkLogger.log(FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        FrameworkLogger.log(SKIP,result.getMethod().getMethodName() +" is skipped");
    }

    /**
     * Invoked each time a method fails but has been annotated with
     * successPercentage and this failure still keeps it within the
     * success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    /**
     * Invoked after the test class is instantiated and before
     * any configuration method is called.
     *
     * @param context
     */
    @Override
    public void onStart(ITestContext context) {
        Log.info("Iam on Start method -> "+ context.getName());
        //context.setAttribute("WebDriver",this.driver);
    }

    /**
     * Invoked after all the tests have run and all their
     * Configuration methods have been called.
     *
     * @param context
     */
    @Override
    public void onFinish(ITestContext context) {
        Log.info("Iam in onFinish method -> "+ context.getName());

    }
}
