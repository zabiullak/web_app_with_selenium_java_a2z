package reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {

    private ExtentManager() {}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

    static ExtentTest getExtentTest() {
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        if(Objects.nonNull(test)) {
            extTest.set(test);
        }
    }

    static void unload() {
        extTest.remove();
    }
}
